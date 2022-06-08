package com.example.finalpro.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalpro.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    private FirebaseFirestore firestore;
    private FirebaseAuth auth;
    private TextView User,Email;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         User=view.findViewById(R.id.tvf_user);
         Email=view.findViewById(R.id.tvf_email);
        firestore=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();

        firestore.collection("Users")
                .whereEqualTo("uId",auth.getCurrentUser().getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(QueryDocumentSnapshot snapshot:task.getResult()){
                            User.setText(snapshot.getData().get("FullName").toString());
                            Email.setText(snapshot.getData().get("Email").toString());
                        }
                    }
                });

    }
}