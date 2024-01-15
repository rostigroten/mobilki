package com.example.findtoeat.model;

public class Product {
    private String name;
    private String companyName;
    private String description;
    private float price;
    private int massInGrams;
    private int kiloCalories;
    private int proteins;
    private int carbohydrates;
    private int fats;

    public Product(String name, String description, float price, int massInGrams, int kiloCalories, int proteins, int carbohydrates, int fats,String companyName) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.massInGrams = massInGrams;
        this.kiloCalories = kiloCalories;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMassInGrams() {
        return massInGrams;
    }

    public void setMassInGrams(int massInGrams) {
        this.massInGrams = massInGrams;
    }

    public int getKiloCalories() {
        return kiloCalories;
    }

    public void setKiloCalories(int kiloCalories) {
        this.kiloCalories = kiloCalories;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }
}
