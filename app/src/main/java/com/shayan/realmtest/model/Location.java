package com.shayan.realmtest.model;

import io.realm.RealmObject;

/**
 * Created by alex on 10/5/15.
 */
public class Location extends RealmObject{
    private String city;
    private String state;
    private String country;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
