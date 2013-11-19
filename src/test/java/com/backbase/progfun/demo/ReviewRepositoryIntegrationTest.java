package com.backbase.progfun.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.backbase.progfun.demo.repository.ReviewRepository;

/**
 * Integration test for {@link ReviewRepository}
 */
public class ReviewRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    ReviewRepository repository;

    @Test
    public void count() {
        assertThat(repository.count(), is(4L));
    }


}
