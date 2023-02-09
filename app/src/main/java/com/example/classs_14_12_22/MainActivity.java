package com.example.classs_14_12_22;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.class14_12_22.R;
import com.example.class_14_12_22_.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{


    private ListView lv;
    private Button btn1;
    private EditText petName, petPrice, petPic;
    private TextView count, tv;
    private ArrayList<Item> itemDArray;
    private int countPet = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        lv = findViewById(R.id.lv);
        btn1 = findViewById(R.id.btn1);
        petName = findViewById(R.id.etName);
        petPrice = findViewById(R.id.etPrice);
        petPic = findViewById(R.id.etPic);
        count = findViewById(R.id.countPet1);
        itemDArray = new ArrayList<com.example.class_14_12_22_.Item>();

        Intent data = getIntent();
        tv.setText("Hello " + data.getStringExtra("name"));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
                refresh_lv(itemDArray);
                petName.getText().clear();
                petPrice.getText().clear();
                petPic.getText().clear();

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,""+itemDArray.get(i), Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this,""+adapterView.getItemAtPosition(i), Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this,""+lv.getAdapter().getItem(i), Toast.LENGTH_LONG).show();
                com.example.class_14_12_22_.Item a = (com.example.class_14_12_22_.Item) lv.getAdapter().getItem(i);
                Dialog mDialog = new Dialog(MainActivity.this);
                mDialog.setContentView(R.layout.activity_item_card);

                TextView tvName = mDialog.findViewById(R.id.tvName);
                ImageView pic = mDialog.findViewById(R.id.iv);
                TextView tvId = mDialog.findViewById(R.id.tvId);
                TextView tvPrice = mDialog.findViewById(R.id.tvPrice);
                Button dialogBtn1 = mDialog.findViewById(R.id.btn1Y);
                Button dialogBtn2 = mDialog.findViewById(R.id.btn2N);

                tvId.setText("ID: " + a.getId());
                tvName.setText("Name: " + a.getName());
                tvPrice.setText("Price" + a.getPrice() + " $ ");
                Picasso.get().load(a.getPicUrl()).into(pic);
                mDialog.show();
                dialogBtn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemDArray.remove(a);
                        countPet--;
                        refresh_lv(itemDArray);
                        mDialog.dismiss();

                    }
                });

                dialogBtn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                    }
                });
                mDialog.setCancelable(true);

//Note when  move next page
               // Toast.makeText(MainActivity.this, "going to itemCard",Toast.LENGTH_LONG).show();
//Go to next Page
                /*
                Intent intent = new Intent(MainActivity.this, ItemCard.class);
                Item a = (Item) lv.getAdapter().getItem(i);
                intent.putExtra("id", a.getId() + "");
                intent.putExtra("name", a.getName());
                intent.putExtra("price", a.getPrice() + "");
                intent.putExtra("url", a.getPicUrl());
                startActivity(intent);

                 */
            }
        });

    }
    private void refresh_lv(ArrayList<com.example.class_14_12_22_.Item> array) {

        //lv <- array
       com.example.classs_14_12_22.MyAdapter adp = new com.example.classs_14_12_22.MyAdapter(this,
                android.R.layout.simple_list_item_1,
                array );
        lv.setAdapter(adp);
        count.setText("Pet in the list: " +countPet);
    }
    private void addItem() {
            com.example.class_14_12_22_.Item item = new com.example.class_14_12_22_.Item();

            item.setName(petName.getText().toString());
            if (petPrice.getText().toString().isEmpty()){
                item.setPrice(0);
            }
            else {
                item.setPrice(Double.parseDouble(petPrice.getText().toString()));
            }
            item.setId(countPet+=1);
            item.setPicUrl(petPic.getText().toString());
            itemDArray.add(item);//Add item to listArray

    }

}
