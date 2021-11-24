package com.technoabinash.collageappuser.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.technoabinash.collageappuser.R;
import com.technoabinash.collageappuser.adapter.FacultyAdapter;
import com.technoabinash.collageappuser.model.Teacher;

import java.util.ArrayList;


public class FacultyFragment extends Fragment {
    private ArrayList<Teacher> list1,list;
    private RecyclerView viewSE, viewEC;
    private FacultyAdapter adapter;
    private TextView facultySE, facultyEC;
    private LinearLayout emptyFacultySE,emptyFacultyEC;
    private DatabaseReference reference,databaseReference;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_faculty, container, false);
        viewSE = view.findViewById(R.id.facultyRecyclerView);
        viewEC = view.findViewById(R.id.faculty1RecyclerView);
        facultySE = view.findViewById(R.id.faculty);
        facultyEC = view.findViewById(R.id.faculty1);
        emptyFacultySE = view.findViewById(R.id.emptyFaculty);
        emptyFacultyEC = view.findViewById(R.id.emptyFaculty1);
        progressBar = view.findViewById(R.id.faculty_progressBar);

        reference= FirebaseDatabase.getInstance().getReference().child("Teacher");
        facultySEget();
        facultyECget();

        return view;
    }

    private void facultyECget() {
        list1 = new ArrayList<>();
        databaseReference=reference.child("E-commerce");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    viewEC.setVisibility(View.GONE);
                    emptyFacultyEC.setVisibility(View.VISIBLE);
                }else {
                    viewEC.setVisibility(View.VISIBLE);
                    emptyFacultyEC.setVisibility(View.GONE);
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        Teacher teacher=dataSnapshot.getValue(Teacher.class);
                        list1.add(teacher);
                    }
                }
                viewEC.setHasFixedSize(true);
                viewEC.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter=new FacultyAdapter(list1,getContext());
                viewEC.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void facultySEget() {
        databaseReference=reference.child("Software engineering");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                if (!snapshot.exists()){
                    viewSE.setVisibility(View.GONE);
                    emptyFacultySE.setVisibility(View.VISIBLE);
                }else {
                    viewSE.setVisibility(View.VISIBLE);
                    emptyFacultySE.setVisibility(View.GONE);
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        Teacher teacher=dataSnapshot.getValue(Teacher.class);
                        list.add(teacher);
                    }
                }
                viewSE.setHasFixedSize(true);
                viewSE.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter=new FacultyAdapter(list,getContext());
                viewSE.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}