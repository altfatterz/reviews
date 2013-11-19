package com.backbase.progfun.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.backbase.progfun.demo.model.Address;
import com.backbase.progfun.demo.model.Rate;
import com.backbase.progfun.demo.model.Restaurant;
import com.backbase.progfun.demo.model.Review;
import com.backbase.progfun.demo.model.Website;
import com.backbase.progfun.demo.repository.RestaurantRepository;

/**
 * Initialize the database with example data.
 *
 * @author Zoltan Altfatter
 */
public class DataLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    RestaurantRepository repository;

    @Transactional
    public void loadData() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Cafe Olivier");
        restaurant.setWebsite(new Website("http://www.cafeolivier.nl"));
        restaurant.setAddress(new Address("Achter Clarenburg", "6a", "3511 JJ", "Utrecht"));

        Review review = new Review();
        review.setUser("zoltan");
        review.setRate(Rate.EXCELLENT);
        review.setDescription("Amazing atmosphere. An old underground-catholic church, now rededicated to the worship of the finest belgian brews! ");
        restaurant.addReview(review);

        review = new Review();
        review.setUser("attila");
        review.setRate(Rate.POOR);
        review.setDescription("It's a little loud and not that comfortable");
        restaurant.addReview(review);

        repository.save(restaurant);

        restaurant = new Restaurant();
        restaurant.setName("'t Oude Pothuys");
        restaurant.setWebsite(new Website("http://www.pothuys.nl/"));
        restaurant.setAddress( new Address("Oudegracht 279 ", "279", "3511 PA", "Utrecht"));

        review = new Review();
        review.setUser("zoltan");
        review.setRate(Rate.GOOD);
        review.setDescription("A good surprise awaits you after the shady entrance. Nice and cozy restaurant with live music, nice food and friendly service.");
        restaurant.addReview(review);

        review = new Review();
        review.setUser("christian");
        review.setRate(Rate.POOR);
        review.setDescription("hard to talk because of loud live music");
        restaurant.addReview(review);

        repository.save(restaurant);
    }
}