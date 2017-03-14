package lofft.navigationdrawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tilma on 2017-03-06.
 */

public class CustomAdapter3 extends FragmentPagerAdapter {

    private Fragment fragment1;
    private Fragment fragment2;
    private static int  NUMITEMS = 2;

    public CustomAdapter3(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUMITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                fragment1 = new HomeSlideFrag1();
                return  fragment1;

            case 1:
                fragment2 = new HomeSlideFrag2();
                return fragment2;

            default: return null;

        }
    }
}
