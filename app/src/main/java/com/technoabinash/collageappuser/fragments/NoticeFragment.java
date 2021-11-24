package com.technoabinash.collageappuser.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.technoabinash.collageappuser.R;
import com.technoabinash.collageappuser.adapter.NoticeAdapter;
import com.technoabinash.collageappuser.model.NoticeData;

import java.util.ArrayList;


public class NoticeFragment extends Fragment {
    private DatabaseReference reference;
    private FirebaseDatabase firebaseDatabase;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private NoticeAdapter adapter;
    private ArrayList<NoticeData> noticeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        recyclerView = view.findViewById(R.id.notice_recyclerView);
        progressBar = view.findViewById(R.id.notice_progressBar);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Notice");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        getAllNotice();
        return view;
    }

    private void getAllNotice() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Notice");
        reference.orderByChild("date").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                noticeList = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    NoticeData data = dataSnapshot.getValue(NoticeData.class);
                    noticeList.add(data);
                }
                adapter = new NoticeAdapter(getContext(), noticeList);
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