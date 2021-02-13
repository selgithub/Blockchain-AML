package com.springjwt.Authentication.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetname;
    private String streetno;
    private String city;

    public Address() {
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getStreetno() {
        return streetno;
    }

    public void setStreetno(String streetno) {
        this.streetno = streetno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

