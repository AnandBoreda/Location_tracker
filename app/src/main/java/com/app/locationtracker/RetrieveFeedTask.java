package com.app.locationtracker;

import android.os.AsyncTask;
import android.util.Log;
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

class RetrieveFeedTask extends AsyncTask<Void, Void, String> {
    private String API_URL = "http://apilayer.net/api/validate";
    private String API_KEY = "bdcf9ba9875952058f4daed04367006a";
    TextView number;
    Spinner countryCode;

    private Exception exception;


    @Override
    protected String doInBackground(Void... voids) {
        try {
           URL url = new URL(API_URL + "?access_key=" + API_KEY + "&number=" + number + "&country_code=" + countryCode);
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
        if(response == null) {
            response = "THERE WAS AN ERROR";
            //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
            return;
        }
        Log.i("INFO", response);
        try {
            JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
            String countryname = object.getString("country_name");
            int location = object.getInt("location");
            String carrier = object.getString("carrier");
            String line_type = object.getString("line_type");

            //Set the text to view from here
            // TODO Add to specific text views in the XML file
            // Like countrycode -> country code's text view etc
        } catch (JSONException e) {
            Log.w("INFO", response);
        }
        // responseView.setText(response);
    }

}