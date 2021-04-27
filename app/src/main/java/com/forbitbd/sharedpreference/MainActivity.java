package com.forbitbd.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.ExternalStorageStats;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnsave, btnshow, btndelete;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Share Preference",MODE_PRIVATE);

        editText = findViewById(R.id.edit_text);
        btnsave = findViewById(R.id.btnsave);
        btnshow = findViewById(R.id.btndisplay);
        btndelete = findViewById(R.id.btndelete);
        textView = findViewById(R.id.show_text);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString().trim();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Message", message);
                editor.apply();
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String message = sharedPreferences.getString("Message","");
            textView.setText(message);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().remove("Message").commit();
            }
        });
    }
}