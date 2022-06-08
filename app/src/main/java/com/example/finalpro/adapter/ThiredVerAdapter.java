package com.example.finalpro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalpro.R;
import com.example.finalpro.models.SecoundVerModel;
import com.example.finalpro.models.ThiredVerModel;

import java.util.List;

public class ThiredVerAdapter extends RecyclerView.Adapter<ThiredVerAdapter.ViewHolder> {

    List<ThiredVerModel> list;

    public ThiredVerAdapter(List<ThiredVerModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ThiredVerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.thierd_ver_item,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull ThiredVerAdapter.ViewHolder holder, int position) {
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
            imageView = itemView.findViewById(R.id.thired_ver_img);
            name = itemView.findViewById(R.id.thired_ver_name);
            desc = itemView.findViewById(R.id.thired_ver_des);
            rating = itemView.findViewById(R.id.thired_ver_rating);
            timing = itemView.findViewById(R.id.thired_ver_timing);


        }
    }
}
