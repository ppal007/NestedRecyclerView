package com.ppal007.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {

    private TextView tvGallery, textViewParentName;
    private ImageView imageViewGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
//        finding xml.............................................................................
        textViewParentName = findViewById(R.id.tvGalleryParentName_id);
        tvGallery = findViewById(R.id.tvGallery_id);
        imageViewGallery = findViewById(R.id.imageViewGallery_id);

        //get image and string from recyclerViewAdapter
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String parentName = bundle.getString("ex_parent_name");
            String name = bundle.getString("ex_name");
            int image = bundle.getInt("ex_logo");


            setImageName(parentName, name, image);
        }

    }

    private void setImageName(String parentName, String name, int image) {
        //set parent name......................
        textViewParentName.setText(parentName);
        //set string to text view.....................
        tvGallery.setText(name);
        //set image in image view.........................
        imageViewGallery.setImageResource(image);

    }
}
