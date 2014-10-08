import java.util.ArrayList;

/**
 * Class to represent a cinema complex.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class Complex {

    /**
     * FIELDS:
     * 
     * Movies now playing.
     */
    ArrayList<Movie> nowPlaying;

    /**
     * Theaters at this complex.
     */
    ArrayList<Theater> theaters;

    /**
     * Showtimes at this complex.
     */
    ArrayList<Showtime> showtimes;

    /**
     * Range of prices available.
     */
    ArrayList<Price> prices;

    /**
     * Constructor.
     * 
     * @param nowPlaying
     *            Movies
     * @param theaters
     *            Theaters
     * @param showtimes
     *            Showtimes
     * @param prices
     *            Prices
     */
    public Complex(ArrayList<Movie> nowPlaying, ArrayList<Theater> theaters,
            ArrayList<Showtime> showtimes, ArrayList<Price> prices) {
        this.nowPlaying = nowPlaying;
        this.theaters = theaters;
        this.showtimes = showtimes;
        this.prices = prices;
    }

    /**
     * Methods:
     * 
     * 
     * Add a movie to nowPlaying.
     * 
     * @param m
     *            Movie passed in.
     */

    void addMovie(Movie m) {
        this.nowPlaying.add(m);
    }

    /**
     * Getter
     * 
     * @return Movies now playing.
     */
    ArrayList<Movie> getNowPlaying() {
        return this.nowPlaying;
    }

    /**
     * Add a theater to theaters.
     * 
     * @param t
     *            Theater passed in.
     */
    void addTheater(Theater t) {
        this.theaters.add(t);
    }

    /**
     * Getter
     * 
     * @return The theaters available.
     */
    ArrayList<Theater> getTheaters() {
        return this.theaters;
    }

    /**
     * Add a Showtime to showtimes
     * 
     * @param s
     *            Showtime passed in.
     */
    void addShowtime(Showtime s) {
        this.showtimes.add(s);
    }

    /**
     * Getter
     * 
     * @return The available showtimes.
     */
    ArrayList<Showtime> getShowtimes() {
        return this.showtimes;
    }

    /**
     * Add a Price to prices.
     * 
     * @param p
     *            Price passed in.
     */
    void addPrice(Price p) {
        this.prices.add(p);
    }

    /**
     * Getter
     * 
     * @return Available range of prices.
     */
    ArrayList<Price> getPrices() {
        return this.prices;
    }

    /**
     * Check for conflicts within showtimes.
     * 
     * @param shtm
     *            Showtime passed in for checking.
     * 
     * @return T if conflict arises, otherwise F.
     */
    boolean conflictCheck(Showtime shtm) {
        boolean temp = false;
        for (Showtime s : this.showtimes) {
            if (s.startTime >= s.startTime 
                    && s.startTime <= (shtm.startTime + 
                            this.nowPlaying.get(
                                    shtm.movieNum - 1).lengthMIN)) {
                temp = false;
                break;
            }
            else {
                temp = true;
            }
        }
        return temp;
    }

    /**
     * Takes in movie# theater# and starting-time and finds that Showtime.
     * 
     * @param movieN
     *            movie#
     * @param theaterN
     *            theater#
     * @param startT
     *            starting-time
     * @return The corresponding showtime.
     */
    Showtime getShowtime(int movieN, int theaterN, int startT) {
        Showtime temp = new Showtime(0, 0, 0, 0);
        for (Showtime shtm : this.showtimes) {
            if (shtm.movieNum == movieN && shtm.theaterNum == theaterN
                    && shtm.startTime == startT) {
                temp = shtm;
                break;
            }
        }
        return temp;
    }
}
