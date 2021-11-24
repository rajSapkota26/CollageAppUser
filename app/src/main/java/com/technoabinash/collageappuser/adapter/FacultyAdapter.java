package com.technoabinash.collageappuser.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.technoabinash.collageappuser.R;
import com.technoabinash.collageappuser.model.Teacher;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.bumptech.glide.Glide.*;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.viewHolder> {
    private ArrayList<Teacher> teachers;
    private Context context;

    public FacultyAdapter(ArrayList<Teacher> teachers, Context context) {
        this.teachers = teachers;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_teacher_view, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Teacher teacher = teachers.get(position);
        holder.name.setText(teacher.getName());
        holder.email.setText(teacher.getEmail());
        holder.post.setText(teacher.getPost());
        if (!teacher.getImage().isEmpty()) {
            with(context).load(teacher.getImage()).into(holder.image);
        }


    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name, email, post;
              CircleImageView image;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacher_name);
            email = itemView.findViewById(R.id.teacher_email);
            post = itemView.findViewById(R.id.teacher_post);
            image = itemView.findViewById(R.id.teacher_profile);

        }
    }
}
