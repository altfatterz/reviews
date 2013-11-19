package com.backbase.progfun.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Base interface to use for Spring Data repositories that only expose read-only methods.
 *
 * @author Zoltan Altfatter
 */
@NoRepositoryBean
public interface ReadOnlyRepository<T> extends Repository<T, Long> {

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    T findOne(Long id);

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id must not be {@literal null}.
     * @return true if an entity with the given id exists, alse otherwise
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    boolean exists(Long id);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<T> findAll();

    /**
     * Returns all instances of the type with the given IDs.
     *
     * @param ids
     * @return
     */
    List<T> findAll(Iterable<Long> ids);

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    long count();

    /**
     * Returns all entities sorted by the given options.
     *
     * @param sort
     * @return all entities sorted by the given options
     */
    List<T> findAll(Sort sort);

}

