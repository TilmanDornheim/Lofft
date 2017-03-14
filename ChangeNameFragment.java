package lofft.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tilma on 2017-03-06.
 */

public class ChangeNameFragment extends Fragment{

    private View mView;
    private TextView oldName;
    private EditText newName;
    private EditText password;
    private Button change;

    public ChangeNameFragment(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
        String OldName = tinyDB.getString("name");
        mView = inflater.inflate(R.layout.change_name_fragment,container,false);
        oldName = (TextView)mView.findViewById(R.id.textView_oldname);
        newName = (EditText)mView.findViewById(R.id.editText_newname);
        password = (EditText)mView.findViewById(R.id.editText_pwconfirm_name);
        change = (Button)mView.findViewById(R.id.button_name_changed);
        oldName.setText("Current Name: " + OldName );
        setOnClickListener();


        return mView;

    }

    public void setOnClickListener(){

        change.setOnClickListener(new View.OnClickListener(){

            TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
            String pw = tinyDB.getString("password");

            @Override
            public void onClick(View v){

                if(newName.getText().toString().equals("") || password.getText().toString().equals("")) {

                    Toast.makeText(getActivity().getApplicationContext(), "Please check your input", Toast.LENGTH_SHORT).show();
                }

                else {

                    if(password.getText().toString().equals(pw)) {

                        tinyDB.putString("name",newName.getText().toString());
                        Toast.makeText(getActivity().getApplicationContext(), "Name succesfully changed", Toast.LENGTH_SHORT).show();
                        tinyDB.putString("Source","settings");
                        tinyDB.putString("Change","");
                        getActivity().recreate();


                    }


                }

            }

        });


    }

}
