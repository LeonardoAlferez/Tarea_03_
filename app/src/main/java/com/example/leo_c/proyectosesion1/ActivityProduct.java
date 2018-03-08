package com.example.leo_c.proyectosesion1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.leo_c.proyectosesion1.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {

    ImageView imageView;
    Button btnSave, btnCancel;
    EditText title, store, location, phone;
    ItemProduct product1, product2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        imageView = findViewById(R.id.activity_product_image);
        btnSave = findViewById(R.id.activity_product_save);
        btnCancel = findViewById(R.id.activity_product_cancel);
        title = findViewById(R.id.activity_product_title);
        store = findViewById(R.id.activity_product_store);
        location = findViewById(R.id.activity_product_location);
        phone= findViewById(R.id.activity_product_phone);

        if(getIntent().getExtras() != null){
            product1 = getIntent().getParcelableExtra("ITEM");
            if(product1 != null){
                switch (product1.getImage()){
                    case 0:
                        imageView.setImageResource(R.drawable.mac);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.alienware);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.lanix);
                        break;
                        default: imageView.setImageResource(R.drawable.mac);
                }
                title.setText(product1.getTittle());
                store.setText(product1.getStore());
                phone.setText(product1.getPhone());
                location.setText(product1.getLocation());

            }
        }
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                product2 = new ItemProduct();
                product2.setTitle(title.getText().toString());
                product2.setStore(store.getText().toString());
                product2.setLocation(location.getText().toString());
                product2.setPhone(phone.getText().toString());
                product2.setCode(product1.getCode());
                product2.setImage(product1.getImage());

                Intent intent = new Intent();
                intent.putExtra("ITEM", product2);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
