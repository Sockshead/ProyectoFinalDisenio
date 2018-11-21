package co.edu.unisabana.wheels.iwheelson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PagosMenu extends AppCompatActivity {

    long session;
    String id;
    Button bpagosr,bpagos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos_menu);
        session=getIntent().getExtras().getLong("Session");
        id=getIntent().getExtras().getString("id");
        bpagos = findViewById(R.id.pagosr);
        bpagosr = findViewById(R.id.verpagosrecibidos);
        bpagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(PagosMenu.this,ListaPagosRealizados.class);
                menu.putExtra("Session",session);
                menu.putExtra("id",id);
                PagosMenu.this.startActivity(menu);


            }
        });
    }
}
