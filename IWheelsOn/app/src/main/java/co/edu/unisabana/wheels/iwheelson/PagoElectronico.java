package co.edu.unisabana.wheels.iwheelson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PagoElectronico extends AppCompatActivity {

    long session;
    String concepto,usuarioP;
    Button bcredito,bdebito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_electronico);
        session = getIntent().getExtras().getLong("Session");
        concepto = getIntent().getExtras().getString("Concepto");
        usuarioP = getIntent().getExtras().getString("id");
        bcredito = findViewById(R.id.pagocredito);
        bdebito = findViewById(R.id.pagodebito);

        bcredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(PagoElectronico.this,PagoCredito.class);
                menu.putExtra("Session",session);
                menu.putExtra("Concepto",concepto);
                menu.putExtra("id",usuarioP);
                PagoElectronico.this.startActivity(menu);
            }
        });
        bdebito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(PagoElectronico.this,PagoDebito.class);
                menu.putExtra("Session",session);
                menu.putExtra("Concepto",concepto);
                menu.putExtra("id",usuarioP);
                PagoElectronico.this.startActivity(menu);
            }
        });
    }
}
