package com.technoabinash.collageappuser.adapter;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.technoabinash.collageappuser.BookShowActivity;
import com.technoabinash.collageappuser.R;
import com.technoabinash.collageappuser.model.Book;

import java.util.ArrayList;

import static com.bumptech.glide.Glide.*;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Book> eBooks;

    public EbookAdapter(Context context, ArrayList<Book> eBooks) {
        this.context = context;
        this.eBooks = eBooks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_book_view, parent, false);
        return new EbookAdapter.ViewHolder(view);
    }

    @SuppressLint("IntentReset")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book eBook=eBooks.get(position);
        holder.name.setText(eBook.getBookName());
        with(context).load(R.drawable.odf_icon).into(holder.icon);
        with(context).load(R.drawable.download_icon).into(holder.downloadBtn);
       holder.downloadBtn.setOnClickListener(view -> {
           Uri uri=Uri.parse(eBook.getDownloadLink());
           Intent intent = new Intent(Intent.ACTION_VIEW, uri);
          try{
              context.startActivity(intent);
          }catch (Exception e){
              e.printStackTrace();
          }
           Toast.makeText(context, eBook.getDownloadLink(), Toast.LENGTH_SHORT).show();
       });
       holder.itemView.setOnClickListener(view -> {
           Intent intent1=new Intent(context,BookShowActivity.class);
           intent1.putExtra("pdfUrl",eBook.getDownloadLink());
          context.startActivity(intent1);
       });

    }

    @Override
    public int getItemCount() {
        return eBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView downloadBtn,icon;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            downloadBtn=itemView.findViewById(R.id.btn_download);
            icon=itemView.findViewById(R.id.pdf_icon);
            name=itemView.findViewById(R.id.tv_bookName);
        }
    }
}
