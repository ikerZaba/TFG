package com.example.menuapp;
import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseObject;
@ParseClassName("Product")

public class Product extends ParseObject{
    private String name;
    private String type;
    private int weight;

    public Product(String name, String type,int weight){
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
