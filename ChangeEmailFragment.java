package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-06.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeEmailFragment extends Fragment {

    private View mView;
    private TextView oldEmail;
    private EditText newEmail;
    private EditText password_mail;
    private  Button change_mail;



    public ChangeEmailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.change_email_fragment,container,false);
        TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
        String OldEmail = tinyDB.getString("email");

        oldEmail = (TextView)mView.findViewById(R.id.textView_oldmail);
        newEmail = (EditText)mView.findViewById(R.id.editText_newemail);
        password_mail = (EditText)mView.findViewById(R.id.editText_pwconfirm_email);
        change_mail = (Button)mView.findViewById(R.id.button_email_changed);
        oldEmail.setText("Current Email: " + OldEmail );
        setOnClickListener();
        return mView;

    }

    public void setOnClickListener() {


        change_mail.setOnClickListener(new View.OnClickListener(){

            TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
            String pw = tinyDB.getString("password");

            @Override
            public void onClick(View v) {

                if (newEmail.getText().toString().equals("") || password_mail.getText().toString().equals("")) {

                    Toast.makeText(getActivity().getApplicationContext(), "Please check your input", Toast.LENGTH_SHORT).show();
                } else {
                    if (password_mail.getText().toString().equals(pw)) {


                        tinyDB.putString("email", newEmail.getText().toString());
                        Toast.makeText(getActivity().getApplicationContext(), "Email succesfully changed", Toast.LENGTH_SHORT).show();
                        tinyDB.putString("Source", "settings");
                        tinyDB.putString("Change", "");
                        getActivity().recreate();

                    }

                    else {
                        Toast.makeText(getActivity().getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }


}
