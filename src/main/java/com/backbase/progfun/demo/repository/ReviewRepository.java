package com.backbase.progfun.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.backbase.progfun.demo.model.Review;

/**
 * Repository interface to access {@link Review}s.
 *
 * @author Zoltan Altfatter
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
}
