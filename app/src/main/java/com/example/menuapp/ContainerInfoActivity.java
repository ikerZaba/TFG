package com.example.menuapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContainerInfoActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infocontainer);
        TextView label = (TextView) findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        String containerCode = bundle.getString("code");
        int currentweight = bundle.getInt("currentweight");
        int maxweight = bundle.getInt("maxweight");
        String product = bundle.getString("content");

        label.setText("Container "+containerCode);
        label.append("\n\nCurrent weight: "+currentweight+"/"+maxweight+"kg\n");
        label.append("Product: "+product+"\n");


        Button goback = (Button) findViewById(R.id.button4);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
