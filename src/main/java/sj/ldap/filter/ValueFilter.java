/*
 * Created on 11-Jul-2006
 */
package sj.ldap.filter;

/**
 * Filter that matches a value against a LDAP attribute "(attr = param)".
 *
 * @author Andy Gray
 */
public abstract class ValueFilter implements Filter {

    /** equals comparison. */
    public static final String EQ = "=";
    /** greater than or equals comparison. */
    public static final String GE = ">=";
    /** greater than  comparison. */
    public static final String GT = ">";
    /** less than comparison. */
    public static final String LE = "<=";
    /** less than or equals comparison. */
    public static final String LT = "<";
    /** soundex (nearly equal) comparison. */
    public static final String SX = "~=";

    private final String attributeName;
    private final String comparator;



    /**
     * @param attributeName LDAP attribute to query against.
     */
    public ValueFilter(final String attributeName) {
        this(EQ, attributeName);
    }

    /**
     * @param attributeName LDAP attribute to query against.
     * @param comparator to do the comparison
     */
    public ValueFilter(final String attributeName, final String comparator) {
        super();
        this.attributeName = attributeName;
        this.comparator = comparator;
    }


    /**
     * @see sj.ldap.filter.Filter#writeFilterExpr(java.lang.StringBuffer)
     */
    public StringBuffer writeFilterExpr(StringBuffer in) {

        if (hasValue()) {
            in.append("(");
            in.append(attributeName);
            in.append(comparator);
            in = writeValue(in);
            in.append(")");
        }
        return in;
    }

    /**
     * apppend the value (parameter) portion of the comparison.
     * @param in to receive the value
     * @return in.
     */
    protected abstract StringBuffer writeValue(StringBuffer in);
}
