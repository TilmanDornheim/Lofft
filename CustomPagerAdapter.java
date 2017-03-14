package lofft.navigationdrawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tilma on 2017-03-03.
 */

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<Fragment>();
        fragments.add(new SlideFragment1());
        fragments.add(new SlideFragment2());
        fragments.add(new SlideFragment3());



        }



    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public float getPageWidth (int position) {
        return 0.93f;
    }

}


