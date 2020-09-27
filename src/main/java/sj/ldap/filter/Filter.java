package sj.ldap.filter;

/**
 * Rot of inheritance tree for all LDAP filter implementations.
 *
 * @author Andy Gray
 */
public interface Filter {

    /**
     * Null object filter to use in any dead nodes.
     */
    Filter NULL_FILTER = new Filter() {
        public StringBuffer writeFilterExpr(StringBuffer in) {
            return in;
        }
        public boolean hasValue() {
            return false;
        }
    };

    /**
     * Write the LDAP filter expression to the buffer and return it.
     * @param in to have the filter expression written to it.
     * @return in
     */
    StringBuffer writeFilterExpr(StringBuffer in);

    /**
     * @return whether this filter has a value to append.
     */
    boolean hasValue();


}
