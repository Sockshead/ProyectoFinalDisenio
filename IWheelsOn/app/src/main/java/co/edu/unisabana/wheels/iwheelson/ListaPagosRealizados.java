package co.edu.unisabana.wheels.iwheelson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONObject;

public class ListaPagosRealizados extends AppCompatActivity {

    ListView lista;
    JSONObject datos; /*= {
            {"Fecha: ","Destinatario: ","Causa: "}
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pagos_realizados);

        lista = findViewById(R.id.lvPagos);
    }
}
