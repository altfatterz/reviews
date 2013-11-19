package com.backbase.progfun.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.backbase.progfun.demo.model.Address;
import com.backbase.progfun.demo.repository.AddressRepository;

/**
 * Integration test for {@link Address}.
 *
 * @author Zoltan Altfatter
 */
public class AddressRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    AddressRepository repository;

    @Test
    public void count() {
        assertThat(repository.count(), is(2L));
    }

    @Test
    public void findAll() {
        assertThat(repository.findAll(), hasSize(2));
    }

    @Test
    public void findOne() {
        Address address = repository.findOne(1L);

        assertThat(address, is(notNullValue()));
        assertThat(address.getStreetName(), is("Achter Clarenburg"));
        assertThat(address.getStreetNumber(), is("6a"));
        assertThat(address.getPostcode(), is("3511 JJ"));
        assertThat(address.getCity(), is("Utrecht"));
    }

}
