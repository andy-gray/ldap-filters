/*
 * Created on 11-Jul-2006
 */
package sj.ldap.filter;

/**
 * Filter that inferts another one.
 *
 * @author Andy Gray
 */
public class NotFilter implements Filter {

    private final Filter notted;

    /**
     * @param notted filter to invert.
     */
    public NotFilter(final Filter notted) {
        super();
        this.notted = notted;
    }

    /**
     * Appends "(!${notted.filter})" to the filter.
     * @see sj.ldap.filter.Filter#writeFilterExpr(java.lang.StringBuffer)
     */
    public StringBuffer writeFilterExpr(StringBuffer in) {
        in.append("(!");
        notted.writeFilterExpr(in);
        in.append(")");
        return in;
    }


    /**
     * @see sj.ldap.filter.Filter#hasValue()
     */
    public boolean hasValue() {
        return notted.hasValue();
    }
}
