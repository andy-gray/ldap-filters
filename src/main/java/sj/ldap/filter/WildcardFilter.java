/*
 * Created on 11-Jul-2006
 */
package sj.ldap.filter;

/**
 * TODO Class that does something.
 *
 * @author Andy Gray
 */
public class WildcardFilter extends StringValueFilter {

    public static final int IS = 0;
    public static final int BEGINS = 1;
    public static final int ENDS = 2;
    public static final int CONTAINS = 3;

    public static final String[] WILDCARDS = {"is", "begins with", "ends with", "contains"};

    private int wildcardCode = 0;
    /**
     * @param attributeName
     */
    public WildcardFilter(String attributeName) {
        super(attributeName);
    }
    /**
     * @param attributeName
     * @param comparator
     */
    public WildcardFilter(String attributeName, String comparator) {
        super(attributeName, comparator);
    }

    /**
     * Override to include wildcard part.
     * @see sj.ldap.filter.ValueFilter#writeValue(java.lang.StringBuffer)
     */
    protected StringBuffer writeValue(StringBuffer in) {
        if ((wildcardCode & 1) > 0) {
            in.append("*");
        }
        in = super.writeValue(in);
        if ((wildcardCode & 2) > 0) {
            in.append("*");
        }
        return in;
    }
    /**
     * @return Returns the wildcardCode.
     */
    public int getWildcardCode() {
        return wildcardCode;
    }
    /**
     * @return Returns the wildcard.
     */
    public String getWildcard() {
        return WILDCARDS[wildcardCode];
    }

    /**
     * @param wildcard The wildcard to set.
     */
    public void setWildcardCode(int wildcard) {
        this.wildcardCode = wildcard;
    }
}
