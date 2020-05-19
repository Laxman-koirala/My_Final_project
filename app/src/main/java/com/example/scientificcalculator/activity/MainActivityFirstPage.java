package com.example.scientificcalculator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scientificcalculator.R;

public class MainActivityFirstPage extends AppCompatActivity {
    final Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_first_page);

        Button btn_scientific = findViewById(R.id.button_toward_scientific);


        btn_scientific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });
    }
    public void nextActivity(){
        Intent intent = new Intent(context, ScientificCalculatorActivity.class);
        startActivity(intent);
    }
}
