package com.example.Productjdbc.entity;

public class product {
    int id;
    String name;
    int price;
    double rating;
    String brand;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", brand='" + brand + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public product(int id, String name, int price, double rating, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.brand = brand;
    }
    public product(String name, int price, double rating, String brand) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.brand = brand;
    }
    public product() {
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getBrand() {
        return brand;
    }
}
