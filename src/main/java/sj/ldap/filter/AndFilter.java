package sj.ldap.filter;

/**
 * combines filters with an AND function.
 *
 * @author Andy Gray
 */
public class AndFilter extends AgregatingFilter {

    /**
     * @param filter1
     * @param filter2
     */
    public AndFilter(Filter filter1, Filter filter2) {
        super(AND, filter1, filter2);
    }
    /**
     * @param filter1
     * @param filter2
     * @param filter3
     */
    public AndFilter(Filter filter1,
                     Filter filter2,
                     Filter filter3) {
        // TODO Auto-generated constructor stub
        super(AND, filter1, filter2, filter3);
    }
    /**
     * @param filter1
     * @param filter2
     * @param filter3
     * @param filter4
     */
    public AndFilter(Filter filter1,
                     Filter filter2,
                     Filter filter3,
                     Filter filter4) {
        // TODO Auto-generated constructor stub
        super(AND, filter1, filter2, filter3, filter4);
    }
    /**
     * @param agregatingFunction
     * @param filters
     */
    public AndFilter(Filter[] filters) {
        // TODO Auto-generated constructor stub
        super(AND, filters);
    }
}
