package com.backbase.progfun.demo.model;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * Represents a restaurant.
 *
 * @author Zoltan Altfatter
 */
@Audited
@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractEntity {

    private String name;
    private Website website;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @Audited(targetAuditMode = NOT_AUDITED)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    @Audited(targetAuditMode = NOT_AUDITED)
    // When using @JoinColumn creates an unidirectional one-to-many mapping without a join table. (JPA 2.0 feature)
    // When one review is removed from the restaurant, the removed review is considered an orphan.
    // if orphanRemoval is set to true, the review will be deleted.
    private List<Review> reviews = Collections.emptyList();

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        if (reviews == Collections.EMPTY_LIST) {
            reviews = new ArrayList<Review>();
        }
        reviews.add(review);
    }
}

