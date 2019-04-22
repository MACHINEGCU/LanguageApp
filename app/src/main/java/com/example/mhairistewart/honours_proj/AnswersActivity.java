package com.example.mhairistewart.honours_proj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import model.Answer;


public class AnswersActivity extends AppCompatActivity {

    private static final int VERTICAL_ITEM_SPACE = 100;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private String question;
    private RecyclerView.LayoutManager layoutManager;
    private List<Answer> answerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Bundle extras = getIntent().getExtras();
        question = extras.getString("question");
        createDataset();

    }


    public void createDataset() {

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        String myUrl = "https://mhairi-honours-334af.firebaseio.com/longAnswers.json?orderBy=" + "\"question\"" + "&equalTo=" + "\"" + question + "\"";
        String result = "";

        HttpRequest request = new HttpRequest();
        try {
            result = request.execute(myUrl).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        JSONObject json = null;

        try {
            json = new JSONObject(result);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (Iterator<String> it = json.keys(); it.hasNext(); ) {
            String key = it.next();

            try {
                JSONObject responseObject = (JSONObject) json.get(key);
                JSONArray answersArray = (JSONArray) responseObject.get("answers");

                for (int i = 0; i < answersArray.length(); i++) {

                    JSONObject answer = (JSONObject) answersArray.get(i);
                    Answer a = new Answer();
                    a.setAnswerDescription(answer.get("answerDescription").toString());
                    a.setSubTitle(answer.get("subTitle").toString());
                    answerList.add(a);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        mAdapter = new MyAdapter(answerList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));

    }
}
