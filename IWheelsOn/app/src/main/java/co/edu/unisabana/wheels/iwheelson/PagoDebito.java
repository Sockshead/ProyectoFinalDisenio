package co.edu.unisabana.wheels.iwheelson;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PagoDebito extends AppCompatActivity {

    long session;
    String concepto;
    TextView tvalor;
    Button confirmarP;
    String valor, referencia, usuarioP, pagado, fecha;
    EditText mEdit;
    String numCuenta;
    Boolean ispagado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_debito);
        session = getIntent().getExtras().getLong("Session");
        concepto = getIntent().getExtras().getString("Concepto");
        usuarioP = getIntent().getExtras().getString("id");
        tvalor = findViewById(R.id.verpago);
        tvalor.setText("4000");
        mEdit = findViewById(R.id.txtCuentaDeb);
        confirmarP = findViewById(R.id.confirmarpago);
        System.out.println("Sesion: " + session + " Concepto " + concepto);

        fecha = new SimpleDateFormat("dd-MM-yy_HH:mm:ss").format(Calendar.getInstance().getTime());

        confirmarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask().execute();
                numCuenta = mEdit.getText().toString();

                System.out.println(numCuenta+" 2 print");

            }
        });
    }


    private class EndpointsAsyncTask extends AsyncTask<String, Void, Void> {


        @Override
        protected Void doInBackground(String... strings) {
            ispagado = pagar();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            System.out.println("Sesion " + session);
            if(ispagado){
                Toast.makeText(PagoDebito.this,"Pago Realizado con exito!!",Toast.LENGTH_LONG).show();
                Intent menu = new Intent(PagoDebito.this,MenuPrincipalNuevo.class);
                menu.putExtra("Session",session);
                menu.putExtra("IdUsuario",usuarioP);
                PagoDebito.this.startActivity(menu);
            }
            else{
                Toast.makeText(PagoDebito.this,"No se pudo realizar el pago",Toast.LENGTH_LONG).show();
                Intent menu = new Intent(PagoDebito.this,MenuPrincipalNuevo.class);
                menu.putExtra("Session",session);
                menu.putExtra("IdUsuario",usuarioP);
                PagoDebito.this.startActivity(menu);
            }

        }
    }

    private boolean pagar() {
        boolean pag = false;
        Random ran = new Random();
        valor = tvalor.getText().toString();
        referencia = String.valueOf(ran.nextInt());
        pagado = "169701";
        URL url = null;
        long sesion;


        try {
            url = new URL("https://daproyectofinal.appspot.com/_ah/api/proxy/v3/pagoDebito/" + session + "/" + fecha +"%2C"+ numCuenta);
            System.out.println(url);
            String response = "";
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(15000);
            con.setConnectTimeout(15000);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);

            JSONObject postDataParams = new JSONObject();
            String value = valor + "," + referencia + "," + usuarioP + "," + pagado + "," + concepto;
            System.out.println(value);
            postDataParams.put("valores", value);


            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            // BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            writer.write(postDataParams.toString());
            // writer.flush();
            writer.close();
            //os.close();
            int responseCode = con.getResponseCode();
            System.out.println("Codigo respuesta " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK)

            {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }
                JSONObject respuesta = new JSONObject(response);
                pag=true;
            } else

            {
                response = "";
                sesion = 0;
            }
            System.out.println(response);


            return pag;


        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            return pag;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return pag;
        } catch (IOException e) {
            e.printStackTrace();
            return pag;
        } catch (JSONException e) {
            e.printStackTrace();
            return pag;
        }

    }
}
