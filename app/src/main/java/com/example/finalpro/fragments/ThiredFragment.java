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
import com.example.finalpro.adapter.ThiredVerAdapter;
import com.example.finalpro.models.SecoundVerModel;
import com.example.finalpro.models.ThiredVerModel;

import java.util.ArrayList;
import java.util.List;

public class ThiredFragment extends Fragment {

    List<ThiredVerModel> thiredVerModelList;
    RecyclerView recyclerView2;
    ThiredVerAdapter thiredVerAdapter;


    public ThiredFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thired, container, false);

        //****** Ver /***
        recyclerView2 = view.findViewById(R.id.thierd_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));


        thiredVerModelList = new ArrayList<>();
        thiredVerModelList.add(new ThiredVerModel(R.drawable.ver1,"Feature 1","Description 1","4.8","10:00 - 8:00"));
        thiredVerModelList.add(new ThiredVerModel(R.drawable.ver2,"Feature 2","Description 2","4.8","10:00 - 8:00"));
        thiredVerModelList.add(new ThiredVerModel(R.drawable.ver3,"Feature 3","Description 3","4.8","10:00 - 8:00"));
        thiredVerModelList.add(new ThiredVerModel(R.drawable.ver1,"Feature 4","Description 4","4.8","10:00 - 8:00"));
        thiredVerModelList.add(new ThiredVerModel(R.drawable.ver2,"Feature 5","Description 5","4.8","10:00 - 8:00"));
        thiredVerModelList.add(new ThiredVerModel(R.drawable.ver3,"Feature 6","Description 6","4.8","10:00 - 8:00"));
        thiredVerModelList.add(new ThiredVerModel(R.drawable.ver3,"Feature 7","Description 7","4.8","10:00 - 8:00"));

        thiredVerAdapter = new ThiredVerAdapter(thiredVerModelList);
        recyclerView2.setAdapter(thiredVerAdapter);






        return view;

    }
}