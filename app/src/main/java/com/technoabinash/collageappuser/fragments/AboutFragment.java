package com.technoabinash.collageappuser.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.technoabinash.collageappuser.R;
import com.technoabinash.collageappuser.adapter.CourseAdapter;
import com.technoabinash.collageappuser.model.Course;

import java.util.ArrayList;

public class AboutFragment extends Fragment {
    private CourseAdapter adapter;
    private ArrayList<Course> courses;
    private ViewPager viewPager;
    ImageView colImg,map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_about, container, false);
        courses=new ArrayList<>();
        viewPager=view.findViewById(R.id.course_viewPager);
        colImg=view.findViewById(R.id.col_name_img);
        map=view.findViewById(R.id.map_location2);

        map.setOnClickListener(view1 -> {
            openMap();
        });


        courses=new ArrayList<>();
        courses.add(new Course(R.drawable.software_icon,"Software Enginering","Software engineering is defined as a process of analyzing user requirements and then designing, building, and testing software application which will satisfy those requirements."));
        courses.add(new Course(R.drawable.comm_icon,"E commerce","Ecommerce, also known as electronic commerce or internet commerce, refers to the buying and selling of goods or services using the internet, and the transfer of money and data to execute these transactions."));

        adapter=new CourseAdapter(getContext(),courses);
        viewPager.setAdapter(adapter);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/admincollageapp-2d64e.appspot.com/o/sliderImage%2F255px-Chengdu_Neusoft_University_logo.png?alt=media&token=03af6b14-79d3-44ba-a7bf-60ffdd4b6055").into(colImg);
        return view;
    }

    private void openMap() {
        Uri uri=Uri.parse("geo:0,0?q=1 Dongruan Ave, Dujiangyan City, Chengdu, Sichuan, China");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}