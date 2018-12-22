package co.edu.unisabana.wheels.iwheelson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class ListaPagosRealizados extends AppCompatActivity {

    ListView lvl;
    long session;
    String id;
    JSONObject datos; /*= {
            {"Fecha: ","Destinatario: ","Causa: "}
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pagos_realizados);
        session=getIntent().getExtras().getLong("Session");
        id=getIntent().getExtras().getString("id");
        lvl = findViewById(R.id.lvPagos);
        InvocarServicioListaPagos ws = new InvocarServicioListaPagos();
        ws.execute();
    }

    private class InvocarServicioListaPagos extends AsyncTask<String, String, String> {
        private String resp;
        HttpURLConnection urlConnection;

        @Override
        protected String doInBackground(String... params) {
            StringBuilder result = new StringBuilder();
            try {
                URL url = new URL("https://disenioarqproyecto.appspot.com/_ah/api/proxy/v3/ipago/"+session);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            jsonInsertLocal(result);
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(String... text) {
        }
    }

    private void jsonInsertLocal(String msgjson) {
        try {
            List<String> contes = new ArrayList<String>();
            JSONObject obj = new JSONObject(msgjson);
            JSONArray lista = obj.optJSONArray("items");
            System.out.println(lista.length());

            for (int i = 0; i < lista.length(); i++) {
                JSONObject json_data = lista.getJSONObject(i);
                String paga = json_data.get("usuarioPaga").toString();
                String conte ="Fecha: "+ json_data.getString("fecha") + "\nUsuario Pagado: "
                        + json_data.getString("usuarioPagado") + "\nConcepto: " + json_data.getString("concepto")
                        +"\nValor: "+json_data.getString("valor");
                if(paga.equals(id)){
                    contes.add(conte);
                }

            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contes);
            lvl.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
