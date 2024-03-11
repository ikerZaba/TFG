package com.example.menuapp;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Orders extends Activity {
    Aplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders_layout);
        app = (Aplication) getApplicationContext();
        Button fill = (Button) findViewById(R.id.orders);
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), com.example.menuapp.FillContainerActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        Button goback = (Button) findViewById(R.id.button7);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
