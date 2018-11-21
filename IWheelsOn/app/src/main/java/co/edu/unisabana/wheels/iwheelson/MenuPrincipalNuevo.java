package co.edu.unisabana.wheels.iwheelson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipalNuevo extends AppCompatActivity {


    long session;
    String id;
    Button bpagos,bvpagos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_nuevo);
        session=getIntent().getExtras().getLong("Session");
        id=getIntent().getExtras().getString("IdUsuario");
        bpagos = findViewById(R.id.pagosr);
        bvpagos = findViewById(R.id.verpagos);

        bpagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuPrincipalNuevo.this,MenuPrincipal.class);
                menu.putExtra("Session",session);
                menu.putExtra("id",id);
                MenuPrincipalNuevo.this.startActivity(menu);

            }
        });
        bvpagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuPrincipalNuevo.this,PagosMenu.class);
                menu.putExtra("Session",session);
                menu.putExtra("id",id);
                MenuPrincipalNuevo.this.startActivity(menu);
            }
        });
    }
}
