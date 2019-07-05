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
        CadastroOs ordemServico = listaOs.get(i);

        viewHolder.clientetxt.setText(ordemServico.getCliente());
        viewHolder.copiadotxt.setText(ordemServico.getCopiado());
        viewHolder.datatxt.setText(ordemServico.getDia()+"/"+ordemServico.getMes()+"/"+ordemServico.getAno());
        viewHolder.servicotxt.setText(ordemServico.getServico());
        viewHolder.numeroSerietxt.setText(ordemServico.getnSerie());


    }

    @Override
    public int getItemCount() {

        return listaOs.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {



        TextView clientetxt;
        TextView numeroSerietxt;
        TextView datatxt;
        TextView servicotxt;
        TextView copiadotxt;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            clientetxt = itemView.findViewById(R.id.textViewCliente);
            numeroSerietxt = itemView.findViewById(R.id.textViewNserie);
            datatxt = itemView.findViewById(R.id.textViewData);
            servicotxt = itemView.findViewById(R.id.textViewServico);
            copiadotxt = itemView.findViewById(R.id.textViewCopiado);
        }
    }

}
