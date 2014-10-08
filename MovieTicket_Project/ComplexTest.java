import java.util.ArrayList;

import tester.*;

/**
 * Tests for COMPLEX
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class ComplexTest {

    /**
     * Movie instance.
     */
    Movie m = new Movie("", 0, 0, 0);

    /**
     * Theater instance.
     */
    Theater tr = new Theater("", 0);

    /**
     * Showtime instance.
     */
    Showtime s = new Showtime(1, 1, 950, 5);
    
    /**
     * Showtime instance for conflict test.
     */
    Showtime s1 = new Showtime(1, 1, 950, 1);

    /**
     * Price instance.
     */
    Price p = new Price("", 0);

    /**
     * Blank instances in order to build a blank complex.
     * 
     * Movies
     */
    ArrayList<Movie> mov = new ArrayList<Movie>();

    /**
     * Theaters
     */
    ArrayList<Theater> theat = new ArrayList<Theater>();

    /**
     * Showtimes
     */
    ArrayList<Showtime> shtm = new ArrayList<Showtime>();

    /**
     * Prices
     */
    ArrayList<Price> pri = new ArrayList<Price>();

    /**
     * Blank instance of a COMPLEX:
     */
    Complex blank = new Complex(mov, theat, shtm, pri);    
    
    /**
     * Initialization for tests.
     */
    private void init() {
        blank.addMovie(m);
        blank.addTheater(tr);
        blank.addShowtime(s);
        blank.addPrice(p);
    }
    
    /**
     * Tests for COMPLEX-s methods.
     * 
     * @param t
     *            Tester
     */
    void testComplexMethods(Tester t) {
        init();
        t.checkExpect(blank.getNowPlaying().get(0), m);
        t.checkExpect(blank.getTheaters().get(0), tr);
        t.checkExpect(blank.getShowtimes().get(0), s);
        t.checkExpect(blank.getPrices().get(0), p);
        t.checkExpect(blank.conflictCheck(s1), false);
        t.checkExpect(blank.getShowtime(1, 1, 950), s);
    }

}
