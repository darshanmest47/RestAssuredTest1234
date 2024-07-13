package com.pojos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value = {"title", "price", "description", "image", "category"})

public class MainBuilder {
    /* this is the main builder class*/
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public MainBuilder(String title, double price, String description, String image, String category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
