import tester.*;

/**
 * Testing for the Theater class:
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class TheaterTest {

    /**
     * Blank instance of THEATER:
     */
    Theater blank = new Theater("", 0);

    /**
     * Instance of THEATER:
     */
    Theater a = new Theater("A", 300);

    /**
     * String used for string-to-theater conversion test:
     */
    String strA = "A:300";

    /**
     * Instance of THEATER:
     */
    Theater b = new Theater("B", 90);

    /**
     * String used for string-to-theater conversion test:
     */
    String strB = "B:90";

    /**
     * Instance of THEATER:
     */
    Theater c = new Theater("C", 500);

    /**
     * String used for string-to-theater conversion test:
     */
    String strC = "C:500";

    /**
     * Test all methods for THEATER:
     * 
     * @param t
     *            Tester
     */
    void testTheaterMethods(Tester t) {
        t.checkExpect(Theater.makeTheaterFromString(strA), a);
        t.checkExpect(Theater.makeTheaterFromString(strB), b);
        t.checkExpect(Theater.makeTheaterFromString(strC), c);
        t.checkExpect(
                Theater.makeTheaterFromString(strA).toString().equals("A"),
                true);
        t.checkExpect(Theater.makeTheaterFromString(strA).hashCode() == 666,
                false);
    }

}
