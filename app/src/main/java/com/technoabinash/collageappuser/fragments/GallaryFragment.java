package com.technoabinash.collageappuser.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.technoabinash.collageappuser.adapter.FacultyAdapter;
import com.technoabinash.collageappuser.adapter.GallaryAdapter;
import com.technoabinash.collageappuser.model.Teacher;

import java.util.ArrayList;

public class GallaryFragment extends Fragment {
    private DatabaseReference reference,databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private RecyclerView eventRecyclerView,featureRecyclerView,regularRecyclerView;
    private ProgressBar progressBar;
    private GallaryAdapter adapter;
    private ArrayList<String> eImageList,fImageList,rImageList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_gallary, container, false);
        eventRecyclerView=view.findViewById(R.id.gallary_event_recyclerView);
        featureRecyclerView=view.findViewById(R.id.gallary_feature_recyclerView);
        regularRecyclerView=view.findViewById(R.id.gallary_regular_recyclerView);

        reference= FirebaseDatabase.getInstance().getReference().child("Gallary");
        featureImageGet();
        eventImageGet();
        regularImageget();
        
        return view;
    }

    private void featureImageGet() {
        fImageList=new ArrayList<>();
        databaseReference=reference.child("Feature Photos");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String rImg=dataSnapshot.getValue().toString();
                    fImageList.add(rImg);
                }
                featureRecyclerView.setHasFixedSize(true);
                featureRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                adapter=new GallaryAdapter(fImageList,getContext());
                featureRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void eventImageGet() {
        eImageList=new ArrayList<>();
        databaseReference=reference.child("Event Photos");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String rImg=dataSnapshot.getValue().toString();
                    eImageList.add(rImg);
                }
                eventRecyclerView.setHasFixedSize(true);
                eventRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                adapter=new GallaryAdapter(eImageList,getContext());
                eventRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void regularImageget() {
        rImageList=new ArrayList<>();
        databaseReference=reference.child("Regular Photos");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                   String rImg=dataSnapshot.getValue().toString();
                    rImageList.add(rImg);
                }
                regularRecyclerView.setHasFixedSize(true);
                regularRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                adapter=new GallaryAdapter(rImageList,getContext());
                regularRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}