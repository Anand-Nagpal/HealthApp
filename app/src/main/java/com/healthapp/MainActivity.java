package com.healthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txtEditor;
    private final static String STORETEXT="storetext.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEditor=(EditText)findViewById(R.id.editText);

    }


    public void saveClicked(View v) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(STORETEXT, 0));
            out.write(txtEditor.getText().toString());
            out.close();
            Toast.makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG).show();
        }catch (Throwable t) {
            Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
        }

    }
}
