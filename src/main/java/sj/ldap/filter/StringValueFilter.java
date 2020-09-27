/*
 * Created on 11-Jul-2006
 */
package sj.ldap.filter;

/**
 * Dynamic compared filter in teh form (attr=value),
 *
 * @author Andy Gray
 */
public class StringValueFilter extends ValueFilter {

    private String value = null;

    /**
     * @param attributeName
     */
    public StringValueFilter(String attributeName) {
        super(attributeName);
    }
    /**
     * @param attributeName
     * @param comparator
     */
    public StringValueFilter(String attributeName, String comparator) {
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
    public String getValue() {
        return value;
    }
    /**
     * @param value The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
