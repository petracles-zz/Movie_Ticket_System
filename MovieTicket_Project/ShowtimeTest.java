import tester.*;

/**
 * Testing for SHOWTIME-s methods.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class ShowtimeTest {

    /**
     * Blank instance of SHOWTIME:
     */
    Showtime blank = new Showtime(0, 0, 0, 0);

    /**
     * Instance of SHOWTIME:
     */
    Showtime a1960 = new Showtime(1, 1, 960, 0);

    /**
     * Instance of SHOWTIME:
     */
    Showtime a11080 = new Showtime(1, 1, 1080, 0);

    /**
     * Instance of SHOWTIME:
     */
    Showtime a11200 = new Showtime(1, 1, 1200, 0);

    /**
     * Instance of SHOWTIME:
     */
    Showtime a31020 = new Showtime(1, 3, 1020, 0);

    /**
     * Instance of SHOWTIME:
     */
    Showtime a31140 = new Showtime(1, 3, 1140, 0);

    /**
     * Instance of SHOWTIME:
     */
    Showtime b2990 = new Showtime(2, 2, 990, 0);

    /**
     * Instance of SHOWTIME:
     */
    Showtime b21210 = new Showtime(2, 2, 1210, 0);

    /**
     * String used for string-to-showtime conversion test:
     */
    String s1 = "1,1,960";

    /**
     * String used for string-to-showtime conversion test:
     */
    String s2 = "1,1,1080";

    /**
     * String used for string-to-showtime conversion test:
     */
    String s3 = "1,1,1200";

    /**
     * String used for string-to-showtime conversion test:
     */
    String s4 = "1,3,1020";

    /**
     * String used for string-to-showtime conversion test:
     */
    String s5 = "1,3,1140";

    /**
     * String used for string-to-showtime conversion test:
     */
    String s6 = "2,2,990";

    /**
     * String used for string-to-showtime conversion test:
     */
    String s7 = "2,2,1210";

    /**
     * Tests for SHOWTIME-s methods.
     * 
     * @param t
     *            Tester
     */
    void testShowtimeMethods(Tester t) {
        t.checkExpect(Showtime.makeShowtimeFromString(s1), a1960);
        t.checkExpect(Showtime.makeShowtimeFromString(s2), a11080);
        t.checkExpect(Showtime.makeShowtimeFromString(s3), a11200);
        t.checkExpect(Showtime.makeShowtimeFromString(s4), a31020);
        t.checkExpect(Showtime.makeShowtimeFromString(s5), a31140);
        t.checkExpect(Showtime.makeShowtimeFromString(s6), b2990);
        t.checkExpect(Showtime.makeShowtimeFromString(s7), b21210);
        t.checkExpect(
                Showtime.makeShowtimeFromString(s1).toString()
                        .equals("Movie Number 1 in Theater Number 1"), true);
        t.checkExpect(Showtime.makeShowtimeFromString(s1).hashCode() == 666,
                false);
        t.checkExpect(a1960.toString().equals(
                "Movie Number 1 in Theater Number 1"), true);
        t.checkExpect(a1960.hashCode() == 666, false);
    }
}
