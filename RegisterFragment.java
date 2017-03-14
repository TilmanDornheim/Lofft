package lofft.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tilma on 2017-03-02.
 */

public class RegisterFragment extends Fragment{


    private View mView;
    private EditText what_item;
    private EditText description;
    private Button bttn_next;

        public RegisterFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            mView= inflater.inflate(R.layout.register_fragment, container, false);
            what_item = (EditText)mView.findViewById(R.id.editText_what);
            description = (EditText)mView.findViewById(R.id.editText_brief);
            bttn_next = (Button)mView.findViewById(R.id.button_next);
            setOnClickListener();

            return mView;
        }

    public void setOnClickListener() {
        what_item = (EditText)mView.findViewById(R.id.editText_what);
        description = (EditText)mView.findViewById(R.id.editText_brief);
        bttn_next = (Button)mView.findViewById(R.id.button_next);
        bttn_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }

    }


