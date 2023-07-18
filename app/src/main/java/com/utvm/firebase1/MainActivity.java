package com.utvm.firebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
TextView res;
DatabaseReference mDatabase;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*aqui copyy*/
    res=findViewById(R.id.idResultado);
//nodo principal de nuestra bd
    mDatabase= FirebaseDatabase.getInstance().getReference();
   //String nombre = mDatabase.child("GPS").toString();
   //res.setText(nombre);


    // obtener el campo principal
    mDatabase.child("Ubi").addValueEventListener(new ValueEventListener() {




        @Override
        public void onDataChange(DataSnapshot snapshot) {
       if (snapshot.exists()){
        String nombre = snapshot.child("ejemplo").getValue().toString();
       res.setText(nombre);

       }
        }

        @Override
        public void onCancelled(DatabaseError error) {

        }
    });

}
}