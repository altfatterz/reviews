package com.backbase.progfun.demo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Abstract integration test to bootstrap the spring application context.
 *
 * @author Zoltan Altfatter
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AbstractIntegrationTest {
}
