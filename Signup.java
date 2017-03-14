package lofft.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText username;
    private EditText password;
    private Button button;
    private View mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_signup);
        name = (EditText) findViewById(R.id.editText_name);
        email = (EditText) findViewById(R.id.editText_email);
        username = (EditText) findViewById(R.id.editText_username);
        password = (EditText) findViewById(R.id.editText_password);
        button = (Button) findViewById(R.id.bttn_signup);
        setOnClickListener();

    }
        public void setOnClickListener() {
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                TinyDB tinyDB = new TinyDB(getApplicationContext());
                tinyDB.clear();
                tinyDB.putBoolean("signup_source",true);
                tinyDB.putString("name",name.getText().toString());
                tinyDB.putString("email",email.getText().toString());
                tinyDB.putString("username",username.getText().toString());
                tinyDB.putString("password",password.getText().toString());
                Intent i = new Intent(Signup.this,Login.class);
                Signup.this.startActivity(i);
                Toast.makeText(Signup.this, "User " + username.getText().toString() + " successfully created", Toast.LENGTH_LONG).show();
            }
        });
    }


    }







