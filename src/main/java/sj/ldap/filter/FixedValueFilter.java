package sj.ldap.filter;

/**
 * Immuteable value comparison filter.
 *
 * @author Andy Gray
 */
public class FixedValueFilter extends ValueFilter {

    private final String value;

    /**
     *
     * @param attributeName ldap attr to match
     * @param value value to match against.
     */
    public FixedValueFilter(String attributeName, Object value) {
        this(attributeName, EQ, value);
    }
    /**
     * @param attributeName ldap attr to match.
     * @param comparator comparison to use.
     * @param value value to match against.
     */
    public FixedValueFilter(String attributeName, String comparator, Object value) {
        super(attributeName, comparator);
        this.value = value.toString();
    }
    /**
     * @see sj.ldap.filter.ValueFilter#hasValue()
     */
    public boolean hasValue() {
        return this.value != null;
    }

    /**
     * @see sj.ldap.filter.ValueFilter#writeValue(java.lang.StringBuffer)
     */
    protected StringBuffer writeValue(StringBuffer in) {
        return in.append(this.value);
    }
}
