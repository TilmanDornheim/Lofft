package lofft.navigationdrawer;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

/**
 * Created by tilma on 2017-03-02.
 */




public class ProfileFragment extends Fragment {

    private TextView name;
    private ImageView profile_pic;
    private View mView;
    private static int RESULT_LOAD_IMAGE = 1;
    private String selectedImagePath;
    private Drawable yourDrawable;
    private ImageView change_profile;
    private ImageView fb_logo;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.profile_fragment, container, false);
        name = (TextView) mView.findViewById(R.id.textView_name);
        profile_pic = (ImageView) mView.findViewById(R.id.profile_pic);
        change_profile = (ImageView)mView.findViewById(R.id.change_profile);
        change_profile.bringToFront();
        fb_logo = (ImageView)mView.findViewById(R.id.fb_logo);
        fb_logo.bringToFront();
        Intent intent = getActivity().getIntent();
        String name_two = intent.getStringExtra("Name");
        String source_two = intent.getStringExtra("Source");

        switch (source_two) {
            case "Admin":
                name.setText("Michael Wilfert");
                profile_pic.setBackgroundResource(R.drawable.profile_pic);

                break;
            case "Signup":
                name.setText(name_two);
                profile_pic.setBackgroundResource(R.drawable.profile_head);
                break;
            default:
                Toast toast = Toast.makeText(getActivity(), "Switch broken", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }

        change_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), RESULT_LOAD_IMAGE);
            }
        });

        return mView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_LOAD_IMAGE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                try {
                    InputStream inputStream = getActivity().getContentResolver().openInputStream(selectedImageUri);
                    yourDrawable = Drawable.createFromStream(inputStream, selectedImageUri.toString());
                } catch (FileNotFoundException e) {
                    yourDrawable = getResources().getDrawable(R.drawable.profile_head);
                    Toast.makeText(getActivity().getApplicationContext(), "Catch", Toast.LENGTH_SHORT).show();
                }
                //profile_pic.setImageBitmap(BitmapFactory.decodeFile(selectedImagePath));
                Bitmap image = BitmapFactory.decodeFile(selectedImagePath);
                TinyDB tinyDB = new TinyDB(getActivity().getApplicationContext());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(image);
                tinyDB.putString("path",selectedImagePath);
                tinyDB.putImageWithFullPath(selectedImagePath,image);
                profile_pic = (ImageView)mView.findViewById(R.id.profile_pic);
                profile_pic.setBackgroundResource(R.drawable.blue_bg);
                profile_pic.setImageDrawable(yourDrawable);
                Toast.makeText(getActivity().getApplicationContext(), "Set Drawable", Toast.LENGTH_SHORT).show();
                LayoutParams params = new LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT
                );
                params.setMargins(250,170,0,0);
                profile_pic.setLayoutParams(params);
                profile_pic.getLayoutParams().height = (int)getResources().getDimension(R.dimen.profile_height);
                profile_pic.getLayoutParams().width = (int)getResources().getDimension(R.dimen.profile_width);


            }

        }
    }

    public String getPath(Uri uri) {
        // just some safety built in
        if (uri == null) {

            return null;
        }
        // try to retrieve the image from the media store first
        // this will only work for images selected from gallery
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String path = cursor.getString(column_index);
            cursor.close();
            return path;
        }
        // this is our fallback here
        return uri.getPath();
    }



}