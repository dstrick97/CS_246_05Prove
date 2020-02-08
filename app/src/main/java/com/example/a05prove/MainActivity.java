package com.example.a05prove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.a05prove.MESSAGE";
    public static final String Tag = "MainActivity";

    private TextView script;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        script = findViewById(R.id.script);

    }

    public void load(View view) {

        String nameValue = "";

        SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);

        nameValue = sp.getString("Scripture", " ");

        script.setText(nameValue);

        Log.d("sptest","Loaded Name: "+nameValue);

    }


    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        EditText Book = (EditText) findViewById(R.id.book);
        EditText Chapter = (EditText) findViewById(R.id.chapter);
        EditText Verse = (EditText) findViewById(R.id.verse);
        String message = Book.getText().toString() + " " + Chapter.getText().toString() + ":" + Verse.getText().toString();
    //Create logcat message
        Log.d(Tag, "Creating intent for " + message);

        Intent intent = new Intent(this, DisplayScripture.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

}
