package com.example.menuapp;

import android.content.Intent;
import android.os.Bundle;


import com.example.menuapp.databinding.ActivityWarehouseBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Warehouse extends AppCompatActivity {

    private ActivityWarehouseBinding binding;
    ListView listView;
    ArrayAdapter<String> todoItemsAdapter;
    public List<String> nameList = new ArrayList<>();
    Aplication app;
    int nContainers = 8;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWarehouseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        app = (Aplication) getApplicationContext();
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list);
        initializeList(nameList,app.getContainerList());
        todoItemsAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.listText, nameList);



        listView.setAdapter(todoItemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String clicked = (String) listView.getItemAtPosition(position);
                Container cont = app.getContainerList().get(position);
                Bundle bundle = new Bundle();
                bundle.putString("code",cont.getCode());
                bundle.putInt("maxweight",cont.getMaxWeight());
                bundle.putInt("currentweight",cont.getCurrentWeight());
                if(cont.getContent()!=null) bundle.putString("content",cont.getContent().getName());
                else bundle.putString("content","empty");

                Intent intent = new Intent(getApplicationContext(), ContainerInfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddContainerActivity.class);
                startActivityForResult(intent,1);


            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            int ind = findContainerIndex(bundle.getString("code"));
            if (ind!=-1){
                app.getContainerList().get(ind).setContent(new Product(bundle.getString("product"),bundle.getString("type"),1));
                app.getContainerList().get(ind).setCurrentWeight(bundle.getInt("quantity"));
                todoItemsAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_warehouse, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            //noinspection SimplifiableIfStatement
            case R.id.action_orders:
                Intent intent = new Intent(getApplicationContext(), Orders.class);
                startActivity(intent);
                break;
            case R.id.action_send:
                Intent intent2 = new Intent(getApplicationContext(), Send.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private int findContainerIndex(String code) {

        for (int i=0;i< app.getContainerList().size();i++){
            if(app.getContainerList().get(i).getCode().equals(code))  {
                return i;
            }
        }

        return -1;
    }

    public void initializeList(List<String> aNameList,List<Container> containerList) {

        for(int i=0; i<8; i++){
            containerList.add(new Container("A",i+1,1,1,3000));
            aNameList.add(i,containerList.get(i).getCode());

        }
    }

    public void addContainer(String corridor, int gap, int height, int box, int maxWeight){
        app.getContainerList().add(new Container(corridor,gap,height,box,maxWeight));
        nContainers++;
        nameList.add(nContainers,app.getContainerList().get(nContainers).getCode());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String code = bundle.getString("code");
            int maxWeight = bundle.getInt("maxweight");
            Container c = new Container(code, maxWeight);
            app.getContainerList().add(c);
            nameList.add(c.getCode());
            todoItemsAdapter.notifyDataSetChanged();
        }
    }
}