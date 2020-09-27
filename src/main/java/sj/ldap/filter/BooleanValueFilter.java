package sj.ldap.filter;

/**
 * Dynamic compared filter in the form (attr=[true|false]),
 *
 * @author Andy Gray
 */
public class BooleanValueFilter extends ValueFilter {

    private Boolean value = null;

    /**
     * @param attributeName
     */
    public BooleanValueFilter(String attributeName) {
        super(attributeName);
    }
    /**
     * @param attributeName
     * @param comparator
     */
    public BooleanValueFilter(String attributeName, String comparator) {
        super(attributeName, comparator);
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

    /**
     * @return Returns the value.
     */
    public Boolean getValue() {
        return value;
    }
    /**
     * @param value The value to set.
     */
    public void setValue(Boolean value) {
        this.value = value;
    }
}
