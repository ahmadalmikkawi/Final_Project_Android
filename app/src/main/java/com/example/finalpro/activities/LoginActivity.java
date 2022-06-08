package com.example.finalpro.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

public class LoginActivity extends AppCompatActivity {

    EditText mEmail;
    EditText mPassword;
    FirebaseAuth fAuth;
    FirebaseFirestore firebaseFirestore;
    TextView sing;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

         mEmail = findViewById(R.id.editText2);
         mPassword = findViewById(R.id.log_pass);
         fAuth = FirebaseAuth.getInstance();
         sing =findViewById(R.id.sing);
         btn = findViewById(R.id.button);


        fAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        if(fAuth.getCurrentUser() != null){
             startActivity(new Intent(getApplicationContext(),MainActivity.class));
             finish();
         }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String email = mEmail.getText().toString();
                String pass = mPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(pass.length() < 6){
                    mPassword.setError("Password must be greater than 6 characters");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Login is Successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }



                    }
                });

            }
        });


        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}