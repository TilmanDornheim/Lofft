package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-12.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordFragment extends Fragment {

    private View mView;
    private EditText newPW;
    private EditText oldPW;
    private Button change_pw;

    public ChangePasswordFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        mView = inflater.inflate(R.layout.change_password_fragment,container,false);
        TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
        String OldEmail = tinyDB.getString("email");
        mView = inflater.inflate(R.layout.change_name_fragment,container,false);
        newPW = (EditText)mView.findViewById(R.id.editText_newpassword);
        oldPW = (EditText)mView.findViewById(R.id.editText_pwconfirm_pw);
        change_pw = (Button)mView.findViewById(R.id.button_password_changed);
        setOnClickListener();


        return mView;



    }

    public void setOnClickListener(){
        change_pw.setOnClickListener(new View.OnClickListener(){

            TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
            String pw = tinyDB.getString("password");

            @Override
            public void onClick(View v){
                if (newPW.getText().toString().equals("") || oldPW.getText().toString().equals("")) {

                    Toast.makeText(getActivity().getApplicationContext(), "Please check your input", Toast.LENGTH_SHORT).show();
                } else {
                    if (oldPW.getText().toString().equals(pw)) {


                        tinyDB.putString("password", newPW.getText().toString());
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
