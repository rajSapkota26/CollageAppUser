package com.technoabinash.collageappuser.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.technoabinash.collageappuser.R;

public class HomeFragment extends Fragment {

    SliderLayout sliderView;
    ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //slider
        sliderView = view.findViewById(R.id.images_slider);
        sliderView.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(1);
        setSliderImages();

        //map
        map=view.findViewById(R.id.map_location);
        map.setOnClickListener(view1 -> {
            openMap();
        });


        return view;
    }

    private void openMap() {
        Uri uri=Uri.parse("geo:0,0?q=1 Dongruan Ave, Dujiangyan City, Chengdu, Sichuan, China");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderImages() {
        for (int i = 0; i < 5; i++) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(getContext());

            switch (i) {
                case 0:
                    defaultSliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollageapp-2d64e.appspot.com/o/sliderImage%2F1.png?alt=media&token=607975e6-1b3a-482b-9985-7a9ba488f8e8");
                    break;
                case 1:
                    defaultSliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollageapp-2d64e.appspot.com/o/sliderImage%2F2.png?alt=media&token=47fe9969-a1d9-4db2-9f7b-e3c2e2bfcbf9");
                    break;
                case 2:
                    defaultSliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollageapp-2d64e.appspot.com/o/sliderImage%2F3.png?alt=media&token=77b38737-c400-4605-9829-b37ad49a3676");
                    break;
                case 3:
                    defaultSliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollageapp-2d64e.appspot.com/o/sliderImage%2F4.png?alt=media&token=85270909-82bf-4571-b550-606986a5de01");
                    break;
                case 4:
                    defaultSliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/admincollageapp-2d64e.appspot.com/o/sliderImage%2F5.png?alt=media&token=86d72911-a7c9-4604-9719-f62d0a40dd7e");
                    break;
            }
            defaultSliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderView.addSliderView(defaultSliderView);
        }
    }
}