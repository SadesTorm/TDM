package com.sadestorm.tdm.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.sadestorm.tdm.R;

public class MainActivity extends AppCompatActivity {
    Button osBtn;
    Button visitasDiariasBtn;
    Button scanCodeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        osBtn = findViewById(R.id.btnOs);
        visitasDiariasBtn = findViewById(R.id.btnVisitasDiarias);
        scanCodeBtn = findViewById(R.id.btnScanCode);

        osBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,OrdemDeServico.class);
                startActivity(i);
            }
        });

        visitasDiariasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RecycleRelatorioDiario.class);
                startActivity(i);
            }
        });
        scanCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scaneando Toner");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
                if(result.getContents() != null ){
                    Toast.makeText(this,result.getContents() , Toast.LENGTH_SHORT).show();
                }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}
