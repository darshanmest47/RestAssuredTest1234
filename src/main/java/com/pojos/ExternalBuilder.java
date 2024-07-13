package com.pojos;

public class ExternalBuilder {
    /*this is the external builder class*/

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    private ExternalBuilder() {
    }

    public static ExternalBuilder build() {
        return new ExternalBuilder();
    }

    public ExternalBuilder with() {
        return this;
    }

    public ExternalBuilder and() {
        return this;
    }

    public MainBuilder perform() {
        return new MainBuilder(this.title, this.price, this.description, this.image, this.category);
    }

    public ExternalBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ExternalBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ExternalBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ExternalBuilder setImage(String image) {
        this.image = image;
        return this;
    }

    public ExternalBuilder setCategory(String category) {
        this.category = category;
        return this;
    }
}
