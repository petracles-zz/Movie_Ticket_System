/**
 * Class to represent an instance of a showtime at the theater complex.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class Showtime {

    /**
     * FIELDS:
     * 
     * Movie #
     */
    int movieNum;

    /**
     * Theater #
     */
    int theaterNum;

    /**
     * Movie start time.
     */
    int startTime;

    /**
     * Number of viewers so far.
     */
    int numViewers;

    /**
     * Number of adult viewers.
     */
    int adultCount;

    /**
     * Number of child viewers.
     */
    int childCount;

    /**
     * Number of senior viewers.
     */
    int seniorCount;

    /**
     * Determines if a matinee or not.
     */
    boolean isMat;

    /**
     * Constructor:
     * 
     * @param movieNum
     *            movie#
     * @param theaterNum
     *            theater#
     * @param startTime
     *            starting-time
     * @param numViewers
     *            number of viewers
     */
    public Showtime(int movieNum, int theaterNum, int startTime,
            int numViewers) {
        this.movieNum = movieNum;
        this.theaterNum = theaterNum;
        this.startTime = startTime;
        this.numViewers = numViewers;
        this.adultCount = 0;
        this.childCount = 0;
        this.seniorCount = 0;
        this.isMat = startTime <= 840;
    }

    /**
     * Prints this SHOWTIME as a String.
     * 
     * @return The Showtime data as a String.
     */
    public String toString() {
        return "Movie Number " + movieNum + " in Theater Number " + theaterNum;
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
     * Constructs a new instance of SHOWTIME from a String line from the file.
     * 
     * @param s
     *            String passed in.
     * @return An instance of SHOWTIME
     */
    public static Showtime makeShowtimeFromString(String s) {
        Showtime temp = new Showtime(0, 0, 0, 0);
        temp.movieNum = Character.getNumericValue(s.charAt(0));
        temp.theaterNum = Character.getNumericValue(s.charAt(2));
        String startT = s.substring(4);
        temp.startTime = Integer.parseInt(startT);
        temp = new Showtime(temp.movieNum, temp.theaterNum, temp.startTime, 0);
        return temp;
    }
}
