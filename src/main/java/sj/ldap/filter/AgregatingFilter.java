/*
 * Created on 11-Jul-2006
 */
package sj.ldap.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Filter that combines subexpressions using a logical expression
 *
 * @author Andy Gray
 */
public abstract class AgregatingFilter implements Filter {
    public static final String AND = "&";
    public static final String OR = "|";

    private final String agregatingFunction;
    private final Filter[] filters;


    /**
     * @param agregatingFunction
     * @param filter1
     * @param filter2
     */
    public AgregatingFilter(final String agregatingFunction,
                            final Filter filter1,
                            final Filter filter2) {
        super();
        this.agregatingFunction = agregatingFunction;
        this.filters = new Filter[] {filter1, filter2};
    }

    /**
     * @param agregatingFunction
     * @param filter1
     * @param filter2
     */
    public AgregatingFilter(final String agregatingFunction,
                            final Filter filter1,
                            final Filter filter2,
                            final Filter filter3) {
        super();
        this.agregatingFunction = agregatingFunction;
        this.filters = new Filter[] {filter1, filter2, filter3};
    }

    /**
     * @param agregatingFunction
     * @param filter1
     * @param filter2
     */
    public AgregatingFilter(final String agregatingFunction,
                            final Filter filter1,
                            final Filter filter2,
                            final Filter filter3,
                            final Filter filter4) {
        super();
        this.agregatingFunction = agregatingFunction;
        this.filters = new Filter[] {filter1, filter2, filter3, filter4};
    }

    /**
     * @param agregatingFunction
     * @param filters
     */
    public AgregatingFilter(final String agregatingFunction,
                            final Filter[] filters) {
        super();
        this.agregatingFunction = agregatingFunction;
        this.filters = filters;
    }
    /**
     * @see sj.ldap.filter.Filter#hasValue()
     */
    public boolean hasValue() {
        for (int i = 0; i < filters.length; i++) {
            if (filters[i].hasValue()) {
                return true;
            }
        }
        return false;
    }
    /**
     * @see sj.ldap.filter.Filter#writeFilterExpr(java.lang.StringBuffer)
     */
    public StringBuffer writeFilterExpr(StringBuffer in) {

        List filtersWithAValue = new ArrayList();
        for (int i = 0; i < filters.length; i++) {
            if (filters[i].hasValue()) {
                filtersWithAValue.add(filters[i]);
            }
        }
        if (filtersWithAValue.size() > 1) {
            in.append("(").append(agregatingFunction);
        }
        Iterator iter = filtersWithAValue.iterator();
        while (iter.hasNext()) {
            Filter filter = (Filter) iter.next();
            filter.writeFilterExpr(in);
        }
        if (filtersWithAValue.size() > 1) {
            in.append(")");
        }
        return in;
    }
}
