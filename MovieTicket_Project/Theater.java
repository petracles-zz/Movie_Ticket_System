/**
 * Class used to represent an instance of a movie theater at the complex.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class Theater {

    /**
     * FIELDS:
     * 
     * Name of theater.
     */
    String name;

    /**
     * Capacity of theater.
     */
    int capacity;

    /**
     * Constructor:
     * 
     * @param name
     *            Name
     * @param capacity
     *            Capacity
     */
    public Theater(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Prints this theater as a String.
     * 
     * @return The theater's name.
     */
    public String toString() {
        return this.name;
    }

    /**
     * HashCode
     * 
     * @return hash#
     */
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * Constructs an instance of Theater from a String from the file.
     * 
     * @param s
     *            String passed in.
     * @return A new instance of Theater.
     */
    public static Theater makeTheaterFromString(String s) {
        Theater temp = new Theater("", 0);
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ':') {
                temp.name += s.charAt(i);
                i++;
            }
            else {
                i++;
                break;
            }
        }
        String cap = s.substring(i);
        temp.capacity = Integer.parseInt(cap);
        return temp;
    }
}
