package ryan.banayat.com.project;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Lrt1Code extends AppCompatActivity {

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
        setContentView(R.layout.stations_lrt1);

        // ADD ARROW BACK BUTTON
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        // END ARROW BACK BUTTON


        Log.d("ICS115", "LRT 1 onCreate successful");
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
            Toast.makeText(Lrt1Code.this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();
        }
    }


    public void onClick (View v) {
    	Intent i = new Intent(Lrt1Code.this, EstablishmentsList.class);

        switch (v.getId()) {
            case R.id.img1:
            case R.id.txt1:
                i.putExtra("station_name", "Roosevelt");
                i.putExtra("latitude", "14.6576");
                i.putExtra("longitude", "121.0211");
                break;

            case R.id.txt2:
            case R.id.img2:
                i.putExtra("station_name", "Balintawak");
                i.putExtra("latitude", "14.6574");
                i.putExtra("longitude", "121.0032");
                break;


            case R.id.txt3:
            case R.id.img3:
                i.putExtra("station_name", "Monumento");
                i.putExtra("latitude", "14.6547");
                i.putExtra("longitude", "120.9834");
                break;

            case R.id.txt4:
            case R.id.img4:
                i.putExtra("station_name", "5th Avenue");
                i.putExtra("latitude", "14.6443");
                i.putExtra("longitude", "120.9830");
                break;
            case R.id.txt5:
            case R.id.img5:
                i.putExtra("station_name", "R. Papa");
                i.putExtra("latitude", "14.6360");
                i.putExtra("longitude", "120.9819");
                break;

            case R.id.txt6:
            case R.id.img6:
                i.putExtra("station_name", "Abad Santos");
                i.putExtra("latitude", "14.6309");
                i.putExtra("longitude", "120.9809");
                break;

            case R.id.txt7:
            case R.id.img7:
                i.putExtra("station_name", "Blumentritt");
                i.putExtra("latitude", "14.6225");
                i.putExtra("longitude", "120.9828");
                break;
            case R.id.txt8:
            case R.id.img8:
                i.putExtra("station_name", "Tayuman");
                i.putExtra("latitude", "14.6169");
                i.putExtra("longitude", "120.9829");
                break;
            case R.id.txt9:
            case R.id.img9:
                i.putExtra("station_name", "Bambang");
                i.putExtra("latitude", "14.6112");
                i.putExtra("longitude", "120.9821");
                break;
            case R.id.txt10:
            case R.id.img10:
                i.putExtra("station_name", "Doroteo Jose");
                i.putExtra("latitude", "14.6057");
                i.putExtra("longitude", "120.9811");
                break;
            case R.id.img11:
            case R.id.txt11:
                i.putExtra("station_name", "Carriedo");
                i.putExtra("latitude", "14.5992");
                i.putExtra("longitude", "120.9811");
                break;

            case R.id.txt12:
            case R.id.img12:
                i.putExtra("station_name", "Central Terminal");
                i.putExtra("latitude", "14.5931");
                i.putExtra("longitude", "120.9814");
                break;


            case R.id.txt13:
            case R.id.img13:
                i.putExtra("station_name", "United Nations");
                i.putExtra("latitude", "14.5832");
                i.putExtra("longitude", "120.9834");
                break;

            case R.id.txt14:
            case R.id.img14:
                i.putExtra("station_name", "Pedro Gil");
                i.putExtra("latitude", "14.5763");
                i.putExtra("longitude", "120.9881");
                break;
            case R.id.txt15:
            case R.id.img15:
                i.putExtra("station_name", "Quirino");
                i.putExtra("latitude", "14.5699");
                i.putExtra("longitude", "120.9915");
                break;

            case R.id.txt16:
            case R.id.img16:
                i.putExtra("station_name", "Vito Cruz");
                i.putExtra("latitude", "14.5633");
                i.putExtra("longitude", "120.9946");
                break;

            case R.id.txt17:
            case R.id.img17:
                i.putExtra("station_name", "Gil Puyat");
                i.putExtra("latitude", "14.5542");
                i.putExtra("longitude", "120.9965");
                break;
            case R.id.txt18:
            case R.id.img18:
                i.putExtra("station_name", "Libertad");
                i.putExtra("latitude", "14.5542");
                i.putExtra("longitude", "120.9965");
                break;
            case R.id.txt19:
            case R.id.img19:
                i.putExtra("station_name", "EDSA");
                i.putExtra("latitude", "14.5384");
                i.putExtra("longitude", "121.0004");
                break;
            case R.id.txt20:
            case R.id.img20:
                i.putExtra("station_name", "Baclaran");
                i.putExtra("latitude", "14.5342");
                i.putExtra("longitude", "120.9981");
                break;
        }

        startActivity(i);
    }


}
