package com.example.finalpro.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalpro.MainActivity;
import com.example.finalpro.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText mFullName;
    EditText mEmail;
    EditText mPassword;
   // Button btn2;


    FirebaseFirestore firebaseFirestore;
    FirebaseAuth fAuth;

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.ed_name);
        mEmail = findViewById(R.id.ed_pass);
        mPassword = findViewById(R.id.ed_email);

        fAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

         tv =findViewById(R.id.textView7);
         btn = findViewById(R.id.button_reg);




        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);


            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email = mEmail.getText().toString();
                String pass = mPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                }
               else if(TextUtils.isEmpty(pass)){
                    mPassword.setError("Password is Required.");
                }
                else if(pass.length() < 6){
                    mPassword.setError("Password must be greater than 6 characters");

                }
               else{

                   fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"User Created.",Toast.LENGTH_SHORT).show();

                            FirebaseUser user = fAuth.getCurrentUser();

                            if (user != null){
                                String uid = user.getUid();

                                HashMap<String,Object> data = new HashMap<>();

                                data.put("FullName" , mFullName.getText().toString());
                                data.put("Email" , mEmail.getText().toString());
                                data.put("uId" , uid);

                                firebaseFirestore.collection("Users")
                                        .add(data)
                                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                            if (task.isSuccessful()){
                                                System.out.println("Insert Success");
                                            }else{
                                                System.out.println("Insert Failed");
                                            }
                                            }
                                        });
                            }

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(RegisterActivity.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }}
        });
    }
}