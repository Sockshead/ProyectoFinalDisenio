package co.edu.unisabana.wheels.iwheelson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
            URL url = null;
            try {
                url = new URL("https://pagoswheels.appspot.com/_ah/api/proxy/v3/echo");
                String response = "";
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setReadTimeout(40000);
                con.setConnectTimeout(40000);
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);

                JSONObject postDataParams = new JSONObject();
                postDataParams.put("message","holo");
                //   postDataParams.put("User",correo);
                // postDataParams.put("Password",contraseña);


                OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
                // BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                writer.write(postDataParams.toString());
                // writer.flush();
                writer.close();
                //os.close();
                int responseCode = con.getResponseCode();
                System.out.println("Codigo respuesta" + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK)

                {
                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    while ((line = br.readLine()) != null) {
                        response += line;
                        System.out.println(response);
                    }
                } else

                {
                    response = "";
                }


            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
