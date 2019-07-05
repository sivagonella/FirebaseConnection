package com.example.firebaseconnection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NamesList extends AppCompatActivity {

    ArrayList<name> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        arrayList = new ArrayList<name>();

        final ListView listView = findViewById(R.id.shit);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Names");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    arrayList.add(d.getValue(name.class));
                }
                NamesAdapter namesAdapter = new NamesAdapter(getApplicationContext(), arrayList);
                listView.setAdapter(namesAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        Log.v("before", "Enterthe dragon");
//        for (name i : arrayList) {
//            Log.v("blah", i.getN());
//        }

    }
}
