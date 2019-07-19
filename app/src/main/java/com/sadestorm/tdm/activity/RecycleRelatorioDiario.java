package com.sadestorm.tdm.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.sadestorm.tdm.R;
import com.sadestorm.tdm.adaptadores.AdapterRelatorioDiario;
import com.sadestorm.tdm.auxiliares.CadastroOs;
import com.sadestorm.tdm.auxiliares.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RecycleRelatorioDiario extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<CadastroOs> listaRelatorio;

    private AdapterRelatorioDiario adapterRelatorioDiario;

    private String numeroSerie;
    private String pesquisa;

    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("OrdemDeServico");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_relatorio_diario);

        recyclerView = findViewById(R.id.recyclerViewRelatorioDiario);
        listaRelatorio = new ArrayList<CadastroOs>();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        adapterRelatorioDiario = new AdapterRelatorioDiario(listaRelatorio);
        recyclerView.setAdapter(adapterRelatorioDiario);


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        CadastroOs aux = listaRelatorio.get(position);

                        Toast.makeText(getApplicationContext(), "Item precionado" + aux.getnSerie(), Toast.LENGTH_LONG).show();
                        carregaNumSerie(aux.nSerie);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), "+-+-+-+-+-- TUDO OK +--+-+-", Toast.LENGTH_LONG).show();
                        CadastroOs aux = listaRelatorio.get(position);


                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }) {
        });

        carregaDados();

    }

    public void carregaDados() {


        Query consulta = referencia.orderByChild("OrdemDeServico");

        consulta.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaRelatorio.clear();
                for (DataSnapshot dt : dataSnapshot.getChildren()) {

                    CadastroOs os = dt.getValue(CadastroOs.class);
                    listaRelatorio.add(os);

                }
                adapterRelatorioDiario.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void carregaNumSerie(String numeroSerie) {

        final String numSerie = numeroSerie;
        final String query = "nSerie";

        Query consulta = referencia.orderByChild(query).equalTo(numSerie);

        consulta.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaRelatorio.clear();
                for (DataSnapshot dt : dataSnapshot.getChildren()) {
                    if (dt.child(query).getValue() != null) {
                        CadastroOs os = dt.getValue(CadastroOs.class);
                        listaRelatorio.add(os);
                    }
                }

                adapterRelatorioDiario.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}