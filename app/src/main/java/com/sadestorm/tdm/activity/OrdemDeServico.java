package com.sadestorm.tdm.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sadestorm.tdm.R;
import com.sadestorm.tdm.auxiliares.CadastroOs;

import java.util.Calendar;

public class OrdemDeServico extends AppCompatActivity {

    EditText clienteTxt;
    EditText copiadoTxt;
    EditText servicoTxt;
    EditText nSerieTxt;

    Button salvarBtn;


    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("OrdemDeServico");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem_de_servico);

        clienteTxt = findViewById(R.id.txtCliente);
        copiadoTxt = findViewById(R.id.txtCopiado);
        servicoTxt = findViewById(R.id.txtServico);
        salvarBtn = findViewById(R.id.btnSalvar);
        nSerieTxt = findViewById(R.id.txtNserie);




        salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar calendario = Calendar.getInstance();
                calendario.setTimeInMillis(System.currentTimeMillis());

                String day = Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));
                String mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
                String ano = Integer.toString(calendario.get(Calendar.YEAR));

                CadastroOs os1 = new CadastroOs(clienteTxt.getText().toString(),day,mes,ano,servicoTxt.getText().toString(),copiadoTxt.getText().toString(),nSerieTxt.getText().toString());
                DatabaseReference dbUsuario = referencia;
                dbUsuario.push().setValue(os1);
                Intent i = new Intent(OrdemDeServico.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
