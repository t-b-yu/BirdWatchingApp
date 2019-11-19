package com.example.birdwatchingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonCreate, buttonEdit, buttonDelete, buttonFind;
    EditText editTextCreateTitle, editTextCreateAuthor, editTextEditTitle,
            editTextEditAuthor;
    EditText editTextDeleteAuthor, editTextFindAuthor;
    TextView textViewShowBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonFind = findViewById(R.id.buttonFind);

        editTextCreateAuthor = findViewById(R.id.editTextCreateAuthor);
        editTextCreateTitle = findViewById(R.id.editTextCreateTitle);
        editTextEditAuthor = findViewById(R.id.editTextEditAuthor);
        editTextEditTitle = findViewById(R.id.editTextEditTitle);
        editTextDeleteAuthor = findViewById(R.id.editTextDeleteAuthor);
        editTextFindAuthor = findViewById(R.id.editTextFindAuthor);

        textViewShowBooks = findViewById(R.id.textViewShowBooks);

        buttonCreate.setOnClickListener(this);
        buttonEdit.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonFind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
