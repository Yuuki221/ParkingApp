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
import android.widget.Toast;

import java.util.Calendar;

public class ProvideYourParkingInfo extends AppCompatActivity {

    Button start_1, start_2, end_1, end_2, finish;
    int year_pr, month_pr,day_pr;
    static final int DIALOG_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_your_parking_info);
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
        year_pr = cal.get(Calendar.YEAR);
        month_pr = cal.get(Calendar.MONTH);
        day_pr = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnSelectStart01();
        showDialogOnSelectEnd2();
        OnClickFinish ();


    }

    public void showDialogOnSelectStart01(){
        start_1 = (Button)findViewById(R.id.star01);
        start_1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_id);
                    }
                }
        );
    }

    public void showDialogOnSelectEnd2(){
        end_1 = (Button)findViewById(R.id.end01);
        end_1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_id);
                    }
                }
        );
    }


    @Override
    protected Dialog onCreateDialog (int id) {
        if (id == DIALOG_id)
            return new DatePickerDialog(this,dpickerListener, year_pr, month_pr, day_pr);
        return null;

    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_pr = year;
            month_pr = monthOfYear + 1;
            day_pr = dayOfMonth;
            Toast.makeText(ProvideYourParkingInfo.this, year_pr + "/" + month_pr + "/" + day_pr, Toast.LENGTH_SHORT).show();
            //can do something there;
        }
    };


    //deal with finish event
    public void OnClickFinish () {
        finish = (Button)findViewById(R.id.Finish);
        finish.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ProvideYourParkingInfo.this, " Congrates ! You successfuly enter your parking information !",
                                Toast.LENGTH_LONG).show();
                    }
                }
        );
    }






}
