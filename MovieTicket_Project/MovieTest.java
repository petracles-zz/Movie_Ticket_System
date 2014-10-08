import tester.*;

/**
 * Testing for the MOVIE class.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class MovieTest {

    /**
     * Blank instance of MOVIE:
     */
    Movie blank = new Movie("", 0, 0, 0);

    /**
     * Instance of a MOVIE:
     */
    Movie harryPotter = new Movie("Harry Potter", 0, 102, 1.42);

    /**
     * Instance of a MOVIE:
     */
    Movie greatExpectations = new Movie("Great Expectations", 1, 115, 1.55);

    /**
     * String used for string-to-movie conversion test:
     */
    String str = "Harry Potter:102";

    /**
     * Test all methods for MOVIE:
     * 
     * @param t
     *            Tester
     */
    void testMovieMethods(Tester t) {
        t.checkExpect(Movie.makeMovieFromString(str).equals("pizza"), false);
        t.checkExpect(
                Movie.makeMovieFromString(str), harryPotter);
        t.checkExpect(
                Movie.makeMovieFromString(str).toString()
                        .equals(harryPotter.title), true);
        t.checkExpect(Movie.makeMovieFromString(str).hashCode() == 666, false);
    }
}
