package com.example.mhairistewart.honours_proj;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class FirebaseReference {


    private static final FirebaseDatabase db = FirebaseDatabase.getInstance();

    private static DatabaseReference rootRef = db.getReference();

    public static DatabaseReference getRootRef() {
        return rootRef;
    }

}
