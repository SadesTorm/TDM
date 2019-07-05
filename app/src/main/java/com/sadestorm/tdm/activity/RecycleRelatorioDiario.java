package com.sadestorm.tdm.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.sadestorm.tdm.R;
import com.sadestorm.tdm.adaptadores.AdapterRelatorioDiario;
import com.sadestorm.tdm.auxiliares.CadastroOs;

import java.util.ArrayList;
import java.util.List;

public class RecycleRelatorioDiario extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<CadastroOs> listaRelatorio;

    private AdapterRelatorioDiario adapterRelatorioDiario;

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
        carregaDados();

    }

    public void carregaDados() {

        Query consulta = referencia.orderByChild("OrdemDeServico");

        consulta.addListenerForSingleValueEvent(new ValueEventListener(){
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
                public void onCancelled (@NonNull DatabaseError databaseError){

                }
        });
    }
}
