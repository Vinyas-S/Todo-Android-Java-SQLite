package com.example.todojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Date, Time, Desc;
    Button btnAdd, btnView;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date = (EditText) findViewById(R.id.Date);
        Time = (EditText) findViewById(R.id.Time);
        Desc = (EditText) findViewById(R.id.Description);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDb=new DataBaseHelper(this);


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = Date.getText().toString();
                String time = Time.getText().toString();
                String desc = Desc.getText().toString();

                if (date.length() != 0 && time.length()!=0 && desc.length()!=0) {
                    AddData(date,time,desc);

                    Date.setText("");
                    Time.setText("");
                    Desc.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "You must put something in the text field", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void AddData(String date,String time,String desc){
        boolean insertdata=myDb.addData(date,time,desc);

        if(insertdata==true){
            Toast.makeText(MainActivity.this,"Todo Added",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }


    }



}