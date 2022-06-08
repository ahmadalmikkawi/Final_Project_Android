package com.example.finalpro.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalpro.R;
import com.example.finalpro.activities.DetailedDailyMealActivity;
import com.example.finalpro.models.DailyMealModel;

import java.util.List;

public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewHolder> {
    Context context;
    List<DailyMealModel> list;

    public DailyMealAdapter(Context context, List<DailyMealModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DailyMealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_item ,parent, false)));



    }

    @Override
    public void onBindViewHolder(@NonNull DailyMealAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.discount.setText(list.get(position).getDiscount());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailedDailyMealActivity.class);
            intent.putExtra("type",list.get(holder.getAdapterPosition()).getType());
            context.startActivity(intent);





        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, description,discount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView9);
            description = itemView.findViewById(R.id.textView10);
            discount = itemView.findViewById(R.id.textView11);



        }
    }
}
