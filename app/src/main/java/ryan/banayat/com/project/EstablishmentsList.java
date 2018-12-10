package ryan.banayat.com.project;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EstablishmentsList extends AppCompatActivity {

    final String GOOGLE_PLACES_API_KEY = "AIzaSyB_cp1hjwXjm-h9mDf5uACKQDEyxhBVaBM";
    final int GOOGLE_PLACES_RADIUS = 1500;

    private static final String TAG = "EstablishmentsList";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mAddress = new ArrayList<>();
    private ArrayList<String> mLocationID = new ArrayList<>();

    // ADD ARROW BACK BUTTON
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    // END ARROW BACK BUTTON


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishments_list);


        // ADD ARROW BACK BUTTON
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        // END ARROW BACK BUTTON


        Intent intent = getIntent();
        String station = intent.getStringExtra("station_name");
        Double latitude = Double.parseDouble(intent.getStringExtra("latitude"));
        Double longitude = Double.parseDouble(intent.getStringExtra("longitude"));


        this.setTitle(station + " Station");
        loadNearByPlaces(latitude,longitude);

//        initImageBitmaps();
        checkConnection();
    }
    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    public void checkConnection(){
        if(isOnline()){

        }else{
            Toast.makeText(EstablishmentsList.this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();
        }
    }

    public void loadNearByPlaces(double latitude, double longitude) {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=").append(latitude).append(",").append(longitude);
        googlePlacesUrl.append("&radius=").append(GOOGLE_PLACES_RADIUS);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + GOOGLE_PLACES_API_KEY);

        String URL = googlePlacesUrl.toString();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject result) {
                        try {

                            JSONArray result_array = result.getJSONArray("results");

                            for(int i = 0; i < result_array.length(); i++) {
                                JSONObject obj = result_array.getJSONObject(i);

                                String name = obj.get("name").toString();
                                String icon = obj.get("icon").toString();
                                String address = obj.get("vicinity").toString();
                                String id = obj.get("place_id").toString();

                                mNames.add(name);
                                mImageUrls.add(icon);
                                mAddress.add(address);
                                mLocationID.add(id);
                            }

                            initRecyclerView();
                        } catch(JSONException e) {
                            Log.e("MAP_DEBUG", "unexpected JSON exception", e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.getStackTrace();
                        Log.d("MAP_DEBUG", error.toString());
                    }
                });

        RequestQueue rq = Volley.newRequestQueue(EstablishmentsList.this);
        rq.add(request);
    };

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");

        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mAddress, mLocationID);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    protected void Toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
