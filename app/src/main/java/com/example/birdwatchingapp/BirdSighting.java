package com.example.birdwatchingapp;

public class BirdSighting {

    public String birdName;
    public String zipCode;
    public String personReporting;

    public BirdSighting() {
    }

    public BirdSighting(String birdName, String zipCode, String personReporting) {
        this.birdName = birdName;
        this.zipCode = zipCode;
        this.personReporting = personReporting;
    }
}
