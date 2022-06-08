package com.example.finalpro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalpro.R;
import com.example.finalpro.models.HomeVerModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {


    FirebaseAuth fAuth;
    FirebaseFirestore firebaseFirestore;

    private BottomSheetDialog bottomSheetDialog;
    Context context;
    ArrayList<HomeVerModel> list;

    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.homw_vertical_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final  String mName = list.get(position).getName();
        final  String mTiming = list.get(position).getTiming();
        final  String mRating = list.get(position).getRating();
        final  String mPrice = list.get(position).getPrice();
        final  int mImage =  list.get(position).getImg();



        fAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        holder.imageView.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.timing.setText(list.get(position).getTiming());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetThem);

                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);
                sheetView.findViewById(R.id.add_to_cart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Added to Cart",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();

                    }
                });
                ImageView bottomImage = sheetView.findViewById(R.id.bottom_img);
                TextView bottomName = sheetView.findViewById(R.id.bottom_name);
                TextView bottomPrice= sheetView.findViewById(R.id.bottom_price);
                TextView bottomRating= sheetView.findViewById(R.id.bottom_rating);

                bottomName.setText(mName);
                bottomPrice.setText(mPrice);
                bottomRating.setText(mRating);
                bottomImage.setImageResource(mImage);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name ,timing , rating , price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.name);
            timing = itemView.findViewById(R.id.timing);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);

        }
    }
}
