import java.io.IOException;
import java.util.Scanner;

/**
 * Testing for the TicketSales program.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class TicketSalesTest {

    /**
     * Input reader.
     */
    static Scanner keyboard = new Scanner(System.in);

    /**
     * Instance of TicketSales.
     */
    static TicketSales prog = new TicketSales();

    /**
     * MAIN:
     * 
     * @param argv
     *            String arguments passed in (for console).
     * @throws IOException
     *             Thrown if failed.
     */
    public static void main(String[] argv) throws IOException {
        TicketSalesTest test = new TicketSalesTest();
        test.initPrompt();
        test.ordersPrompt();

        //prog.initCinema("cinema.txt");
        //prog.processOrders("orders.txt");
        
        String sales = prog.reportSales();
        String manager = prog.managerReport();
        String log = prog.logReport();

        System.out.println("Sales Report:\n" + sales);
        System.out.println("Manager Report:\n" + manager);
        System.out.println("Log Report:\n" + log);
    }

    /**
     * Prompts the user for data initialization.
     */
    void initPrompt() {
        // Initialize:
        System.out.println("Welcome!! Would you like to initialize through"
                + " console or through a file? [ c || f || terminate ]");
        String initStyle = keyboard.nextLine();
        if (initStyle.equals("c")) {
            System.out.println("You chose to initialize by console.");
            System.out.println("Enter the corresponding # for what you wish to"
                    + " initialize:");
            System.out.println("1 - Movie\n"
                    + "2 - Theater\n"
                    + "3 - Show\n"
                    + "4 - Price\n"
                    + "5 - END");
            int choice = keyboard.nextInt();
            boolean finished = false;
            @SuppressWarnings("unused")
            String janitor;
            while (!finished) {
                switch (choice) {
                    case 1:
                        System.out.println("Enter as follows: "
                                + "TITLE:LENGTH-IN-MIN");
                        janitor = keyboard.nextLine();
                        String strM = keyboard.nextLine();
                        Movie movie = Movie.makeMovieFromString(strM);
                        TicketSales.cplx.nowPlaying.add(movie);
                        break;

                    case 2:
                        System.out.println("Enter as follows: "
                                + "THEATER-NAME:CAPACITY");
                        janitor = keyboard.nextLine();
                        String strT = keyboard.nextLine();
                        Theater theater = Theater.makeTheaterFromString(strT);
                        TicketSales.cplx.theaters.add(theater);
                        break;

                    case 3:
                        System.out.println("Enter as follows: "
                                + "MOVIE-NUM,THEATER-NUM,START-TIME");
                        janitor = keyboard.nextLine();
                        String strS = keyboard.nextLine();
                        Showtime showtime = Showtime
                                .makeShowtimeFromString(strS);
                        TicketSales.cplx.showtimes.add(showtime);
                        break;

                    case 4:
                        System.out.println("Enter as follows: "
                                + "PRICE-NAME:COST");
                        janitor = keyboard.nextLine();
                        String strP = keyboard.nextLine();
                        Price price = Price.makePriceFromString(strP);
                        TicketSales.cplx.prices.add(price);
                        break;

                    case 5:
                        System.out.println("Console Initialization "
                                + "Complete!!");
                        janitor = keyboard.nextLine();
                        finished = true;
                        break;

                    default:
                        System.out.println("Invalid!! - Enter an Integer "
                                + "(1-5)");
                        janitor = keyboard.nextLine();
                        janitor = keyboard.nextLine();
                        break;
                }
            }
        }
        else if (initStyle.equals("f")) {
            System.out.println("You chose to initialize by file.");
            System.out.print("Enter file name: ");
            String fiNm = keyboard.nextLine();
            System.out.println("Initializing...");
            prog.initCinema(fiNm);
        }
        else if (initStyle.equals("terminate")) {
            System.out.println("Program ended by user...");
        }
        else {
            System.out.println("Wrong input! Restarting initialization...");
            this.initPrompt();
        }
    }

    /**
     * Prompts the user for the orders.
     */
    void ordersPrompt() {
        System.out.println("Process Orders by console or file? "
                + "[ c || f || terminate ]");
        String orderStyle = keyboard.nextLine();
        if (orderStyle.equals("c")) {
            System.out.println("You chose to order by console.");
            boolean finished = false;
            while (!finished) {                
                System.out.println("Enter order as follows: "
                        + "MOVIE-NUM,THEATER-NUM,START-TIME,ADULT-NUM,"
                        + "CHILDREN-NUM,SENIOR-NUM");
                System.out.println("or enter [ report || terminate ]");
                String order = keyboard.nextLine();
                if (order.equals("terminate")) {
                    finished = true;
                    continue;
                }
                else {
                    String[] str = order.split(",");
                    int movie = Integer.parseInt(str[0]);
                    int theater = Integer.parseInt(str[1]);
                    int start = Integer.parseInt(str[2]);
                    int adults = Integer.parseInt(str[3]);
                    int kids = Integer.parseInt(str[4]);
                    int seniors = Integer.parseInt(str[5]);
                    int party = adults + kids + seniors;
                    Showtime s = TicketSales.cplx.getShowtime(movie, theater, 
                            start);
                    
                    if (TicketSales.cplx.theaters.get(theater).capacity >=
                            (s.numViewers + party)) {
                        s.adultCount += adults;
                        s.childCount += kids;
                        s.seniorCount += seniors;                    
                        s.numViewers += party;
                        int adultCost = TicketSales.cplx.prices.get(0).p;
                        int childCost = TicketSales.cplx.prices.get(1).p;
                        int seniorCost = TicketSales.cplx.prices.get(2).p;
                        int price = (adults * adultCost)
                                + (kids * childCost)
                                + (seniors * seniorCost);
                        System.out.println(price);
                    }
                    else {
                        System.out.println(
                                "Not enough room left in the theater!");
                    }
                }
                
                System.out.println("Finished orders? [ y || n ]");
                String rep = keyboard.nextLine();
                if (rep.equals("y")) {
                    finished = true;
                }
            }
        }
        else if (orderStyle.equals("f")) {
            System.out.println("You chose to process orders by file.");
            System.out.print("Enter file name: ");
            String fiNm = keyboard.nextLine();
            System.out.println("Procesing Orders...");
            prog.processOrders(fiNm);
        }
        else if (orderStyle.equals("terminate")) {
            System.out.println("Program ended by user...");
        }
        else {
            System.out.println("Wrong input! Restarting order processing...");
            this.ordersPrompt();
        }
    }
}
