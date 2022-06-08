package com.example.finalpro.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalpro.R;
import com.example.finalpro.adapter.HomeHorAdapter;
import com.example.finalpro.adapter.HomeVerAdapter;
import com.example.finalpro.adapter.UpdateVerticalRec;
import com.example.finalpro.models.HomeHorModel;
import com.example.finalpro.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homHorizontalRec ,homeVerticalRec ;
    ArrayList<HomeHorModel> homHorModelList;
    HomeHorAdapter homeHorAdapter;

    //// vertical/////



    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View root = inflater.inflate(R.layout.fragment_home,container,false);
        homHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);



        /// Horizontal *****************
        homHorModelList = new ArrayList<>();
        homHorModelList.add(new HomeHorModel(R.drawable.pizza,"Pizza"));
        homHorModelList.add(new HomeHorModel(R.drawable.hamburger,"HamBurger"));
        homHorModelList.add(new HomeHorModel(R.drawable.fries,"Fries"));
        homHorModelList.add(new HomeHorModel(R.drawable.ice_cream,"Ice Cream"));
        homHorModelList.add(new HomeHorModel(R.drawable.sandwich,"Sandwich"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homHorModelList);
        homHorizontalRec.setAdapter(homeHorAdapter);
        homHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homHorizontalRec.setHasFixedSize(true);
        homHorizontalRec.setNestedScrollingEnabled(false);

        homHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));


        /// vertical rec ****
        homeVerModelList = new ArrayList<>();

        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        return root;
    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}