package com.example.leo_c.proyectosesion1;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leo_c.proyectosesion1.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by leo_c on 03/03/2018.
 */

public class FragmentHome extends android.support.v4.app.Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }
}
