package com.example.menuapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FillContainerActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillcontainer);

        Button goback = (Button) findViewById(R.id.button5);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void fillCode(View view) {
        Bundle bundle = new Bundle();
        EditText editText = (EditText) findViewById(R.id.edit_code);
        String code = editText.getText().toString();
        editText = (EditText) findViewById(R.id.editTextProductName);
        String name = editText.getText().toString();
        editText = (EditText) findViewById(R.id.editTextProductType);
        String type = editText.getText().toString();
        editText = (EditText) findViewById(R.id.editTextProductQuantity);
        String quant = editText.getText().toString();
        bundle.putString("code", code);
        bundle.putString("product", name);
        bundle.putString("type", type);
        bundle.putInt("quantity", Integer.parseInt(quant));
        Intent intent = new Intent(view.getContext(),Warehouse.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
