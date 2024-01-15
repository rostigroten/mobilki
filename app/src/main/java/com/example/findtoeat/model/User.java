package com.example.findtoeat.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<Product> favouriteProducts;

    public User(String email) {
        this.email = email;
        favouriteProducts = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getFavouriteProducts() {
        return favouriteProducts;
    }

    public void setFavouriteProducts(List<Product> favouriteProducts) {
        this.favouriteProducts = favouriteProducts;
    }
}
