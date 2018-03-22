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
import android.widget.LinearLayout;
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
    ArrayList<ItemProduct> mDataSet;
    private Context context;

    public AdapterProduct(Context context, ArrayList<ItemProduct> myDataSet){
        mDataSet = myDataSet;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button mDetail;
        public TextView mProductTitle;
        public TextView mProductStore;
        public TextView mProductLocation;
        public TextView mProductPhone;
        public ImageView mProductImage;
        public ImageView mProductThumbnail;
        public RelativeLayout mEventLayout;

        public ViewHolder(View v){
            super(v);
            mEventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);
            mDetail = (Button) v.findViewById(R.id.item_product_detail);
            mProductTitle = (TextView) v.findViewById(R.id.item_product_title);
            mProductStore = (TextView) v.findViewById(R.id.item_product_store);
            mProductLocation = (TextView) v.findViewById(R.id.item_product_location);
            mProductPhone = (TextView) v.findViewById(R.id.item_product_phone);
            mProductImage = (ImageView) v.findViewById(R.id.item_product_image);
            mProductThumbnail = (ImageView) v.findViewById(R.id.item_product_thumbnail);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mProductTitle.setText(mDataSet.get(position).getTitle());
        holder.mProductStore.setText(mDataSet.get(position).getStore().getName());
        holder.mProductLocation.setText(mDataSet.get(position).getStore().getCity().getName() + ", Jalisco");
        holder.mProductPhone.setText(mDataSet.get(position).getStore().getPhone());
        switch(mDataSet.get(position).getImage()){
            case 0:
                holder.mProductImage.setImageResource(R.drawable.mac); break;
            case 1:
                holder.mProductImage.setImageResource(R.drawable.alienware); break;
            case 2:
                holder.mProductImage.setImageResource(R.drawable.lanix); break;
        }
        switch(mDataSet.get(position).getStore().getId()){
            case 0:
                holder.mProductThumbnail.setImageResource(R.drawable.bestbuy); break;
            case 1:
                holder.mProductThumbnail.setImageResource(R.drawable.dell); break;
            case 2:
                holder.mProductThumbnail.setImageResource(R.drawable.lanixs); break;
        }


        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mDataSet.get(position).toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

        holder.mProductPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + mDataSet.get(position).getStore().getPhone()));
                context.startActivity(intent);
            }
        });

        holder.mProductImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ItemProduct itemProduct = new ItemProduct(
                        mDataSet.get(position).getCode(),
                        mDataSet.get(position).getTitle(),
                        mDataSet.get(position).getDescription(),
                        mDataSet.get(position).getImage(),
                        mDataSet.get(position).getStore(),
                        mDataSet.get(position).getCategory());

                Intent intent = new Intent(context, ActivityProduct.class);
                intent.putExtra("ITEM", itemProduct);
                ((ActivityMain) context).startActivityForResult(intent, mDataSet.get(position).getCode());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}