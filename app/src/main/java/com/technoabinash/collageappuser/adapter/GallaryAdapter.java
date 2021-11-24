package com.technoabinash.collageappuser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.technoabinash.collageappuser.R;

import java.util.ArrayList;

import static com.bumptech.glide.Glide.*;

public class GallaryAdapter extends RecyclerView.Adapter<GallaryAdapter.ViewHolder> {
    private ArrayList<String> imageList;
    private Context context;

    public GallaryAdapter(ArrayList<String> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_gallary_image_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imageUrl=imageList.get(position);
        if (!imageUrl.isEmpty()) {
            with(context).load(imageUrl).into(holder.image);

        }

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image123);
        }
    }
}
