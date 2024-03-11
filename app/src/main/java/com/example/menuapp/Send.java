package com.example.menuapp;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.parse.SaveCallback;

import java.lang.Object;

import java.text.ParseException;

public class Send extends Activity {
    Aplication app;
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_layout);

        app = (Aplication) getApplicationContext();

        Button goback = (Button) findViewById(R.id.button);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button send = (Button) findViewById(R.id.button9);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText contCode = (EditText) findViewById(R.id.editTextTextPersonName);
                String code = contCode.getText().toString();
                EditText q = (EditText) findViewById(R.id.editTextQuantity);
                String quantity = q.getText().toString();

                Product prod = productOfContainer(code);
                prod.setWeight(Integer.parseInt(quantity));
                prod.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        app.getProductList().add(prod);
                    }

                });

                sacarProducto(code,Integer.parseInt(quantity));
            }
        });
    }

    private void sacarProducto(String code,int quantity) {
        for (Container c : app.getContainerList()){
            if(c.getCode()==code){
                c.setCurrentWeight(c.getCurrentWeight()-quantity);
                break;
            }
        }
    }

    private Product productOfContainer(String code) {
        Product p = new Product("empty","no type",0);
        for (Container c : app.getContainerList()){
            if(c.getCode()==code){
                p = c.getContent();
                break;
            }
        }
        return p;
    }
}
