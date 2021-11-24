package com.technoabinash.collageappuser.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import com.technoabinash.collageappuser.R;
import com.technoabinash.collageappuser.model.NoticeData;

import java.util.ArrayList;

import static com.bumptech.glide.Glide.*;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {
    private Context context;
    ArrayList<NoticeData> noticeList;

    public NoticeAdapter(Context context, ArrayList<NoticeData> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_notice_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoticeData notice = noticeList.get(position);
        String noticeKey = notice.getKey();
        holder.title.setText(notice.getTitle());
        holder.dateTime.setText("Date " + notice.getDate() + " Time  " + notice.getTime());
        if (!notice.getImage().isEmpty()) {
            with(context).load(notice.getImage()).into(holder.fullImage);

        }
    }

    @Override
    public int getItemCount() {
        return noticeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fullImage;
        TextView title, dateTime;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            topimage = itemView.findViewById(R.id.deletNoticeImage);
            fullImage = itemView.findViewById(R.id.noticeImageView);
            dateTime = itemView.findViewById(R.id.datetime);
            title = itemView.findViewById(R.id.noticeTitle);

        }
    }
}
