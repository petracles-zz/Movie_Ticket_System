import java.util.ArrayList;
import java.io.IOException;

/**
 * Class to maintain all complex data and report building.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class TicketSales {

    /**
     * FIELDS:
     * 
     * Movies now playing.
     */
    static ArrayList<Movie> nowPlaying = new ArrayList<Movie>();

    /**
     * Theaters at the complex.
     */
    static ArrayList<Theater> theaters = new ArrayList<Theater>();

    /**
     * Showtimes at the complex.
     */
    static ArrayList<Showtime> showtimes = new ArrayList<Showtime>();

    /**
     * Price ranges at the complex.
     */
    static ArrayList<Price> prices = new ArrayList<Price>();

    /**
     * Instance of Complex.
     */
    static Complex cplx = new Complex(nowPlaying, theaters, showtimes, prices);

    /**
     * String-s for data reporting:
     * 
     * Sales report.
     */
    String salesR = "";

    /**
     * Manager report.
     */
    String managerR = "";

    /**
     * Log report.
     */
    String logR = "";

    /**
     * Initializes the cinema complex from a file.
     * 
     * @param fileName
     *            File passed in.
     */
    void initCinema(String fileName) {
        try {
            // Make an array of each line in the file:
            FileRead file = new FileRead(fileName);
            ArrayList<String> cinemaFile = file.openFile();

            // Integer to process which type of object to build with string.
            int i = 0;

            for (String line : cinemaFile) {
                if (line.equals("Movies")) {
                    i = 1;
                    continue;
                }
                if (line.equals("Theaters")) {
                    i = 2;
                    continue;
                }
                if (line.equals("Shows")) {
                    i = 3;
                    continue;
                }
                if (line.equals("Prices")) {
                    i = 4;
                    continue;
                }
                if (line.equals("End")) {
                    break;
                }
                build(i, line);
            }
        }
        catch (IOException e) {
            System.out.println("File does not exist!!");
        }
    }

    /**
     * Helper for above - builds the instance of the (correct) object.
     * 
     * @param i
     *            Determines which type of object.
     * @param line
     *            String used to build object.
     */
    private void build(int i, String line) {
        if (i == 1) {
            Movie temp = Movie.makeMovieFromString(line);
            cplx.addMovie(temp);
        }
        else if (i == 2) {
            Theater temp = Theater.makeTheaterFromString(line);
            cplx.addTheater(temp);
        }
        else if (i == 3) {
            Showtime temp = Showtime.makeShowtimeFromString(line);
            // Check for conflict:
            if (!cplx.conflictCheck(temp)) {
                cplx.addShowtime(temp);
            }
            else {
                logR += "Showtime overlap for " + temp.movieNum + "/"
                        + temp.theaterNum + " so it was not added!!" + "\n";
            }
        }
        else if (i == 4) {
            Price temp = Price.makePriceFromString(line);
            cplx.addPrice(temp);
        }
    }

    /**
     * Processes orders given to the cinema in the form a file.
     * 
     * @param fileName
     *            File passed in.
     */
    void processOrders(String fileName) {
        try {
            // Make an array of each line in the file:
            FileRead file = new FileRead(fileName);
            ArrayList<String> ordersFile = file.openFile();
            int reportCount = 1;

            for (String line : ordersFile) {
                if (line.equals("report")) {
                    // Add report number:
                    managerR += "Report " + reportCount + "\n";
                    for (Showtime shtm : cplx.showtimes) {
                        // Add movie title:
                        managerR += cplx.nowPlaying.get(
                                shtm.movieNum - 1).title + ",";
                        // Add theater name:
                        managerR += cplx.theaters.get(
                                shtm.theaterNum - 1).name + ",";
                        // Add start time:
                        managerR += shtm.startTime + ",";
                        // Add total seats in theater:
                        managerR += cplx.theaters.get(
                                shtm.theaterNum - 1).capacity
                                + ",";
                        // Add sales and end with \n:
                        managerR += shtm.adultCount + "," + shtm.childCount 
                                + "," + shtm.seniorCount + "\n";
                    }
                    reportCount++;
                }
                else {
                    String[] data = line.split(",");
                    int movieNum = Integer.parseInt(data[0]);
                    int theaterNum = Integer.parseInt(data[1]);
                    int startTime = Integer.parseInt(data[2]);
                    int adultNum = Integer.parseInt(data[3]);
                    int childNum = Integer.parseInt(data[4]);
                    int seniorNum = Integer.parseInt(data[5]);
                    int price = 0;

                    // Check if too many viewers in the party:
                    int partySize = adultNum + childNum + seniorNum;
                    Showtime s = cplx.getShowtime(movieNum, theaterNum,
                            startTime);
                    
                    if (cplx.theaters.get(theaterNum - 1).capacity <
                            s.numViewers + partySize) {
                        salesR += line + "," + price + "\n";
                        logR += "Showtime " + s.movieNum + "/" + s.theaterNum
                                + "has no room for " + partySize + " people!!"
                                + "\n";
                    }
                    else {
                        s.adultCount += adultNum;
                        s.childCount += childNum;
                        s.seniorCount += seniorNum;
                        s.numViewers += partySize;
                        price = (cplx.prices.get(0).p * adultNum)
                                + (cplx.prices.get(1).p * childNum)
                                + (cplx.prices.get(2).p * seniorNum);
                        salesR += line + "," + price + "\n";
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error has occured!!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * Reports the sales so far.
     * 
     * @return Sales data as a String.
     */
    String reportSales() {
        return salesR;
    }

    /**
     * Reports complex data out to manager.
     * 
     * @return Complex data as a String.
     */
    String managerReport() {
        return managerR;
    }

    /**
     * Reports the processing log to the user.
     * 
     * @return The log as a String.
     */
    String logReport() {
        return logR;
    }
}
