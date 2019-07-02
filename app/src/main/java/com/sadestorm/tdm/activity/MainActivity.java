package com.sadestorm.tdm.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sadestorm.tdm.R;

public class MainActivity extends AppCompatActivity {
    Button osBtn;
    Button visitasDiariasBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        osBtn = findViewById(R.id.btnOs);
        visitasDiariasBtn = findViewById(R.id.btnVisitasDiarias);

        osBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,OrdemDeServico.class);
                startActivity(i);
            }
        });


    }
}
