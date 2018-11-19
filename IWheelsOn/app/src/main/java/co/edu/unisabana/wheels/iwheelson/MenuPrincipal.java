package co.edu.unisabana.wheels.iwheelson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MenuPrincipal extends AppCompatActivity {

    long session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        session=getIntent().getExtras().getLong("Session");
        System.out.println("Todo bien gonorrea "+session);
    }
}
