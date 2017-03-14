package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-04.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MessagesFragment extends Fragment {

    private View mView;
    private Button addmsg;
    private Button contacts;

    public MessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.messages_fragment, container, false);
        addmsg = (Button) mView.findViewById(R.id.bttn_newmsg);
        contacts = (Button)mView.findViewById(R.id.bttn_contacts);
        setContactListener();
        setOnClickListener();


        return mView;

    }

    public void setOnClickListener(){

        addmsg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO add fragment

            }
        });

    }

    public void setContactListener(){

        contacts.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                //TODO add fragment

            }

        });

    }
}