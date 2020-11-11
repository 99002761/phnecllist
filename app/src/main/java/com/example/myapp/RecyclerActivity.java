package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
    String[] languagesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        languagesData = new String[]{"english","telugu","hindi","tamil","kannada"};
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdapter adapter = new MyAdapter(languagesData);
    }
}