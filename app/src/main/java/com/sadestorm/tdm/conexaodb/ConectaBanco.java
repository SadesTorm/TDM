package com.sadestorm.tdm.conexaodb;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConectaBanco {

    public String link;
    public String tipo;


    public ConectaBanco(String link, String tipo) {
        this.link = link;
        this.tipo = tipo;
    }

    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference(link);





}
