package com.backbase.progfun.demo.model;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.util.Assert;

/**
 * A value object abstraction of a website.
 *
 * @author Zoltan Altfatter
 */
@Embeddable
public class Website {

    private static final String WEBSITE_REGEX =
            "^(http(s?):\\/\\/)(www.)?(\\w|-)+(\\.(\\w|-)+)*((\\.[a-zA-Z]{2,3})|\\.(aero|coop|info|museum|name))+(\\/)?$";
    private static final Pattern PATTERN = Pattern.compile(WEBSITE_REGEX);

    private String value;

    /**
     * Creates a new {@link Website} from the given string source.
     *
     * @param website must not be {@literal null} or empty.
     */
    public Website(String website) {
        Assert.isTrue(isValid(website), "Invalid website!");
        this.value = website;
    }

    protected Website() {
    }

    /**
     * Returns whether the given {@link String} is a valid {@link Website} which means you can safely instantiate the
     * class.
     *
     * @param candidate
     * @return
     */
    public static boolean isValid(String candidate) {
        return candidate != null && PATTERN.matcher(candidate).matches();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())  {
            return false;
        }
        Website other = (Website) o;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + value.hashCode();
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return value;
    }

    @Column(name = "website")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
