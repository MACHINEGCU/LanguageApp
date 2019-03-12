package com.example.mhairistewart.honours_proj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import model.Category;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();

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


        Iterator<?> keys = json.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            int count = Integer.valueOf(key);


            final List<Category> categories = new ArrayList<>();

            ArrayList<Button> buttons = new ArrayList<>();

            int counter = count;

        }


    }
}
