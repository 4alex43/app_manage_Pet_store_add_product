package com.example.classs_14_12_22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.class14_12_22.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<com.example.class_14_12_22_.Item> {

    private ArrayList<com.example.class_14_12_22_.Item> objects;
    private Context context;

    public MyAdapter(@NonNull Context context, int resource, ArrayList<com.example.class_14_12_22_.Item> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.design_row, null);

        TextView tvPrice = convertView.findViewById(R.id.tvPrice);
        TextView tvDesc = convertView.findViewById(R.id.tvDesc);
        TextView tvName = convertView.findViewById(R.id.tvName);
        ImageView iv = convertView.findViewById(R.id.iv);

        tvPrice.setText(""+(objects.get(position).getPrice()) + " $ ");
        tvDesc.setText("ID= "+(objects.get(position).getId()));
        tvName.setText("Name= " + objects.get(position).getName());
        Picasso.get().load(objects.get(position).getPicUrl()).into(iv);
/*
        if(position % 2 == 0) {
            //https://d2zp5xs5cp8zlg.cloudfront.net/image-29951-800.jpg
            Picasso.get().load("https://d2zp5xs5cp8zlg.cloudfront.net/image-29951-800.jpg").into(iv);
        } else {
            //iv <- https://albertamilk.com/wp-content/uploads/2020/12/Dog-500x500-1.jpg
            //iv.setImageResource(R.drawable.dog);
            Picasso.get().load("https://albertamilk.com/wp-content/uploads/2020/12/Dog-500x500-1.jpg).into(iv);

        }

 */
        return convertView;
    }
}
