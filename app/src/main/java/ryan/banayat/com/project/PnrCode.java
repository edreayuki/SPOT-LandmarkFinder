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

public class PnrCode extends AppCompatActivity {

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
        setContentView(R.layout.stations_pnr);

        // ADD ARROW BACK BUTTON
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        // END ARROW BACK BUTTON


        Log.d("ICS115", "PNR onCreate successful");
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
            Toast.makeText(PnrCode.this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick (View v) {
        Intent i = new Intent(PnrCode.this, EstablishmentsList.class);

        switch (v.getId()) {
            case R.id.img1:
            case R.id.txt1:
                i.putExtra("station_name", "Tutuban");
                i.putExtra("latitude", "14.6111903");
                i.putExtra("longitude", "120.973033");
                break;

            case R.id.txt2:
            case R.id.img2:
                i.putExtra("station_name", "Laong Laan");
                i.putExtra("latitude", "14.6168068");
                i.putExtra("longitude", "120.9904364");
                break;

            case R.id.txt3:
            case R.id.img3:
                i.putExtra("station_name", "España");
                i.putExtra("latitude", "14.6123268");
                i.putExtra("longitude", "120.9947261");
                break;
            case R.id.txt4:
            case R.id.img4:
                i.putExtra("station_name", "Sta. Mesa");
                i.putExtra("latitude", "14.6008906");
                i.putExtra("longitude", "121.008141");
                break;

            case R.id.txt5:
            case R.id.img5:
                i.putExtra("station_name", "Pandacan");
                i.putExtra("latitude", "14.5902722");
                i.putExtra("longitude", "121.0066127");
                break;

            case R.id.txt6:
            case R.id.img6:
                i.putExtra("station_name", "Paco");
                i.putExtra("latitude", "14.5792828");
                i.putExtra("longitude", "120.9972622");
                break;
            case R.id.txt7:
            case R.id.img7:
                i.putExtra("station_name", "San Andres");
                i.putExtra("latitude", "14.5792826");
                i.putExtra("longitude", "120.9906961");
                break;
            case R.id.txt8:
            case R.id.img8:
                i.putExtra("station_name", "Vito Cruz");
                i.putExtra("latitude", "14.5652939");
                i.putExtra("longitude", "120.99664");
                break;
            case R.id.txt9:
            case R.id.img9:
                i.putExtra("station_name", "Buendia");
                i.putExtra("latitude", "14.5571806");
                i.putExtra("longitude", "121.0069143");
                break;
            case R.id.img10:
            case R.id.txt10:
                i.putExtra("station_name", "Pasay Road");
                i.putExtra("latitude", "14.5497666");
                i.putExtra("longitude", "121.0118486");
                break;

            case R.id.txt11:
            case R.id.img11:
                i.putExtra("station_name", "EDSA");
                i.putExtra("latitude", "14.5480234");
                i.putExtra("longitude", "121.0042194");
                break;


            case R.id.txt12:
            case R.id.img12:
                i.putExtra("station_name", "Nichols");
                i.putExtra("latitude", "14.5234714");
                i.putExtra("longitude", "121.0240953");
                break;

            case R.id.txt13:
            case R.id.img13:
                i.putExtra("station_name", "FTI");
                i.putExtra("latitude", "14.5062836");
                i.putExtra("longitude", "121.0334763");
                break;

            case R.id.txt14:
            case R.id.img14:
                i.putExtra("station_name", "Bicutan");
                i.putExtra("latitude", "14.4880728");
                i.putExtra("longitude", "121.0433051");
                break;

            case R.id.txt15:
            case R.id.img15:
                i.putExtra("station_name", "Sucat");
                i.putExtra("latitude", "14.4523253");
                i.putExtra("longitude", "121.0486983");
                break;

            case R.id.txt16:
            case R.id.img16:
                i.putExtra("station_name", "Alabang");
                i.putExtra("latitude", "14.4170961");
                i.putExtra("longitude", "121.0454284");
                break;

            case R.id.txt17:
            case R.id.img17:
                i.putExtra("station_name", "Muntinlupa");
                i.putExtra("latitude", "14.4170954");
                i.putExtra("longitude", "121.0301075");
                break;

            case R.id.txt18:
            case R.id.img18:
                i.putExtra("station_name", "San Pedro");
                i.putExtra("latitude", "14.3631536");
                i.putExtra("longitude", "121.0528097");
                break;

            case R.id.txt19:
            case R.id.img19:
                i.putExtra("station_name", "Pacita Main Gate");
                i.putExtra("latitude", "14.3469674");
                i.putExtra("longitude", "121.0614685");
                break;

            case R.id.txt20:
            case R.id.img20:
                i.putExtra("station_name", "Golden City 1");
                i.putExtra("latitude", "14.3367425");
                i.putExtra("longitude", "121.0728801");
                break;

            case R.id.txt21:
            case R.id.img21:
                i.putExtra("station_name", "Binan");
                i.putExtra("latitude", "14.3367423");
                i.putExtra("longitude", "121.066314");
                break;

            case R.id.txt22:
            case R.id.img22:
                i.putExtra("station_name", "Sta. Rosa");
                i.putExtra("latitude", "14.3060876");
                i.putExtra("longitude", "121.1075976");
                break;

            case R.id.txt23:
            case R.id.img23:
                i.putExtra("station_name", "Cabuyao");
                i.putExtra("latitude", "14.2561377");
                i.putExtra("longitude", "121.1184208");
                break;

            case R.id.txt24:
            case R.id.img24:
                i.putExtra("station_name", "Mamatid");
                i.putExtra("latitude", "14.2322947");
                i.putExtra("longitude", "121.1434493");
                break;

            case R.id.txt25:
            case R.id.img25:
                i.putExtra("station_name", "Calamba");
                i.putExtra("latitude", "14.206981");
                i.putExtra("longitude", "121.1558837");
                break;
        }

        startActivity(i);
    }


//    public void pnr_screen(View v){
//        Intent i = new Intent(this, MainActivity.class);
//        startActivity(i);
//    }

}
