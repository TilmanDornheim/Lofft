package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-11.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddPostingFragment extends Fragment {

    private View mView;
    private EditText item;
    private EditText detail;
    private Button next;

    public AddPostingFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        mView= inflater.inflate(R.layout.add_posting_fragment,container,false);
        item= (EditText)mView.findViewById(R.id.editText_postName);
        detail = (EditText)mView.findViewById(R.id.editText_postDetail);
        next = (Button)mView.findViewById(R.id.bttn_postnext);
        setOnClickListener();





        return mView;


    }

    public void setOnClickListener(){
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String item_final = item.getText().toString();
                String detail_final = detail.getText().toString();
                TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
                tinyDB.putString("look_for",item_final);
                tinyDB.putString("detail",detail_final);


                AddPostingStep2Fragment addPostingStep2Fragment = new AddPostingStep2Fragment();
                FragmentManager manager = getChildFragmentManager();
                manager.beginTransaction().replace(R.id.relative_addpost,addPostingStep2Fragment,addPostingStep2Fragment.getTag()).commit();

            }
        });
    }

}
