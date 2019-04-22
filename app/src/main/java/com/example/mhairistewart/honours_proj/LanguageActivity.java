package com.example.mhairistewart.honours_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LanguageActivity extends AppCompatActivity {

    private static FirebaseDatabase db = FirebaseDatabase.getInstance();
    private static DatabaseReference rootRef = db.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // English button
        ImageButton englishButton = (ImageButton) findViewById(R.id.bttnEn);

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CategoryActivity.class);

                Bundle args = new Bundle();
                args.putString("language", "en");

                intent.putExtras(args);
                startActivity(intent);
            }
        });

        //French Button
        ImageButton FrenchButton = (ImageButton) findViewById(R.id.bttnFR);

        FrenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CategoryActivity.class);

                Bundle args = new Bundle();
                args.putString("language", "fr");

                intent.putExtras(args);
                startActivity(intent);
            }
        });

        //Spanish Button
        ImageButton spanishButton = (ImageButton) findViewById(R.id.bttnES);

        spanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CategoryActivity.class);

                Bundle args = new Bundle();
                args.putString("language", "es");

                intent.putExtras(args);
                startActivity(intent);
            }
        });

        //German Button
        ImageButton germanButton = (ImageButton) findViewById(R.id.bttnDE);

        germanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CategoryActivity.class);

                Bundle args = new Bundle();
                args.putString("language", "de");

                intent.putExtras(args);
                startActivity(intent);
            }
        });

    }

    public DatabaseReference getRootReference() {
        return rootRef;
    }
}
