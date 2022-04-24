package com.example.android_assign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


   List<model> modelList=new ArrayList<>();
   String url="https://my-json-server.typicode.com/easygautam/data/users";
   Myadapter  adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        GetData(); 


    }

    private void GetData() {
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();

        RequestQueue requestQueue=Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


               for(int i=0;i<=response.length();i++) {
                   try {
                       JSONObject jsonObject = response.getJSONObject(i);
                       modelList.add(new model(
                               jsonObject.getInt("id"),
                               jsonObject.getString("name"),
                               jsonObject.getString("subjects"),
                               jsonObject.getString("qualification"),
                               jsonObject.getString("profileImage")


                       ));
                   } catch (JSONException e) {
                       e.printStackTrace();
                       progressDialog.dismiss();
                   }
                   adapter= new  Myadapter(getApplicationContext() ,modelList);
                   recyclerView.setAdapter(adapter);
                   adapter. notifyDataSetChanged();
               }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


}
