package com.example.firebaseconnection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firebaseconnection.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    name na ;
    DatabaseReference databaseReference ;
    String n  ;
    TextInputEditText textInputEditText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textInputEditText = (TextInputEditText) findViewById(R.id.name);



         databaseReference = FirebaseDatabase.getInstance().getReference().child("Names");


        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = textInputEditText.getText().toString();
                na = new name(n);
                databaseReference.push().setValue(na).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Successful",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, NamesList.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Fail",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
