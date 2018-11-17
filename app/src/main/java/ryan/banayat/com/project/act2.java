package ryan.banayat.com.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class act2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stationsmrt);
    }

    public void screen2(View v){
        Intent i = new Intent(this, act2.class);
        startActivity(i);
    }
}
