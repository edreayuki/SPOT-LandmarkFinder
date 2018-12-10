package ryan.banayat.com.project;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MrtCode extends AppCompatActivity {
    String station;

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
        setContentView(R.layout.stations_mrt);

        // ADD ARROW BACK BUTTON
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        // END ARROW BACK BUTTON


        Log.d("ICS115", "MRT3 onCreate successful");
        // Construct a GeoDataClient.
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
            Toast.makeText(MrtCode.this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClick (View v) {
        Intent i = new Intent(MrtCode.this, EstablishmentsList.class);

        switch (v.getId()) {
            case R.id.img1:
            case R.id.txt1:
                i.putExtra("station_name", "North Avenue");
                i.putExtra("latitude", "14.6539875");
                i.putExtra("longitude", "121.0310177");
                break;

            case R.id.txt2:
            case R.id.img2:
                i.putExtra("station_name", "Quezon Avenue");
                i.putExtra("latitude", "14.6427537");
                i.putExtra("longitude", "121.0365057");
                break;


            case R.id.txt3:
            case R.id.img3:
                i.putExtra("station_name", "GMA-Kamuning");
                i.putExtra("latitude", "14.6352168");
                i.putExtra("longitude", "121.0411539");
                break;

            case R.id.txt4:
            case R.id.img4:
                i.putExtra("station_name", "Araneta-Cubao");
                i.putExtra("latitude", "14.6194878");
                i.putExtra("longitude", "121.0489425");
                break;
            case R.id.txt5:
            case R.id.img5:
                i.putExtra("station_name", "Santolan-Annapolis");
                i.putExtra("latitude", "14.6072593");
                i.putExtra("longitude", "121.0562388");
                break;

            case R.id.txt6:
            case R.id.img6:
                i.putExtra("station_name", "Ortigas");
                i.putExtra("latitude", "14.5878485");
                i.putExtra("longitude", "121.0545225");
                break;

            case R.id.txt7:
            case R.id.img7:
                i.putExtra("station_name", "Shaw Boulevard");
                i.putExtra("latitude", "14.5812485");
                i.putExtra("longitude", "121.051469");
                break;
            case R.id.txt8:
            case R.id.img8:
                i.putExtra("station_name", "Boni Avenue");
                i.putExtra("latitude", "14.5737673");
                i.putExtra("longitude", "121.0459561");
                break;
            case R.id.txt9:
            case R.id.img9:
                i.putExtra("station_name", "Guadalupe");
                i.putExtra("latitude", "14.5674291");
                i.putExtra("longitude", "121.0435667");
                break;
            case R.id.txt10:
            case R.id.img10:
                i.putExtra("station_name", "Buendia");
                i.putExtra("latitude", "14.5544216");
                i.putExtra("longitude", "121.0321607");
                break;
            case R.id.img11:
            case R.id.txt11:
                i.putExtra("station_name", "Ayala");
                i.putExtra("latitude", "14.5491906");
                i.putExtra("longitude", "121.0257809");
                break;

            case R.id.txt12:
            case R.id.img12:
                i.putExtra("station_name", "Magallanes");
                i.putExtra("latitude", "14.5420229");
                i.putExtra("longitude", "121.0172965");
                break;


            case R.id.txt13:
            case R.id.img13:
                i.putExtra("station_name", "Taft");
                i.putExtra("latitude", "14.537669");
                i.putExtra("longitude", "120.999986");
                break;
        }

        startActivity(i);
    }


//    public void mrt_screen(View v){
//        Intent i = new Intent(this, MainActivity.class);
//        startActivity(i);
//    }

}
