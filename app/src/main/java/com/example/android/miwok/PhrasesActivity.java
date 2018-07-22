package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    int n = 50;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        resultTextView = findViewById(R.id.osvalue);
        /*
        ArrayList<Word> NumList = new ArrayList<>();
        NumList.add(new Word("lutti","one",R.drawable.number_one));
        NumList.add(new Word("otiiko","two",R.drawable.number_two));
        NumList.add(new Word("tolookosu","three",R.drawable.number_three));
        NumList.add(new Word("oyyisa","four",R.drawable.number_four));
        NumList.add(new Word("massokka","five",R.drawable.number_five));
        NumList.add(new Word("temmokka","six",R.drawable.number_six));
        NumList.add(new Word("kenekaku","seven",R.drawable.number_seven));
        NumList.add(new Word("kawinta","eight",R.drawable.number_eight));
        NumList.add(new Word("wo'e","nine",R.drawable.number_nine));
        NumList.add(new Word("na'aacha","ten",R.drawable.number_ten));
        WordAdapter itemsAdapter = new WordAdapter(this, NumList);

        ListView listView = (ListView) findViewById(R.id.numlist);

        listView.setAdapter(itemsAdapter);
        */
    }

    public void getWeather(View view) {
        final String requestString = " ";
        String string_url = "https://api.thingspeak.com/channels/498500/fields/1.json?api_key=RWTTV0RAQA1N5X0F&results=2";

        RequestQueue requestQueue = Volley.newRequestQueue(PhrasesActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, string_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray arr = jsonObject.getJSONArray("feeds");
                    Log.i("json",arr.get(arr.length()-1).toString());
                    JSONObject j1 = new JSONObject(arr.get(arr.length()-1).toString());
                    String f =j1.getString("field1");
                    Log.i("f u",f);
                    resultTextView.setText(f+"%    ");

                }
                catch (Exception e){
                    e.printStackTrace();
                }




                Log.i("VolleyResponse", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorVolley", error.toString());

            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {

                return requestString.getBytes();
            }

            @Override
            protected String getParamsEncoding() {
                return "utf-8";
            }
        };
        requestQueue.add(stringRequest);
    }

    public void increment(View view) {
        if (n < 96) {
            n = n + 5;
            displayQuantity(n);
        } else {
            Toast.makeText(PhrasesActivity.this, "Maximum Moisture", Toast.LENGTH_LONG).show();
        }
    }


    public void sethumidity (View view){
        Toast.makeText(PhrasesActivity.this, "Moisture Set", Toast.LENGTH_SHORT).show();
    }

    public void decrement(View view) {
        if (n > 20) {
            n = n - 5;
            displayQuantity(n);
        } else {
            Toast.makeText(PhrasesActivity.this, "Minimum Moisture", Toast.LENGTH_LONG).show();
        }
    }


    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}
