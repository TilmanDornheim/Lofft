package lofft.navigationdrawer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by tilma on 2017-03-11.
 */

public class CustomAdapter4 extends FragmentPagerAdapter {

    private static int NUM_ITEMS=1;
    private Context context;
    private List<Fragment> fragments3;

    public CustomAdapter4(FragmentManager fm, Context c) {
        super(fm);
        context = c;
        this.fragments3 = new ArrayList<Fragment>();

        fragments3.add(new NoPostsFragment());



    }

    public int getCount(){
        return fragments3.size();
    }

    public Fragment getItem(int position){
        return fragments3.get(position);
    }
}
