package com.example.todojava;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {
    DataBaseHelper myDB;
    ArrayList<Vinyas> userList;
    ListView listView;
    Vinyas vinyas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_contents);

        myDB=new DataBaseHelper(this);
        userList=new ArrayList<>();

        Cursor data=myDB.getListContents();
        int numRows= data.getCount();
        if(numRows==0){
            Toast.makeText(ViewListContents.this,"there is nothing in the database",Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext()){
                vinyas =new Vinyas(data.getString(1),data.getString(2),data.getString(3));
                userList.add(vinyas);
            }

            ListAdapter adapter=new ListAdapter( this,R.layout.list_adapter_view,userList);
            listView=(ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);
        }


    }
}
