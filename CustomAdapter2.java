package lofft.navigationdrawer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tilma on 2017-03-03.
 */

public class CustomAdapter2 extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private Context context;
    private List<Fragment> fragments2;
    private Boolean item1_clicked;
    private Boolean item2_clicked;
    private Boolean item3_clicked;

    public CustomAdapter2(FragmentManager fragmentManager, Context c) {
        super(fragmentManager);
        context = c;

        this.fragments2 = new ArrayList<Fragment>();

        TinyDB tinyDB = new TinyDB(context);
        if (tinyDB.getBoolean("item1_clicked")) {
            item1_clicked = true;
        }

        else { item1_clicked=false;}

        if (tinyDB.getBoolean("item2_clicked")) {
            item2_clicked = true;
        }

        else {item2_clicked=false;}

        if (tinyDB.getBoolean("item3_clicked")) {
            item3_clicked = true;
        }

        else {item3_clicked=false;}


        if (item1_clicked) {fragments2.add(new SlideFragment1());}
        if (item2_clicked) {fragments2.add(new SlideFragment2());}
        if (item3_clicked) {fragments2.add(new SlideFragment3());}
        if (!item1_clicked && !item2_clicked && !item3_clicked) {
            fragments2.add(new NoPostsFragment());
        }
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return fragments2.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {

            return fragments2.get(position);


        }


    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
