package sj.ldap.filter;

/**
 * Filter that does something if value is true, smoething else if it is false.
 *
 * @author Andy Gray
 */
public class BinaryFilterFork implements Filter {

    private boolean value;

    private final Filter trueExpr;
    private final Filter falseExpr;

    /**
     * @param trueExpr
     * @param falseExpr
     */
    public BinaryFilterFork(final Filter trueExpr, final Filter falseExpr) {
        this.trueExpr = trueExpr;
        this.falseExpr = falseExpr;
    }

    /**
     * @see sj.ldap.filter.Filter#hasValue()
     */
    public boolean hasValue() {
        return (value) ? trueExpr.hasValue() : falseExpr.hasValue();
    }
    /**
     * @see sj.ldap.filter.Filter#writeFilterExpr(java.lang.StringBuffer)
     */
    public StringBuffer writeFilterExpr(StringBuffer in) {
        return (value) ? trueExpr.writeFilterExpr(in) : falseExpr.writeFilterExpr(in);
    }

    /**
     * @return Returns the value.
     */
    public boolean isValue() {
        return value;
    }
    /**
     * @param value The value to set.
     */
    public void setValue(boolean value) {
        this.value = value;
    }
}
