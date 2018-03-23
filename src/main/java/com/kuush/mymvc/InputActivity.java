package com.kuush.mymvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.kuush.mymvc.data.Model;

public class InputActivity extends AppCompatActivity {
    public EditText inputName;
    public EditText inputNumber;
    public Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new Model();
        setContentView(R.layout.activity_input);
        inputName = (EditText) findViewById(R.id.nameInput);
        inputNumber = (EditText) findViewById(R.id.numberInput);
    }
    public void onSaveBtn(View view){
        model.insertTheData(inputName,inputNumber,getApplicationContext());
        Intent intent = new Intent(this,MVCPhoneBook.class);
        startActivity(intent);
    }

}