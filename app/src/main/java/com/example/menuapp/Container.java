package com.example.menuapp;

public class Container {
    private String code;
    private String corridor;
    private int gap;
    private int height;
    private int box;
    private int maxWeight;
    private int currentWeight;
    private com.example.menuapp.Product content;

    //We could omit saving the variables that compose the code (corridor-gap-height-box), but I have kept them for clarity
    public Container(String corridor,int gap,int height,int box,int maxWeight){
        this.code = corridor+"-"+gap+"-"+height+"-"+box;
        this.corridor = corridor;
        this.gap = gap;
        this.height = height;
        this.box = box;
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.content = null;
    }

    public Container(String code, int maxWeight) {
        this.code = code;
        String[] parts = code.split("-");
        this.corridor = parts[0];
        this.gap = Integer.parseInt(parts[1]);
        this.height = Integer.parseInt(parts[2]);
        this.box = Integer.parseInt(parts[3]);
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.content = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCorridor() {
        return corridor;
    }

    public void setCorridor(String corridor) {
        this.corridor = corridor;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public com.example.menuapp.Product getContent() {
        return content;
    }

    public void setContent(com.example.menuapp.Product content) {
        this.content = content;
    }
}
