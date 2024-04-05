package com.leminhbao.tuan01.listViewExercise;

public class Country {

    private int countryImageId;
    private String countryName;
    private int countryPopulation;

    public Country(int countryImageId, String countryName, int countryPopulation) {
        this.countryImageId = countryImageId;
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
    }

    public int getCountryImageId() {
        return countryImageId;
    }

    public void setCountryImageId(int countryImageId) {
        this.countryImageId = countryImageId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }
}
