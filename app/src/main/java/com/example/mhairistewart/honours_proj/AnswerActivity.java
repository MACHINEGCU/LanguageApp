package com.example.mhairistewart.honours_proj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import model.Answer;


public class AnswerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<String> myDataset = new ArrayList<String>();
    private String question;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        question = extras.getString("question");

        createRecyclerDataset();

    }

    public void createRecyclerDataset() {

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        String myUrl = "https://mhairi-honours-334af.firebaseio.com/answers.json?orderBy=" + "\"Question\"" + "&equalTo=" + "\"" + question + "\"";

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

//        final Answer a = new Answer();

        for (Iterator<String> it = json.keys(); it.hasNext(); ) {

            final Answer a = new Answer();
            String key = it.next();
            System.out.println(key);
            try {
                a.setCategory(json.getJSONObject(String.valueOf(key)).getString("Category"));
                a.setId(json.getJSONObject(String.valueOf(key)).getInt("ID"));
                a.setQuestion(json.getJSONObject(String.valueOf(key)).getString("Question"));
                a.setLanguage(json.getJSONObject(String.valueOf(key)).getString("Language"));
                a.setAnswer(json.getJSONObject(String.valueOf(key)).getString("Answer"));

                myDataset.add(a.getAnswer());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        mAdapter = new MyAdapter(myDataset, this);
        recyclerView.setAdapter(mAdapter);
//        TextView t = findViewById(R.id.answer);
//        t.setText("The Answer is: " + a.getAnswer());
    }





}
