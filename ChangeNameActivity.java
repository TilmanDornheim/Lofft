package lofft.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeNameActivity extends AppCompatActivity {

    private EditText new_name;
    private TextView old_name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_name_fragment);
        new_name = (EditText)findViewById(R.id.editText_newname);
        old_name = (TextView)findViewById(R.id.textView_oldname);
        password = (EditText)findViewById(R.id.editText_pwconfirm_name);
        TinyDB tinyDB = new TinyDB(this);
        String pw = tinyDB.getString("password");
        if(password.getText().toString().equals(pw) && !pw.isEmpty()) {
            tinyDB.putString("name",new_name.getText().toString());
            Toast.makeText(this, "Name successfully changed to "+ new_name.getText().toString(), Toast.LENGTH_LONG).show();
            tinyDB.putBoolean("source_settings",true);
            Intent i = new Intent(ChangeNameActivity.this,MainActivity.class);
            startActivity(i);
        }

        else {
            Toast.makeText(this, "Please check your password and make sure to enter a new name", Toast.LENGTH_SHORT).show();
        }




    }
}
