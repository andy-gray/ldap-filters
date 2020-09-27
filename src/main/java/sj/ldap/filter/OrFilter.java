/*
 * Created on 11-Jul-2006
 */
package sj.ldap.filter;

/**
 * combines filters with an OR function.
 *
 * @author Andy Gray
 */
public class OrFilter extends AgregatingFilter {

    /**
     * @param filter1
     * @param filter2
     */
    public OrFilter(Filter filter1, Filter filter2) {
        super(OR, filter1, filter2);
    }
    /**
     * @param filter1
     * @param filter2
     * @param filter3
     */
    public OrFilter(Filter filter1,
                     Filter filter2,
                     Filter filter3) {
        // TODO Auto-generated constructor stub
        super(OR, filter1, filter2, filter3);
    }
    /**
     * @param filter1
     * @param filter2
     * @param filter3
     * @param filter4
     */
    public OrFilter(Filter filter1,
                     Filter filter2,
                     Filter filter3,
                     Filter filter4) {
        // TODO Auto-generated constructor stub
        super(OR, filter1, filter2, filter3, filter4);
    }
    /**
     * @param agregatingFunction
     * @param filters
     */
    public OrFilter(Filter[] filters) {
        // TODO Auto-generated constructor stub
        super(OR, filters);
    }
}
