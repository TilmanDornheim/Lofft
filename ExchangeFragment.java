package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-03.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.util.Calendar;

public class ExchangeFragment extends Fragment implements CalendarView.OnDateChangeListener{

    CalendarView calendar=null;
    private View mView;

    public ExchangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.exchanges_fragment, container, false);

        calendar=(CalendarView)mView.findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(this);
        return mView;

    }


    @Override
    public void onSelectedDayChange(CalendarView view,int year,int monthofyear,int dayofmonth) {
        Calendar then = new java.util.GregorianCalendar(year,monthofyear,dayofmonth);




    }
}
