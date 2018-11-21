package co.edu.unisabana.wheels.iwheelson;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Login extends AppCompatActivity {
    EditText iusuario,ipass;
    Button inicio;
    long session=0;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iusuario = findViewById(R.id.iuser);
        ipass=findViewById(R.id.ipass);
        inicio = findViewById(R.id.inicios);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask().execute();

            }
        });

    }


    private class EndpointsAsyncTask extends AsyncTask<String, Void, Void> {


        @Override
        protected Void doInBackground(String... strings) {
           session= logIn();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            System.out.println("Sesion "+session);
            if(session!=0){
                Intent menu = new Intent(Login.this,MenuPrincipalNuevo.class);
                menu.putExtra("Session",session);
                menu.putExtra("IdUsuario",id);
                System.out.println("ID ALETOSO1 "+id);
                Login.this.startActivity(menu);
            }else {
                Toast.makeText(Login.this,"Usuario no encontrado",Toast.LENGTH_LONG).show();
            }
        }
    }

    private long logIn() {
        URL url = null;
        long sesion;
        String user = iusuario.getText().toString().trim();
        String pass = ipass.getText().toString();
        try {
            url = new URL("https://daproyectofinal.appspot.com/_ah/api/proxy/v3/auth");
            String response = "";
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(15000);
            con.setConnectTimeout(15000);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);

            JSONObject postDataParams = new JSONObject();
            //    postDataParams.put("message","holo choko africano");
            postDataParams.put("user", user);
            postDataParams.put("password", pass);


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
                sesion = Long.parseLong(respuesta.getString("session"));
                id = respuesta.getString("id");
            } else

            {
                response = "";
                sesion=0;
            }
            System.out.println(response);


            return sesion;


        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            return 0;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }

    }

}
