package com.example.classs_14_12_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.class14_12_22.R;

public class enterName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);
        EditText et = findViewById(R.id.etGetName);
        Button goToAddItem = findViewById(R.id.button);


        goToAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(enterName.this, MainActivity.class);
                intent.putExtra("name", et.getText() + "");
                //Toast.makeText(enterName.this, ed.getText(),Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

        });

    }
}