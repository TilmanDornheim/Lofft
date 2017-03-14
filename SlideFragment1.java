package lofft.navigationdrawer;

/**
 * Created by tilma on 2017-03-03.
 */

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SlideFragment1 extends Fragment {

    private String title;
    private int page;
    private TextView tvLabel;
    private Button ok;
    private Button cancel;

    // newInstance constructor for creating fragment with arguments
    public static SlideFragment1 newInstance(int page, String title) {
        SlideFragment1 slideFragment1 = new SlideFragment1();
        return slideFragment1;
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
        View view = inflater.inflate(R.layout.slide_fragment1, container, false);

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
                tinyDB.putBoolean("item1_clicked",true);
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
