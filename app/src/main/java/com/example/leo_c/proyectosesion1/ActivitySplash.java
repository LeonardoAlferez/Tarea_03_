package com.example.leo_c.proyectosesion1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leo_c.proyectosesion1.beans.City;
import com.example.leo_c.proyectosesion1.beans.Store;
import com.example.leo_c.proyectosesion1.beans.User;
import com.example.leo_c.proyectosesion1.dataBase.DataBaseHandler;
import com.example.leo_c.proyectosesion1.dataBase.StoreControl;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                StoreControl storeControl = new StoreControl();
                ArrayList<Store> storeArrayList = storeControl.getStores(DataBaseHandler.getInstance(ActivitySplash.this));
                if (storeArrayList.size() == 0 || storeArrayList == null) {
                    storeControl.addStore(new Store(0, "BestBuy", "01800000", new City(2, "Guadalajara"),
                            0, 5.5, 6.6), DataBaseHandler.getInstance(ActivitySplash.this));
                    storeControl.addStore(new Store(0, "St. Jhonny", "01800000", new City(1, "Guadalajara"),
                            2, 5.5, 6.6), DataBaseHandler.getInstance(ActivitySplash.this));
                    storeControl.addStore(new Store(0, "Dell", "01800000", new City(6, "Guadalajara"),
                            1, 5.5, 6.6), DataBaseHandler.getInstance(ActivitySplash.this));
                }

                User user = loadUser();
                Intent intent;
                if (user.isLogged()) {
                    intent = new Intent(ActivitySplash.this, ActivityMain.class);
                } else {
                    intent = new Intent(ActivitySplash.this, ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }

    public User loadUser() {
        SharedPreferences sharedPreferences =
                getSharedPreferences("com.iteso.USER_PREFERENCES",
                        MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString("NAME", null));
        user.setPassword(sharedPreferences.getString("PWD", null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED", false));

        sharedPreferences = null;

        return user;
    }

}
