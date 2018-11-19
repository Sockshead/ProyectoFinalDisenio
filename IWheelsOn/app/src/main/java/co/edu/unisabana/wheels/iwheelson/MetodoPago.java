package co.edu.unisabana.wheels.iwheelson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MetodoPago extends AppCompatActivity {

    long session;
    String id;
    String concepto;
    Button pagoe,pagol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_pago);
        session=getIntent().getExtras().getLong("Session");
        concepto=getIntent().getExtras().getString("Concepto");
        id=getIntent().getExtras().getString("id");
        System.out.println("ID ALETOSO "+id);

        pagoe = findViewById(R.id.pagoenefectivo);
        pagol = findViewById(R.id.pagoelectronico);

        pagoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MetodoPago.this,PagoEfectivo.class);
                menu.putExtra("Session",session);
                menu.putExtra("Concepto",concepto);
                menu.putExtra("id",id);
                MetodoPago.this.startActivity(menu);
            }
        });

    }
}
