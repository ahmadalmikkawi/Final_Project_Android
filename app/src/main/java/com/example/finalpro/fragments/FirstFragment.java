package com.example.finalpro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalpro.R;
import com.example.finalpro.adapter.FeaturedAdapter;
import com.example.finalpro.adapter.FeaturedVerAdapter;
import com.example.finalpro.models.FeatureModel;
import com.example.finalpro.models.FeatureVerModel;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {


    //******** Hor **********
    List<FeatureModel> featureModelList;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;

    //******** ver ******

    List<FeatureVerModel> featureVerModelList;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;


    public FirstFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);



        //****** hor ***

        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));


        featureModelList = new ArrayList<>();
        featureModelList.add(new FeatureModel(R.drawable.fav1,"Feature 1","Description1"));
        featureModelList.add(new FeatureModel(R.drawable.fav2,"Feature 2","Description2"));
        featureModelList.add(new FeatureModel(R.drawable.fav3,"Feature 3","Description3"));

        featuredAdapter = new FeaturedAdapter(featureModelList);
        recyclerView.setAdapter(featuredAdapter);


    //****** Ver /***
        recyclerView2 = view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));


        featureVerModelList = new ArrayList<>();
        featureVerModelList.add(new FeatureVerModel(R.drawable.ver1,"Feature 1","Description 1","4.8","10:00 - 8:00"));
        featureVerModelList.add(new FeatureVerModel(R.drawable.ver2,"Feature 2","Description 2","4.8","10:00 - 8:00"));
        featureVerModelList.add(new FeatureVerModel(R.drawable.ver3,"Feature 3","Description 3","4.8","10:00 - 8:00"));
        featureVerModelList.add(new FeatureVerModel(R.drawable.ver1,"Feature 4","Description 4","4.8","10:00 - 8:00"));
        featureVerModelList.add(new FeatureVerModel(R.drawable.ver2,"Feature 5","Description 5","4.8","10:00 - 8:00"));
        featureVerModelList.add(new FeatureVerModel(R.drawable.ver3,"Feature 6","Description 6","4.8","10:00 - 8:00"));

        featuredVerAdapter = new FeaturedVerAdapter(featureVerModelList);
        recyclerView2.setAdapter(featuredVerAdapter);






    return view;
    }
}