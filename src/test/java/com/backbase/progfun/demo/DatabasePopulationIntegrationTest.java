package com.backbase.progfun.demo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Dummy test class to make sure the setup method of the superclass executes correctly.
 *
 * @author Zoltan Altfatter
 */
public class DatabasePopulationIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void populateDatabase() {
        JdbcOperations operations = new JdbcTemplate(dataSource);
        assertThat(operations.queryForObject("select count(*) from restaurants", Integer.class), is(2));
        assertThat(operations.queryForObject("select count(*) from addresses", Integer.class), is(2));
        assertThat(operations.queryForObject("select count(*) from reviews", Integer.class), is(4));
    }
}
