package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-06.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BidsFragment extends Fragment {


    private View mView;
    FragmentPagerAdapter adapterViewPager;

    public BidsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        mView = inflater.inflate(R.layout.bids_fragment,container,false);
        ViewPager vpPager_new = (ViewPager)mView.findViewById(R.id.pager_bids);
        adapterViewPager = new CustomAdapter2(getChildFragmentManager(),getActivity().getApplicationContext());
        vpPager_new.setAdapter(adapterViewPager);

        return mView;

    }



}
