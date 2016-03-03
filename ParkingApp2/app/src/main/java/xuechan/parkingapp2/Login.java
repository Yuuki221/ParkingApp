package xuechan.parkingapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button bt_login, bt_register;
    EditText etUserNameLg, etPasswordLg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        bt_login = (Button) findViewById(R.id.button_login);
        bt_register = (Button) findViewById(R.id.button_register);
        etUserNameLg = (EditText) findViewById(R.id.editText_usernameLg);
        etPasswordLg = (EditText) findViewById(R.id.editText_passwordLg);

        OnLogin();
        OnRegister();

    }


    public void OnLogin (){
        bt_login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                                if (etUserNameLg.getText().toString().equals("user") &&
                                        etPasswordLg.getText().toString().equals("password")) {
                                    Toast.makeText(Login.this, "Your username and password are correct!",
                                            Toast.LENGTH_SHORT).show();
                                    Intent login = new Intent("xuechan.parkingapp2.TimeLocSet");
                                    startActivity(login);
                                } else {
                                    Toast.makeText(Login.this, "Your username and password are in correct, please try again",
                                            Toast.LENGTH_SHORT).show();
                                }



                    }
                }
        );
    }


    public void OnRegister (){
        bt_register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent register = new Intent("xuechan.parkingapp2.RegisterPage");
                        startActivity(register);

                    }
                }
        );
    }


}
