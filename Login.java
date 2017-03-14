package lofft.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private Button login;
    private Button signup;
    private View mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//Remove notification bar;


        setContentView(R.layout.activity_login);
        signup = (Button)findViewById(R.id.button_signup);
        login = (Button)findViewById(R.id.button_login);
        setOnClickListener();
        setSignupOnClickListener();

    }





    public void  setSignupOnClickListener() {
        signup = (Button)findViewById(R.id.button_signup);
        signup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i2 = new Intent(Login.this,Signup.class);
                        Login.this.startActivity(i2);
                    }
                }
        );

    }
    public void setOnClickListener(){
        login = (Button)findViewById(R.id.button_login);
        login.setOnClickListener(
                new View.OnClickListener(){
                     @Override
                    public void onClick(View v){
                         username = (EditText)findViewById(R.id.editText4);
                         password = (EditText)findViewById(R.id.editText3);
                         TinyDB tinyDB = new TinyDB(getApplicationContext());
                         String value_name = tinyDB.getString("name");
                         String value_username = tinyDB.getString("username");
                         String value_password = tinyDB.getString("password");

                         if (username.getText().toString().equals("Admin") && password.getText().toString().equals("guest")) {
                             Intent i = new Intent(Login.this, MainActivity.class);
                             i.putExtra("Source","Admin");
                             Login.this.startActivity(i);
                         } else if (username.getText().toString().equals(value_username) && password.getText().toString().equals(value_password)) {
                             Intent i = new Intent(Login.this, MainActivity.class);
                             tinyDB.putString("Source","login");
                             Login.this.startActivity(i);
                         }
                         
                         else {
                            Toast toast = Toast.makeText(Login.this, "Wrong username or password", Toast.LENGTH_LONG);
                             TextView view = (TextView) toast.getView().findViewById(android.R.id.message);
                             view.setTextColor(getResources().getColor(R.color.black));

                             toast.show();
                         }
                     }
                     }
        );


    }


}









