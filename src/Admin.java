import java.util.Objects;
import java.util.Scanner;

public class Admin {
    theatreSeats theatreSeats;
    String[][] arr;
    public Admin(theatreSeats seats, String[][] arr1){
        this.arr = arr1;
        this.theatreSeats = seats;
    }
    public String[][] deleteArray(String[][] del){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                del[i][j] = "!";
            }
        }
        return del;
    }

    public void adminCheck(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter case sensetive password");
        String pass = scanner.nextLine();

        if (Objects.equals(pass, "admin")){
            this.theatreSeats.buildPrintArrayF(arr);
            System.out.println("What changes would you like to make? 1 to remove movie, 2 to remove seat(s)");
            int choice = scanner.nextInt();
            if (choice == 1){
                String[][] finalDelete = deleteArray(arr);
                this.theatreSeats.buildPrintArrayF(finalDelete);
            }
            else if(choice == 2){
                System.out.print("Which seats would you like to remove");
            }
        }
    }
}

