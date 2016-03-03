package xuechan.parkingapp2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class PickTimeLocDuration extends AppCompatActivity {

    Button park, select_date;
    EditText park_duration;

    int year_p, month_p,day_p;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_time_loc_duration);
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

        final Calendar cal = Calendar.getInstance();
        year_p = cal.get(Calendar.YEAR);
        month_p = cal.get(Calendar.MONTH);
        day_p = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnSelectDate();
        OnClickPark ();

    }

    public void showDialogOnSelectDate(){
        select_date = (Button)findViewById(R.id.button_dateSelect);
        select_date.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog (int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this,dpickerListener, year_p, month_p, day_p);
        return null;

    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_p = year;
            month_p = monthOfYear + 1;
            day_p = dayOfMonth;
            Toast.makeText(PickTimeLocDuration.this,year_p + "/" + month_p + "/" + day_p, Toast.LENGTH_SHORT).show();
            //can do something there;
        }
    };

    public void OnClickPark (){
        park.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goToPark = new Intent("xuechan.parkingapp2.ChooseYourParkingLocation");
                        startActivity(goToPark);
                    }
                }
        );
    }



}
