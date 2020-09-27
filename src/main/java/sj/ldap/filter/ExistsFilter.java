package sj.ldap.filter;

/**
 * Immuteable filter that tests if an attribute as been specified.
 *
 * @author Andy Gray
 */
public class ExistsFilter extends ValueFilter {

    /**
     * @param attributeName ldap attr to match
     * @param value value to match against.
     */
    public ExistsFilter(String attributeName) {
        super(attributeName);
    }

    /**
     * @see sj.ldap.filter.ValueFilter#hasValue()
     */
    public boolean hasValue() {
        return true;
    }

    /**
     * @see sj.ldap.filter.ValueFilter#writeValue(java.lang.StringBuffer)
     */
    protected StringBuffer writeValue(StringBuffer in) {
        return in.append("*");
    }
}
