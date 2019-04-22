package com.example.mhairistewart.honours_proj;

import android.content.Intent;
import android.graphics.Color;
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

import model.Category;

public class CategoryActivity extends AppCompatActivity {

    public String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
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
        language = extras.getString("language");
        createDataset();


    }

    public void createDataset() {

        LinearLayout layout = findViewById(R.id.categoryLayout);

        String myUrl = "https://mhairi-honours-334af.firebaseio.com/category.json?orderBy=" + "\"Language\"" + "&equalTo=" + "\"" + language.toUpperCase() + "\"";

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


            try {
                while (json.keys().hasNext()) {
                    final Category c = new Category();

                    try {
                        c.setCategory(json.getJSONObject(String.valueOf(counter)).getString("Category"));
                        c.setId(json.getJSONObject(String.valueOf(counter)).getInt("ID"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    c.setLanguage(json.getJSONObject(String.valueOf(counter)).getString("Language"));
                    final Button button = new Button(this);
                    button.setTextColor(Color.parseColor("#3F51B5"));
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(view.getContext(), QuestionActivity.class);

                            Bundle args = new Bundle();
                            args.putString("category", String.valueOf(c.getCategory()));

                            intent.putExtras(args);
                            startActivity(intent);
                        }
                    });

                    button.setText(c.getCategory());
                    buttons.add(button);
                    layout.addView(button);
                    categories.add(c);
                    counter++;


                }

            } catch (JSONException e) {
                e.printStackTrace();
                break;
            }


        }
    }
}
