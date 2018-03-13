package com.example.leo_c.proyectosesion1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leo_c.proyectosesion1.beans.ItemProduct;

import java.util.ArrayList;
import java.util.ArrayList.*;

/**
 * Created by leo_c on 26/02/2018.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    ArrayList<ItemProduct> products;
    Context context;
    public AdapterProduct(Context context, ArrayList<ItemProduct> myDataSet)
    {
        products = myDataSet;
        this.context = context;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button detail;
        public TextView title;
        public TextView store;
        public TextView location;
        public TextView phone;
        public ImageView image;
        public ImageView thumbnail;
        public RelativeLayout layout;
//
        public ViewHolder(View view){
            super(view);
            layout = (RelativeLayout) view.findViewById(R.id.item_product_layout);
            detail = (Button) view.findViewById(R.id.item_product_detail);
            title = (TextView) view.findViewById(R.id.item_product_title);
            store = (TextView) view.findViewById(R.id.item_product_store);
            location = (TextView) view.findViewById(R.id.item_product_location);
            phone = (TextView) view.findViewById(R.id.item_product_phone);
            image =(ImageView) view.findViewById(R.id.item_product_image);
            thumbnail = (ImageView) view.findViewById(R.id.item_product_thumbnail);

        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(products.get(position).getTittle());
        holder.store.setText(products.get(position).getStore());
        holder.location.setText(products.get(position).getLocation());
        holder.phone.setText(products.get(position).getPhone());
        switch (products.get(position).getImage()){
            case 0:
                holder.image.setImageResource(R.drawable.mac); break;
            case 1:
                holder.image.setImageResource(R.drawable.alienware); break;
            case 2:
                holder.image.setImageResource(R.drawable.lanix); break;
        }
        switch (products.get(position).getLocal_image()){
            case 0:
                holder.thumbnail.setImageResource(R.drawable.bestbuy); break;
            case 1:
                holder.thumbnail.setImageResource(R.drawable.dell); break;
            case 2:
                holder.thumbnail.setImageResource(R.drawable.lanixs); break;
        }
        holder.phone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel: "+products.get(position).getPhone()));
                context.startActivity(intent);
            }
        });

        holder.detail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, products.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemProduct itemProduct = new ItemProduct(products.get(position).getTitle(),
                        products.get(position).getStore(),
                        products.get(position).getLocation(),
                        products.get(position).getPhone(),
                        products.get(position).getImage(),
                        products.get(position).getDescription(),
                        products.get(position).getLocal_image(),
                        products.get(position).getCode());
                Intent intent = new Intent(context, ActivityProduct.class);
                intent.putExtra("ITEM", itemProduct);
                ((ActivityMain)context).startActivityForResult(intent,products.get(position).getCode());
            }
        });
    }



    @Override
    public int getItemCount() {
        return products.size();
    }
}
