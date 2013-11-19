package com.backbase.progfun.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.Matchers.any;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revision;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backbase.progfun.demo.model.Restaurant;
import com.backbase.progfun.demo.model.Website;
import com.backbase.progfun.demo.repository.RestaurantRepository;

/**
 * Integration test for {@link RestaurantRepository}.
 */
public class RestaurantRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    RestaurantRepository repository;

    @Test
    public void count() {
        assertThat(repository.count(), is(2L));
    }

    @Test
    public void findByName() {
        assertThat(repository.findByName("Cafe Olivier"), is(notNullValue()));
    }

    @Test
    public void findByAddressPostcode() {
        assertThat(repository.findByAddressPostcode("3511 PA", any(Pageable.class)).getNumberOfElements(), is(greaterThan(0)));
    }

    @Test
    @Transactional
    public void save() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Cest Ca");

        Restaurant result = repository.save(restaurant);

        assertThat(result, is(notNullValue()));
        assertThat(result.getId(), is(notNullValue()));
        assertThat(result.getName(), is("Cest Ca"));
    }

    @Test
    @Transactional
    public void update() {
        Restaurant restaurant = repository.findOne(1L);
        restaurant.setWebsite(new Website("http://www.olivier.nl"));
        repository.save(restaurant);

        Restaurant result = repository.findOne(1L);

        assertThat(result, is(notNullValue()));
        assertThat(result.getId(), is(notNullValue()));
        assertThat(result.getWebsite(), is(new Website("http://www.olivier.nl")));
    }

    @Test
    @Transactional
    public void removeWithWebsite() {
        assertThat(repository.count(), is(2L));
        repository.removeRestaurantWithWebsite(new Website("http://www.cafeolivier.nl"));

        assertThat(repository.count(), is(1L));
    }

    @Test
    public void revision() {
        Revision<Integer, Restaurant> lastChangeRevision = repository.findLastChangeRevision(1L);
        assertThat(lastChangeRevision.getRevisionNumber(), is(1));
        assertThat(lastChangeRevision.getEntity().getName(), is("Cafe Olivier"));

        Restaurant restaurant = repository.findOne(1L);
        restaurant.setName("Updated");
        // update the restaurant in a new transaction
        save(restaurant);

        lastChangeRevision = repository.findLastChangeRevision(1L);
        assertThat(lastChangeRevision.getRevisionNumber(), is(3));
        assertThat(lastChangeRevision.getEntity().getName(), is("Updated"));

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void save(Restaurant restaurant) {
        repository.save(restaurant);
    }
}
