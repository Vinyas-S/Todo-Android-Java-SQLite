package com.example.todojava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Vinyas> {


    private LayoutInflater mInflater;
    private ArrayList<Vinyas> users;
    private int mViewResourceId;


    public ListAdapter(Context context, int textViewResourceId,ArrayList<Vinyas> users) {
        super(context, textViewResourceId,users);
        this.users = users;
        this.mViewResourceId = textViewResourceId;
        mInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        convertView=mInflater.inflate(mViewResourceId,null);

        Vinyas vinyas=users.get(position);
        if(vinyas!=null){
            TextView firstName=(TextView) convertView.findViewById(R.id.textFirstName);
            TextView lastName=(TextView) convertView.findViewById(R.id.textLastName);
            TextView favFood=(TextView) convertView.findViewById(R.id.textFavFood);

            if(firstName!=null){
                firstName.setText((vinyas.getDate()));
            }
            if(lastName!=null){
                lastName.setText((vinyas.getTime()));
            }
            if(favFood!=null){
                favFood.setText((vinyas.getDescription()));
            }
        }
        return convertView;
    }
}
