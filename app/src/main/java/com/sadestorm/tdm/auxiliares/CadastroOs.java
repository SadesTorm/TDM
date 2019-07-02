package com.sadestorm.tdm.auxiliares;

public class CadastroOs {

    public String cliente;
    public String dia;
    public String mes;
    public String ano;
    public String servico;
    public String copiado;
    public String nSerie;


    public CadastroOs(){

    }

    public CadastroOs(String cliente, String dia, String mes, String ano, String servico, String copiado,String nSerie) {
        this.cliente = cliente;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.servico = servico;
        this.copiado = copiado;
        this.nSerie = nSerie;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getCopiado() {
        return copiado;
    }

    public void setCopiado(String copiado) {
        this.copiado = copiado;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }
}
