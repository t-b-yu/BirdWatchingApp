package com.example.birdwatchingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonCreate, buttonFind;
    EditText editTextCreateZip, editTextCreateBird, editTextCreatePerson;
    EditText editTextFindZip;
    TextView textViewShowBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonFind = findViewById(R.id.buttonFind);

        editTextCreateZip = findViewById(R.id.editTextCreateZip);
        editTextCreateBird = findViewById(R.id.editTextCreateBird);
        editTextCreatePerson = findViewById(R.id.editTextCreatePerson);
        editTextFindZip = findViewById(R.id.editTextFindZip);

        textViewShowBooks = findViewById(R.id.textViewShowBooks);

        buttonCreate.setOnClickListener(this);
        buttonFind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("bird sightings");

        if (view == buttonCreate) {
            String createZip = editTextCreateZip.getText().toString();
            String createBird = editTextCreateBird.getText().toString();
            String createPerson = editTextCreatePerson.getText().toString();

            BirdSighting createSighting = new BirdSighting(createBird, createZip, createPerson);

            myRef.push().setValue(createSighting); // pushes new object to database and asks for new identifier

        }
        else if (view == buttonFind){
            String findZip = editTextFindZip.getText().toString();
            myRef.orderByChild("zipCode").equalTo(findZip).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    //String findKey = dataSnapshot.getKey();
                    BirdSighting foundSighting = dataSnapshot.getValue(BirdSighting.class);
                    String findBirdName = foundSighting.birdName;
                    String findReporter = foundSighting.personReporting;
                    String findZip = foundSighting.zipCode;

                    textViewShowBooks.setText("The last bird sighting within the area with ZIP code " + findZip
                    + " was reported by " + findReporter + ". The bird sighted was a " + findBirdName + "."
                    );
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
