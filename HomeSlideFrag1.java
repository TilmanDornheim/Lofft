package lofft.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tilma on 2017-03-03.
 */

public class HomeSlideFrag1 extends Fragment {
    private String title;
    private int page;
    private TextView tvLabel;
    private static  Button bid;
    private View mView;
    private Button msg;

    // newInstance constructor for creating fragment with arguments
    public static HomeSlideFrag1 newInstance(int page, String title) {
        HomeSlideFrag1 homeSlideFrag1 = new HomeSlideFrag1();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        homeSlideFrag1.setArguments(args);
        return homeSlideFrag1;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.home_slide_frag1, container, false);
        bid=(Button)mView.findViewById(R.id.button_bid);
        msg=(Button)mView.findViewById(R.id.button_msg);
        setOnClickListener();
        setMsgOnClickListener();
        return mView;
    }

    public void setOnClickListener(){
        bid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
                tinyDB.putString("Source","bid");
                getActivity().recreate();
            }
        });
    }

    public void setMsgOnClickListener(){

        msg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
                tinyDB.putString("Source","Message");
                getActivity().recreate();

            }

        });

    }
}
