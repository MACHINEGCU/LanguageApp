package com.example.mhairistewart.honours_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import model.Question;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        LinearLayout layout = findViewById(R.id.questionLayout);

        String category = extras.getString("category");

        String myUrl = "https://mhairi-honours-334af.firebaseio.com/question.json?orderBy=" + "\"Category\"" + "&equalTo=" + "\"" + category + "\"";

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


        final List<Question> categories = new ArrayList<>();
        ArrayList<Button> buttons = new ArrayList<>();



        for (Iterator<String> it = json.keys(); it.hasNext(); ) {
            final Button button = new Button(this);
            final Question q = new Question();
            String key = it.next();
            System.out.println(key);
            try {
                q.setCategory(json.getJSONObject(String.valueOf(key)).getString("Category"));
                q.setId(json.getJSONObject(String.valueOf(key)).getInt("ID"));
                q.setQuestion(json.getJSONObject(String.valueOf(key)).getString("Question"));
                q.setLanguage(json.getJSONObject(String.valueOf(key)).getString("Language"));

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), AnswersActivity.class);

                        Bundle args = new Bundle();
                        args.putString("question", String.valueOf(q.getQuestion()));

                        intent.putExtras(args);
                        startActivity(intent);
                    }
                });

                button.setText(q.getQuestion());
                buttons.add(button);
                layout.addView(button);
                categories.add(q);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }
}
