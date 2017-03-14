package lofft.navigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class BidFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private static ImageButton imageButton;
    private static ImageButton imageButton2;

    public BidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.addpostchoice, container, false);
        imageButton=(ImageButton)mView.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);
        imageButton2=(ImageButton)mView.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(this);
        return mView;
    }


        @Override
        public void onClick(View v) {

            switch(v.getId()) {

                case R.id.imageButton:

                    //NavigationView navigationView = (NavigationView)mView.findViewById(R.id.nav_view);
                    //navigationView.getMenu().getItem(1).setChecked(true);
                    RegisterFragment registerFragment = new RegisterFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.relative_choice, registerFragment,registerFragment.getTag()).commit();
                    break;


                case R.id.imageButton2:
                    registeredItems registeredItems = new registeredItems();
                    FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().replace(R.id.relative_choice,registeredItems,registeredItems.getTag()).commit();
                    break;
            }


        }
    }


