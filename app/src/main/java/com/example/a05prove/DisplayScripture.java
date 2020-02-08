package com.example.a05prove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisplayScripture extends AppCompatActivity {
    public static final String Tag = "DisplayScripture";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // message on intent recieved
        Log.d(Tag,"Received intent with " + message);
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    public void save(View view) {

        String nameValue = getIntent().getStringExtra((MainActivity.EXTRA_MESSAGE));

        SharedPreferences sp = getSharedPreferences("Scripture", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("Scripture", nameValue);

        editor.commit();

        Log.d("sptest","Saved Name: "+nameValue);

    }

}
