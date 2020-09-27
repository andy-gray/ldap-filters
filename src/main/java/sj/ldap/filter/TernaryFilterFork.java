/*
 * Created on 11-Jul-2006
 */
package sj.ldap.filter;

/**
 * Filter that does something if value is true, something else if it is false and something else again if it is null.
 *
 * @author Andy Gray
 */
public class TernaryFilterFork implements Filter {

    private static final int ITS_TRUE = 0;
    private static final int ITS_NULL = -1;
    private static final int ITS_FALSE = 1;

    private Boolean value;

    private final Filter trueExpr;
    private final Filter nullExpr;
    private final Filter falseExpr;

    /**
     * @param trueExpr what to do if vlaue is false
     * @param nullExpr what to do if vlaue is null.
     * @param falseExpr what to do if vlaue is false
     */
    public TernaryFilterFork(final Filter trueExpr, final Filter nullExpr, final Filter falseExpr) {
        this.trueExpr = trueExpr;
        this.nullExpr = nullExpr;
        this.falseExpr = falseExpr;
    }

    /**
     * @see sj.ldap.filter.Filter#hasValue()
     */
    public boolean hasValue() {
        if (value == null) {
            return nullExpr.hasValue();
        } else if (value.booleanValue()) {
            return trueExpr.hasValue();
        } else {
            return falseExpr.hasValue();
        }
    }

    /**
     * @see sj.ldap.filter.Filter#writeFilterExpr(java.lang.StringBuffer)
     */
    public StringBuffer writeFilterExpr(StringBuffer in) {
        if (value == null) {
            return nullExpr.writeFilterExpr(in);
        } else if (value.booleanValue()) {
            return trueExpr.writeFilterExpr(in);
        } else {
            return falseExpr.writeFilterExpr(in);
        }
    }

    /**
     * @return Returns the value.
     */
    public Boolean isValue() {
        return value;
    }
    /**
     * @param value The value to set.
     */
    public void setValue(Boolean value) {
        this.value = value;
    }
}
