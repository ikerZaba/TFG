package com.example.menuapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContainerActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontainer);

        Button goback = (Button) findViewById(R.id.button6);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void saveCode(View view) {
        Bundle bundle = new Bundle();
        EditText contCode = (EditText) findViewById(R.id.edit_name);
        String code = contCode.getText().toString();
        EditText maxw = (EditText) findViewById(R.id.editTextMaxWeight);
        String maxweight = maxw.getText().toString();

        bundle.putString("code", code);
        bundle.putInt("maxweight", Integer.parseInt(maxweight));
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }


}
