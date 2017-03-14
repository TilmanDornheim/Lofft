package lofft.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tilma on 2017-03-11.
 */

public class AddPostingStep2Fragment extends Fragment {
    private View mView;
    private TextView placeholder;
    private String name;

    public AddPostingStep2Fragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.addposting_step2_fragment,container,false);
        placeholder = (TextView)mView.findViewById(R.id.textView_addpost2);
        TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
        name = tinyDB.getString("name");
        placeholder.setText("Sorry " + name + ", this page aint done");


        return mView;

    }
}
