package com.app.locationtracker;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Locator extends Activity {
    EditText e;
    static TextView networkfield, region;
    Spinner s;
    Button b;
    static String mobile, text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);
        e = Locator.this.findViewById(R.id.mobile_number);
        s = findViewById(R.id.country_code);
        networkfield = findViewById(R.id.network_field);
        region = findViewById(R.id.region);

    }

    public void find(View v){
        mobile = e.getText().toString().trim();
        new NumVeri().execute();
    }
}
class NumVeri extends AsyncTask<Void, Void, String> {
    private String API_URL = "http://apilayer.net/api/validate";
    private String API_KEY = "bdcf9ba9875952058f4daed04367006a";                         //change you API key here
    Locator l = new Locator();
    private Exception exception;


    @Override
    protected String doInBackground(Void... voids) {
        try {
            Log.e("MOBILE", "" + l.mobile);
            URL url = new URL(API_URL + "?access_key=" + API_KEY + "&number=" + l.mobile);//+ "&country_code=" + l.text);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        try {
            JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
            String location = object.getString("location");
            String carrier = object.getString("carrier");
            if (response == null) {
                response = "THERE WAS AN ERROR";
            }

            Log.i("INFO", response);
            l.region.setText("Network : " + location + "" +
                    " ");
            l.networkfield.setText("Location : " + carrier);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}