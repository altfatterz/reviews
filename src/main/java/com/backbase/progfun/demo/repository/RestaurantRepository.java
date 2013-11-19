package com.backbase.progfun.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;

import com.backbase.progfun.demo.model.Restaurant;

/**
 * Repository interface to access {@link Restaurant}s.
 *
 * @author Zoltan Altfatter
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>, RestaurantRepositoryCustom,
        RevisionRepository<Restaurant, Long, Integer> {

    // with rest-shell: get findByName --params "{name:'Cafe Olivier'}"
    Restaurant findByName(@Param("name") String name);

    // get findByAddressPostcode --params "{postcode : '3511 PA'}"
    Page<Restaurant> findByAddressPostcode(@Param("postcode") String postcode, Pageable pageable);

    // post data with rest-shell:
    // post --data "{name:'dummy'}"
}
