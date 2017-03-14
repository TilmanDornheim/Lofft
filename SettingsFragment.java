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
import android.widget.TextView;

public class SettingsFragment extends Fragment {

    private View mView;
    private TextView user;
    private Button name;
    private Button email;
    private Button password;


    public SettingsFragment() {
        //required public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.settings_fragment, container, false);
        TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
        String userlogged = tinyDB.getString("username");
        user = (TextView) mView.findViewById(R.id.textView_user);
        user.setText(userlogged);
        name = (Button) mView.findViewById(R.id.button_name);
        email = (Button) mView.findViewById(R.id.button_email);
        password = (Button) mView.findViewById(R.id.button_password);
        // TODO Fix the weird overlap of fragments when replaced.
        // TODO Make it an activity,pass source when going back to main activity and if/else statement
        setNameListener();
        setEmailListener();
        setPasswordListener();


        return mView;
    }


    public void setNameListener() {

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TinyDB tinyDb = new TinyDB(getActivity().getApplicationContext());
                tinyDb.putString("Source", "settings");
                tinyDb.putString("Change", "name");
                getActivity().recreate();

            }
        });
    }

    public void setEmailListener() {
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
                tinyDB.putString("Source", "settings");
                tinyDB.putString("Change", "email");
                getActivity().recreate();
            }
        });
    }

    public void setPasswordListener() {
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
                tinyDB.putString("Source", "settings");
                tinyDB.putString("Change", "password");
                getActivity().recreate();
            }
        });
    }
}
