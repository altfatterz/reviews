package com.backbase.progfun.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Configuration to export managed entities via a REST service.
 *
 * @author Zoltan Altfatter
 */
@Configuration
@Import(RepositoryRestMvcConfiguration.class)
public class WebConfig {
}
