package ryan.banayat.com.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Display extends AppCompatActivity {

    final String GOOGLE_PLACES_API_KEY = "AIzaSyB_cp1hjwXjm-h9mDf5uACKQDEyxhBVaBM";
    ImageView mImage;
    TextView mName, mAddress, mType, mPhoneNumber;
    Button mMap;


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
        setContentView(R.layout.activity_display);

        // ADD ARROW BACK BUTTON
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        // END ARROW BACK BUTTON


        Intent intent = getIntent();
        String id = intent.getStringExtra("location_id");
        String name = intent.getStringExtra("location_name");
        this.setTitle(name);

        mImage = findViewById(R.id.location_icon);
        mName = findViewById(R.id.location_name);
        mAddress = findViewById(R.id.location_address);
        mType = findViewById(R.id.location_type);
        mPhoneNumber = findViewById(R.id.location_phone_number);
        mMap = findViewById(R.id.location_view_map);

        displayDetails(id);
    }

    public void displayDetails(String id) {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/details/json?");
        googlePlacesUrl.append("placeid=").append(id);
        googlePlacesUrl.append("&fields=").append("name,formatted_address,types,geometry,formatted_phone_number,icon");
        googlePlacesUrl.append("&key=" + GOOGLE_PLACES_API_KEY);

        String URL = googlePlacesUrl.toString();
        Log.d("TES", URL);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonResponse) {
                        try {
                            Log.d("TES", jsonResponse.toString());

                            JSONObject result = jsonResponse.getJSONObject("result");

                            String name =  result.get("name").toString();
                            final String address =  result.get("formatted_address").toString();

                            String phoneNumber = "NA";
                            if(result.has("formatted_phone_number"))
                                phoneNumber = result.get("formatted_phone_number").toString();

                            StringBuilder temp = new StringBuilder("");

                            JSONArray types = result.getJSONArray("types");
                            int length = types.length();

                            for(int i = 0; i < length; i++){
                                temp.append(types.getString(i));
                                if((i + 1) != length)
                                    temp.append(", ");
                            }

                            String type = temp.toString();
                            String icon =  result.get("icon").toString();


                            Glide.with(Display.this)
                                .asBitmap()
                                .load(icon)
                                .into(mImage);

                            mName.setText(name);
                            mAddress.setText("Address: \n" + address);
                            mPhoneNumber.setText("Contact: \n" + phoneNumber);
                            mType.setText("Establishment Type: \n" + type);

                            mMap.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    // based on LOCATION ADDRESS
                                    i.setData(Uri.parse("geo:0, 0?q=" + Uri.encode(address)));
                                    Intent chooser = Intent.createChooser(i, "Choose an app");
                                    startActivity(chooser);
                                }
                            });

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

        RequestQueue rq = Volley.newRequestQueue(Display.this);
        rq.add(request);
    }

}
