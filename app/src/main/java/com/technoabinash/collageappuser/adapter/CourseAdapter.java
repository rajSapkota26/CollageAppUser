package com.technoabinash.collageappuser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.technoabinash.collageappuser.R;
import com.technoabinash.collageappuser.model.Course;

import java.util.ArrayList;

public class CourseAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Course> courses;

    public CourseAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_cources_view, container, false);
        ImageView cImage;
        TextView title,desc;
        cImage=view.findViewById(R.id.course_image);
        title=view.findViewById(R.id.course_title);
        desc=view.findViewById(R.id.course_description);

        cImage.setImageResource(courses.get(position).getImg());
        title.setText(courses.get(position).getTitle());
        desc.setText(courses.get(position).getDesc());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
