/**
 * Class used to represent a PRICE available at the complex.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class Price {

    /**
     * FIELDS:
     * 
     * Name of PRICE.
     */
    String name;

    /**
     * Price as an int.
     */
    int p;

    /**
     * Constructor:
     * 
     * @param name
     *            Name.
     * @param p
     *            Price value.
     */
    public Price(String name, int p) {
        this.name = name;
        this.p = p;
    }

    /**
     * Prints this PRICE as a String.
     * 
     * @return PRICE name.
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
     * Constructs an instance of PRICE from a line of String from the file.
     * 
     * @param s
     *            String passed in.
     * @return A new instance of PRICE.
     */
    public static Price makePriceFromString(String s) {
        Price temp = new Price("", 0);
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
        String price = s.substring(i);
        temp.p = Integer.parseInt(price);
        return temp;
    }
}
