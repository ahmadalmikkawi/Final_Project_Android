package com.example.finalpro.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalpro.R;
import com.example.finalpro.models.HomeHorModel;
import com.example.finalpro.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.viewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        if(check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza 1", "10:00 - 23:00 ", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza 2", "10:00 - 23:00 ", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza 3", "10:00 - 23:00 ", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Pizza 4", "10:00 - 23:00 ", "4.9", "Min - $35"));
            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.carView.setOnClickListener(view -> {
                row_index = holder.getAdapterPosition();
                notifyDataSetChanged();

                if(position == 0) {
                    ArrayList<HomeVerModel> homeVerModels1 = new ArrayList<>();
                    homeVerModels1.add(new HomeVerModel(R.drawable.pizza1,"Pizza 1","10:00 - 23:00 ","4.9","Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.pizza2,"Pizza 2","10:00 - 23:00 ","4.9","Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.pizza3,"Pizza 3","10:00 - 23:00 ","4.9","Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.pizza4,"Pizza 4","10:00 - 23:00 ","4.9","Min - $35"));
                    updateVerticalRec.callBack(position , homeVerModels1);
                }
                else if(position == 1){
                    ArrayList<HomeVerModel> homeVerModels1 = new ArrayList<>();
                    homeVerModels1.add(new HomeVerModel(R.drawable.burger1, "burger 1", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.burger2, "burger 2", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.burger4, "burger 3", "10:00 - 23:00 ", "4.9", "Min - $35"));

                    updateVerticalRec.callBack(position , homeVerModels1);


                }
                else if(position == 2){
                    ArrayList<HomeVerModel> homeVerModels1 = new ArrayList<>();
                    homeVerModels1.add(new HomeVerModel(R.drawable.fries1, "fries 1", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.fries2, "fries 2", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.fries3, "fries 3", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.fries4, "fries 4", "10:00 - 23:00 ", "4.9", "Min - $35"));

                    updateVerticalRec.callBack(position , homeVerModels1);


                }
                else if(position == 3){
                    ArrayList<HomeVerModel> homeVerModels1 = new ArrayList<>();
                    homeVerModels1.add(new HomeVerModel(R.drawable.icecream1, "ice_cream 1", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.icecream2, "ice_cream 2", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.icecream3, "ice_cream 3", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.icecream4, "ice_cream 4", "10:00 - 23:00 ", "4.9", "Min - $35"));

                    updateVerticalRec.callBack(position , homeVerModels1);


                }
                else if(position == 4){
                    ArrayList<HomeVerModel> homeVerModels1 = new ArrayList<>();
                    homeVerModels1.add(new HomeVerModel(R.drawable.sandwich1, "sandwich 1", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.sandwich2, "sandwich 2", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.sandwich3, "sandwich 3", "10:00 - 23:00 ", "4.9", "Min - $35"));
                    homeVerModels1.add(new HomeVerModel(R.drawable.sandwich4, "sandwich 4", "10:00 - 23:00 ", "4.9", "Min - $35"));

                    updateVerticalRec.callBack(position , homeVerModels1);


                }
            });
            if (select){
                if (position == 0){
                    holder.carView.setBackgroundResource(R.drawable.change_bg);
                    select=false;

                }
            }
            else{
                if (row_index == position){
                    holder.carView.setBackgroundResource(R.drawable.change_bg);

                }else{
                    holder.carView.setBackgroundResource(R.drawable.default_bg);

                }
            }


    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView carView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hoe_img);
            name = itemView.findViewById(R.id.hor_text);
            carView = itemView.findViewById(R.id.cardView);
        }
    }
}
