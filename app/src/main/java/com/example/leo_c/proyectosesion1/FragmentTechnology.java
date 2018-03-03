package com.example.leo_c.proyectosesion1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leo_c.proyectosesion1.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by leo_c on 02/03/2018.
 */

public class FragmentTechnology extends android.support.v4.app.Fragment {
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentTechnology() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProduct> products = new ArrayList<>();

        products.add(new ItemProduct(getResources().getString(R.string.textMac),
                getResources().getString(R.string.textBestBuy),
                getResources().getString(R.string.textLocationMac),
                getResources().getString(R.string.textPhoneMac),
                0,
                getResources().getString(R.string.textDescriptionMac),
                0));

        products.add(new ItemProduct(getResources().getString(R.string.textAlien),
                getResources().getString(R.string.textOffice),
                getResources().getString(R.string.textLocationAlien),
                getResources().getString(R.string.textPhoneAlien),
                1,
                getResources().getString(R.string.textDescriptionAlien),
                1));

        products.add(new ItemProduct(getResources().getString(R.string.textLanix),
                getResources().getString(R.string.textCostco),
                getResources().getString(R.string.textLocationLanix),
                getResources().getString(R.string.textPhoneLanix),
                2,
                getResources().getString(R.string.textDescriptionLanix),
                2));

        AdapterProduct adapterProduct = new AdapterProduct(getActivity(),products);
        recyclerView.setAdapter(adapterProduct);
        return view;
    }
}