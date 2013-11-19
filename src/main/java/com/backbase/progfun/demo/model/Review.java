package com.backbase.progfun.demo.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Represents a review of a restaurant.
 *
 * @author Zoltan Altfatter
 */
@Entity
@Table(name = "reviews")
public class Review extends AbstractEntity {

    private String user;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Rate rate;

    private final Date created = Calendar.getInstance().getTime();

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Date getCreated() {
        return created;
    }

}
