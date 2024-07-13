package com.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value = {"title", "price", "description", "image", "category"})
@Getter
@AllArgsConstructor
public class StaticInnerBuilder {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;


    public static class StaticInnerClass {
        private String title;
        private double price;
        private String description;
        private String image;
        private String category;

        private StaticInnerClass() {
        }

        public static StaticInnerClass build() {
            return new StaticInnerClass();
        }

        public StaticInnerClass and() {
            return this;
        }

        public StaticInnerClass with() {
            return this;
        }


        public StaticInnerBuilder perform() {
            return new StaticInnerBuilder(this.title, this.price, this.description, this.image, this.category);
        }

        public StaticInnerClass setTitle(String title) {
            this.title = title;
            return this;
        }

        public StaticInnerClass setPrice(double price) {
            this.price = price;
            return this;
        }

        public StaticInnerClass setDescription(String description) {
            this.description = description;
            return this;
        }

        public StaticInnerClass setCategory(String category) {
            this.category = category;
            return this;
        }

        public StaticInnerClass setImage(String image) {
            this.image = image;
            return this;
        }
    }
}
