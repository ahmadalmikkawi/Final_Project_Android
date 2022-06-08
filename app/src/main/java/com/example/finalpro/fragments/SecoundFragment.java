package com.example.finalpro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalpro.R;
import com.example.finalpro.adapter.SecoundVerAdapter;
import com.example.finalpro.models.SecoundVerModel;

import java.util.ArrayList;
import java.util.List;

public class SecoundFragment extends Fragment {


    //******** Hor **********


    //******** ver ******

    List<SecoundVerModel> secoundVerModelList;
    RecyclerView recyclerView2;
    SecoundVerAdapter secoundVerAdapter;


    public SecoundFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_secound, container, false);

        //****** hor ***




        //****** Ver /***
        recyclerView2 = view.findViewById(R.id.secound_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));


        secoundVerModelList = new ArrayList<>();
        secoundVerModelList.add(new SecoundVerModel(R.drawable.ver1,"Feature 1","Description 1","4.8","10:00 - 8:00"));
        secoundVerModelList.add(new SecoundVerModel(R.drawable.ver2,"Feature 2","Description 2","4.8","10:00 - 8:00"));
        secoundVerModelList.add(new SecoundVerModel(R.drawable.ver3,"Feature 3","Description 3","4.8","10:00 - 8:00"));
        secoundVerModelList.add(new SecoundVerModel(R.drawable.ver1,"Feature 4","Description 4","4.8","10:00 - 8:00"));
        secoundVerModelList.add(new SecoundVerModel(R.drawable.ver2,"Feature 5","Description 5","4.8","10:00 - 8:00"));
        secoundVerModelList.add(new SecoundVerModel(R.drawable.ver3,"Feature 6","Description 6","4.8","10:00 - 8:00"));
        secoundVerModelList.add(new SecoundVerModel(R.drawable.ver3,"Feature 7","Description 7","4.8","10:00 - 8:00"));

        secoundVerAdapter = new SecoundVerAdapter(secoundVerModelList);
        recyclerView2.setAdapter(secoundVerAdapter);






        return view;
    }
}