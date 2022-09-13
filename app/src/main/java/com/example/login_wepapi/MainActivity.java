package com.example.login_wepapi;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.login_wepapi.Activity.Login;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText et_id,et_password;
    Button bt_login;
    String BASE_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.editTextTextPersonName);
        et_password = findViewById(R.id.editTextTextPersonName2);
        bt_login = findViewById(R.id.button);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_id = et_id.getText().toString();
                String str_Password = et_password.getText().toString();

                RequestQueue requestQueue;
                requestQueue = Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest jsonObjectRequest;
                jsonObjectRequest  = new JsonObjectRequest(Request.Method.GET, "hththhtth/+getUser?name=" + str_id + "&pass=" + str_Password, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("myapp", "onResponse " + response.getString("id"));
                            Intent i = new Intent(MainActivity.this, Login.class);
                            startActivity(i);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("myapp", "Want error");

                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}