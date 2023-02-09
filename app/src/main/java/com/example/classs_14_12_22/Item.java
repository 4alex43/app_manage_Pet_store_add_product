package com.example.class_14_12_22_;

public class Item {
    private int id;
    private String name;
    private double price;
    private String PicUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) name = "Unknown";
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        if (picUrl.isEmpty()){
            picUrl ="https://www.generationsforpeace.org/wp-content/uploads/2018/03/empty.jpg" ;
        }
        PicUrl = picUrl;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", PicUrl='" + PicUrl + '\'' +
                '}';
    }
}
