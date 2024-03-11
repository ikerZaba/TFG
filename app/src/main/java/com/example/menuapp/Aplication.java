package com.example.menuapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import com.parse.Parse;
import com.parse.ParseObject;

public class Aplication extends Application {
    ArrayList<Container> containerList;
    ArrayList<Product> productList;

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Product.class);

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("myAppId") //si no has cambiado APP_ID, sino pon el valor de APP_ID
                .clientKey("empty")
                .server("https://lab6ar.herokuapp.com/parse/")   // '/' important after 'parse'
                        .build());

    }

    public ArrayList<Container> getContainerList() {
        return containerList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}