package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-03.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment{

    FragmentPagerAdapter adapterViewPager;
    private View mView;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.content_main,container,false);
        ViewPager vpPager = (ViewPager)mView.findViewById(R.id.pager2);
        adapterViewPager = new CustomAdapter3(getChildFragmentManager());
        vpPager.setAdapter(adapterViewPager);


        return mView;


    }
}
