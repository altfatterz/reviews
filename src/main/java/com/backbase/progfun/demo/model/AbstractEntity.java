package com.backbase.progfun.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class to derive entity classes from.
 *
 * @author Zoltan Altfatter
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    /*
     * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) obj;
        return this.id.equals(that.getId());
    }

    /*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    /**
     * Returns the identifier of the entity.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

}
