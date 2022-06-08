package com.example.finalpro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalpro.R;
import com.example.finalpro.models.FeatureVerModel;
import com.example.finalpro.models.SecoundVerModel;

import java.util.List;

public class SecoundVerAdapter extends RecyclerView.Adapter<SecoundVerAdapter.ViewHolder> {

    List<SecoundVerModel> list;

    public SecoundVerAdapter(List<SecoundVerModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public SecoundVerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.secound_ver_item,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull SecoundVerAdapter.ViewHolder holder, int position) {
       holder.imageView.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDescription());
        holder.rating.setText(list.get(position).getRating());
        holder.timing.setText(list.get(position).getTiming());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,desc,rating,timing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.secound_ver_img);
            name = itemView.findViewById(R.id.secound_ver_name);
            desc = itemView.findViewById(R.id.secound_ver_des);
            rating = itemView.findViewById(R.id.secound_ver_rating);
            timing = itemView.findViewById(R.id.secound_ver_timing);


        }
    }
}
