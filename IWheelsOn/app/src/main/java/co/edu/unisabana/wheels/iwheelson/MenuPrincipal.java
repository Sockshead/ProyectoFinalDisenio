package co.edu.unisabana.wheels.iwheelson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    long session;
    String id;
    Button pagov,pagom;
    String concepto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        session=getIntent().getExtras().getLong("Session");
        id=getIntent().getExtras().getString("IdUsuario");
        pagov = findViewById(R.id.pagoviajes);
        pagom = findViewById(R.id.pagomultas);

        pagov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concepto = "Viaje";
                Intent menu = new Intent(MenuPrincipal.this,MetodoPago.class);
                menu.putExtra("Session",session);
                menu.putExtra("Concepto",concepto);
                menu.putExtra("id",id);

                MenuPrincipal.this.startActivity(menu);
            }
        });
        pagom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concepto = "Multa";
                Intent menu = new Intent(MenuPrincipal.this,MetodoPago.class);
                menu.putExtra("Session",session);
                menu.putExtra("Concepto",concepto);
                menu.putExtra("id",id);

                MenuPrincipal.this.startActivity(menu);
            }
        });

    }
}
