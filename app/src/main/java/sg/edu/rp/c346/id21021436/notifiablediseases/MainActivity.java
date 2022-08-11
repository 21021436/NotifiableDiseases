package sg.edu.rp.c346.id21021436.notifiablediseases;

//this app focusses on listing the Notifiable Diseases and case numbers for final week (Week 52) of 2021, the latest data available


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvDiseases;
    AsyncHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDiseases  = findViewById(R.id.ListViewDiseases);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Disease> alDisease = new ArrayList<Disease>();

        client.get("https://data.gov.sg/api/action/datastore_search?offset=16004&resource_id=ef7e44f1-9b14-4680-a60a-37d2c9dda390", new JsonHttpResponseHandler() {

            String diseaseName;
            int number;


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonResultObject = response.getJSONObject("result");
                    JSONArray jsonRecordsArray = jsonResultObject.getJSONArray("records");

                    for(int i = 0; i < jsonRecordsArray.length(); i++) {
                        JSONObject jsonObjDisease = jsonRecordsArray.getJSONObject(i);
                        diseaseName = jsonObjDisease.getString("disease");
                        number = jsonObjDisease.getInt("no._of_cases");
                        Disease disease = new Disease(diseaseName, number);
                        alDisease.add(disease);
                    }

                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View

                //Normal ListView
//                ArrayAdapter<Disease> aaDisease = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alDisease);
//                lvDiseases.setAdapter(aaDisease);

                //Custom ListView
                CustomAdapter caDisease = new CustomAdapter(MainActivity.this, R.layout.row, alDisease);
                lvDiseases.setAdapter(caDisease);





            }//end onSuccess

        });

    }//end onResume



}