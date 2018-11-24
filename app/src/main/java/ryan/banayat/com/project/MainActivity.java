package ryan.banayat.com.project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lrt1_screen(View v){
        Intent i = new Intent(this, Lrt1Code.class);
        startActivity(i);
    }
    public void lrt2_screen(View v){
        Intent i = new Intent(this, Lrt2Code.class);
        startActivity(i);
    }
    public void mrt3_screen(View v){
        Intent i = new Intent(this, MrtCode.class);
        startActivity(i);
    }
    public void pnr_screen(View v){
        Intent i = new Intent(this, MrtCode.class);
        startActivity(i);
    }

}
