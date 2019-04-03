package com.example.andrewcreaghflynn.carbon_json_test_gitpull;


import android.graphics.Color;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class fetchC02 extends AsyncTask <Void, Void, Void> {


    String data2 = "";
    String dataParsed2 = "";
    String singleParsed2 ="";
    String eNumAsString2 = "";
    int c02 = 0;


    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://carbondown.tk/latestgenration/latest");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while(line != null){
                line = bufferedReader.readLine();
                data2 = data2 + line;
            }

            JSONArray JA = new JSONArray(data2);
            for(final int[] i = {0}; i[0] < 1; i[0]++){
                JSONObject JO = (JSONObject) JA.get(JA.length()-1); // The length -1 fetches the latest array object

                int ec02 = JO.getInt("latestGeneration"); //makes string value integer

                singleParsed2 = "C02 Intesity: " + JO.get("latestGeneration") + "\n";

                dataParsed2 = dataParsed2 + singleParsed2 + "\n";

                // calculate total MW produced, display % of renewable for now

                String numAsString = Integer.toString(ec02);
                eNumAsString2 = numAsString + " gC02/kWh";

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (c02 <= 399){
            MainActivity.eData.setTextColor(Color.GREEN);
            MainActivity.eData.setText("It is a great time to use appliances");

        }else if (c02 >= 400 && c02 <= 499){
            MainActivity.eData.setTextColor(Color.YELLOW);
            MainActivity.eData.setText("It is an ok time to use appliances");
        }
        else{
            MainActivity.eData.setTextColor(Color.RED);
            MainActivity.eData.setText("It is not a good time to use appliances");
        }

        MainActivity.cTotal.setText("The total amount of c02 being produced is: " + this.eNumAsString2);

    }
}
