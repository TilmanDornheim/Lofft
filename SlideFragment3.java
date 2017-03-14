package lofft.navigationdrawer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by tilma on 2017-03-03.
 */

public class SlideFragment3 extends Fragment {
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static SlideFragment3 newInstance(int page, String title) {
        SlideFragment3 slideFragment3 = new SlideFragment3();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        slideFragment3.setArguments(args);
        return slideFragment3;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slide_fragment3, container, false);
        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               createAndShowAlertDialog();
            }
        });
        return view;
    }
    private void createAndShowAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add?");
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
                tinyDB.putBoolean("item3_clicked",true);
                Toast.makeText(getActivity().getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //TODO
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
    }
}
