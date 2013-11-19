package com.backbase.progfun.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Represents an address.
 *
 * @author Zoltan Altfatter
 */
@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity {

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private String streetNumber;

    private String postcode;

    private String city;

    public Address(String streetName, String streetNumber, String postcode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postcode = postcode;
        this.city = city;
    }

    protected Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
