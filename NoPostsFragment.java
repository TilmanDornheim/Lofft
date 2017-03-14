package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-06.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NoPostsFragment extends Fragment {

    private View mView;
    private Button button_add_posting;

    public NoPostsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.no_posts_fragment,container,false);

        return mView;
    }

}
