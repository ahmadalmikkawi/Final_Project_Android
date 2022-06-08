package com.example.finalpro.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.finalpro.R;
import com.example.finalpro.adapter.DetailDailAdapter;
import com.example.finalpro.models.DetailDailModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<DetailDailModel> detailDailModels;
    DetailDailAdapter detailDailAdapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailDailModels = new ArrayList<>();
        detailDailAdapter = new DetailDailAdapter(detailDailModels);
        recyclerView.setAdapter(detailDailAdapter);

        if(type != null && type.equalsIgnoreCase("breakfast")){
            detailDailModels.add(new DetailDailModel(R.drawable.fav1 , "Breakfast","description","4.4","40","10 to 9"));
            detailDailModels.add(new DetailDailModel(R.drawable.fav2 , "Breakfast","description","4.4","40","10 to 9"));
            detailDailModels.add(new DetailDailModel(R.drawable.fav3 , "Breakfast","description","4.4","40","10 to 9"));

            detailDailAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("lunch")){

            imageView.setImageResource(R.drawable.lunch);
            detailDailModels.add(new DetailDailModel(R.drawable.ver1 , "Lunch","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.ver2, "Lunch","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.ver3 , "Lunch","description","4.4","40","10am to 9pm"));

            detailDailAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("dinner")){

            imageView.setImageResource(R.drawable.dinner);
            detailDailModels.add(new DetailDailModel(R.drawable.d1 , "Dinner","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.d2, "Dinner","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.d3 , "Dinner","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.d4 , "Dinner","description","4.4","40","10am to 9pm"));

            detailDailAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("sweets")){

            imageView.setImageResource(R.drawable.sweets);
            detailDailModels.add(new DetailDailModel(R.drawable.s1 , "Sweets","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.s2, "Sweets","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.s3 , "Sweets","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.s4 , "Sweets","description","4.4","40","10am to 9pm"));

            detailDailAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("coffee")){

            imageView.setImageResource(R.drawable.coffe);
            detailDailModels.add(new DetailDailModel(R.drawable.c1 , "Coffee","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.c2, "Coffee","description","4.4","40","10am to 9pm"));
            detailDailModels.add(new DetailDailModel(R.drawable.c3 , "Coffee","description","4.4","40","10am to 9pm"));

            detailDailAdapter.notifyDataSetChanged();
        }
    }
}