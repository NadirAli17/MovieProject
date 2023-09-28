import java.util.Scanner;
import java.util.HashMap;
public class Main {

    public static void screen(){
        System.out.println("-------------");
        System.out.println("---SCREEN----");
        System.out.println("Please check that the seats you want are available!");
        System.out.println("If admin, type 0 for password then enter password.");
    }
    public static int getTicketCount(Admin adminC){
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many tickets will be purchased? if admin, type 0");
        int tickets = scanner.nextInt();
        if (tickets == 0){
            adminC.adminCheck();
            return 0;
        }
        return tickets;
    }
    public static void mainMovieInterface(int rows, int cols, String[][] arrayF, Admin finalAdmin, theatreSeats name, int numberOfTickets) {
        Scanner scanner = new Scanner(System.in);

        if (numberOfTickets == 0){
            finalAdmin.adminCheck();
        }

        if (numberOfTickets < 0) {
            System.out.println("Thank you have a great day! ");
            return;
        }

        System.out.print("Enter the number of adult tickets: ");
        int adults = scanner.nextInt();

        System.out.print("Enter the number of children tickets: ");
        int children = scanner.nextInt();

        System.out.print("Enter the number of people 65+ OR below the age of 5: ");
        int elderlyBabies = scanner.nextInt();

        if (numberOfTickets != (adults + children + elderlyBabies)) {
            System.out.println("Please match ticket count to types of people ");
            return;
        }

        int price = 0;
        price = (adults * 8) + (children * 5) + (elderlyBabies * 0);

        System.out.println("Your price is " + price + ". If that is ok please type YES");
        System.out.println("Which tickets would you like. Type in the following seats, Example B5 C5 D5");
    }

        public static void main (String[]args){
            //guiSetUp finalGui = new guiSetUp(640, 480);
            //finalGui.setUpGui(); GUI NOT FINISHED

            int rows = 7;
            int cols = 7;
            theatreSeats name = new theatreSeats(rows, cols);
            String[][] finalArr = name.build2DArray1();
            Admin finalAdmin = new Admin(name, finalArr);
            screen();
            name.buildPrintArrayF(finalArr);
            System.out.println("");
            int ticketCount = getTicketCount(finalAdmin);

            mainMovieInterface(rows, cols, name.setArray,finalAdmin, name, ticketCount);
            theatreSeats.bookASpot(finalArr, ticketCount, name);
        }
    }
