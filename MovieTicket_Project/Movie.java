/**
 * Class to represent a one movie at the cinema.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class Movie {

    /**
     * FIELDS:
     * 
     * Title of film.
     */
    String title;

    /**
     * Movie # for data storage/access
     */
    int number;

    /**
     * Length of movie in MINs.
     */
    int lengthMIN;

    /**
     * Length of movie in HRs.
     */
    double lengthHR;

    /**
     * Constructor:
     * 
     * @param title
     *            Title
     * @param number
     *            Movie number
     * @param lengthMIN
     *            Length in minutes
     * @param lengthHR
     *            Length in hours
     */
    public Movie(String title, int number, int lengthMIN, double lengthHR) {
        this.title = title;
        this.number = number;
        this.lengthMIN = lengthMIN;
        this.lengthHR = lengthHR;
    }

    /**
     * Prints this MOVIE as a String
     * 
     * @return The movie title.
     */
    public String toString() {
        return this.title;
    }

    /**
     * HashCode
     * 
     * @return The hash#
     */
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * Takes in a line from the file and makes a MOVIE from the data.
     * 
     * @param s
     *            The String passed in from file.
     * @return A MOVIE instance.
     */
    public static Movie makeMovieFromString(String s) {
        Movie temp = new Movie("", 0, 0, 0);
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ':') {
                temp.title += s.charAt(i);
                i++;
            }
            else {
                i++;
                break;
            }
        }
        String length = s.substring(i);
        temp.lengthMIN = Integer.parseInt(length);
        double mins = ((double) (temp.lengthMIN % 60)) / 100;
        int hrs = temp.lengthMIN / 60;
        temp.lengthHR = hrs + mins;
        return temp;
    }

}
