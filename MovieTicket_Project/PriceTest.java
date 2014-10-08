import tester.*;

/**
 * Testing for the PRICE class.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class PriceTest {

    /**
     * Blank instance of PRICE:
     */
    Price blank = new Price("", 0);

    /**
     * Instance of PRICE:
     */
    Price adult = new Price("Adult", 10);

    /**
     * Instance of PRICE:
     */
    Price child = new Price("Child", 7);

    /**
     * Instance of PRICE:
     */
    Price senior = new Price("Senior", 8);

    /**
     * String used for string-to-price conversion testing:
     */
    String s1 = "Adult:10";

    /**
     * String used for string-to-price conversion testing:
     */
    String s2 = "Child:7";

    /**
     * String used for string-to-price conversion testing:
     */
    String s3 = "Senior:8";

    /**
     * Tests for PRICE-s methods.
     * 
     * @param t
     *            Tester
     */
    void testPriceMethods(Tester t) {
        t.checkExpect(Price.makePriceFromString(s1), adult);
        t.checkExpect(Price.makePriceFromString(s2), child);
        t.checkExpect(Price.makePriceFromString(s3), senior);
        t.checkExpect(Price.makePriceFromString(s1).toString().equals("Adult"),
                true);
        t.checkExpect(Price.makePriceFromString(s1).hashCode() == 666, false);
    }
}
