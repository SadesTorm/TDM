package com.sadestorm.tdm.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadestorm.tdm.R;
import com.sadestorm.tdm.auxiliares.CadastroOs;

import java.util.List;

public class AdapterRelatorioDiario extends RecyclerView.Adapter<AdapterRelatorioDiario.MyViewHolder> {


    private List<CadastroOs> listaOs;

    public AdapterRelatorioDiario(List<CadastroOs> lista) {
        this.listaOs = lista;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View relatorioOs = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_recycle_relatorio_diario,viewGroup,false);

        return new MyViewHolder(relatorioOs);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView cliente;
        TextView numeroSerie;
        TextView data;
        TextView servico;
        TextView copiado;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
