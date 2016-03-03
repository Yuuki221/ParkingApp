package xuechan.parkingapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimeLocSet extends AppCompatActivity {

    Button park, prvPark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_loc_set);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        wantTopark();
        prvParking();


    }

    public void wantTopark (){
        park = (Button)findViewById(R.id.button_findPark);
        park.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goToseekPark = new Intent("xuechan.parkingapp2.PickTimeLocDuration");
                        startActivity(goToseekPark);
                    }
                }
        );
    }

    public void prvParking (){
        prvPark = (Button)findViewById(R.id.button_ProPark);
        prvPark.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent prvdParking = new Intent("xuechan.parkingapp2.PrvParkInfo");
                        startActivity(prvdParking);
                    }
                }
        );
    }

}
