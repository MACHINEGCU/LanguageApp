package com.example.mhairistewart.honours_proj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import model.Answer;
import model.Answer;


public class AnswersActivity extends AppCompatActivity {

    public ListView listView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<String> myDataset = new ArrayList<String>();
    private String question;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
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

        List<Answer> answerList = new ArrayList<>();
        List<TextView> subTitleList = new ArrayList<>();

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

    }
}
