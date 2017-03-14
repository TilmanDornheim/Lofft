package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-11.
 */

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PostingsFragment extends Fragment {

    private View mView;
    private Button button_add_posting;
    FragmentPagerAdapter adapterViewPager;

    public PostingsFragment(){}

    public View OnCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    mView = inflater.inflate(R.layout.postings_fixed_fragment,container,false);
        button_add_posting = (Button)mView.findViewById(R.id.button_add_postings);
        setOnClickListener();

        ViewPager vpPager = (ViewPager)mView.findViewById(R.id.pager_postings);
        adapterViewPager = new CustomAdapter4(getChildFragmentManager(),getActivity().getApplicationContext());
        vpPager.setAdapter(adapterViewPager);

    return mView;
    }

    public void setOnClickListener(){
        button_add_posting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                NavigationView navigationView = (NavigationView)mView.findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(1).setChecked(true);
                AddPostingFragment addPostingFragment = new AddPostingFragment();
            }
        });
    }

}
