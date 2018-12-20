package com.mappala.kenneth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    Button saveButton;
    Button searchButton;

    DatabaseReference databasePerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databasePerson = FirebaseDatabase.getInstance().getReference("Person");

        saveButton = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        searchButton = (Button) findViewById(R.id.button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchData();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });
    }

    private void searchData(){
        Toast.makeText(this, "Person cannot be found", Toast.LENGTH_LONG).show();
    }
    private void saveData(){
        String fName = editText.getText().toString().trim();
        String age = editText2.getText().toString().trim();
        String gender = editText3.getText().toString().trim();

        if(!TextUtils.isEmpty(fName)){
            String personId = databasePerson.push().getKey();

            Data person = new Data(personId);

            databasePerson.child(personId).setValue(person);
            Toast.makeText(this, "Person successfully added!", Toast.LENGTH_LONG).show();


        }else{
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show();
        }
    }
}
