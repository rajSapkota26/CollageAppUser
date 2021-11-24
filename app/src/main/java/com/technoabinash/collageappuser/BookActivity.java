package com.technoabinash.collageappuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.technoabinash.collageappuser.adapter.EbookAdapter;
import com.technoabinash.collageappuser.model.Book;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private EbookAdapter adapter;
    private RecyclerView recyclerView;
    private DatabaseReference reference;
    private ProgressBar progressBar;
    private ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        recyclerView = findViewById(R.id.book_recyclerView);
        progressBar = findViewById(R.id.book_progressBar);
        reference = FirebaseDatabase.getInstance().getReference().child("Book");




        getAllBooks();
    }

    private void getAllBooks() {
        books = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Book data = dataSnapshot.getValue(Book.class);
                    books.add(data);
                }
                adapter = new EbookAdapter(getApplicationContext(), books);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                layoutManager.setReverseLayout(true);
                layoutManager.setStackFromEnd(true);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);

            }
        });
    }
}