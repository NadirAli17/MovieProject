import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class theatreSeats {
    String [][] setArray;
    int rows;
    int cols;

    public theatreSeats(int rows, int cols){
        this.setArray = build2DArray1();
        this.rows = rows;
        this.cols = cols;
    }
    public String[][] build2DArray1() {


        char letter = 'B';
        char number = '1';

        String[][] array2D = new String[this.rows][this.cols];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                Random random = new Random();
                int randomNumber = random.nextInt(5);
                if (randomNumber == 2) {
                    array2D[i][j] = "X";
                } else {
                    array2D[i][j] = "0";
                }

                if (i == 0 && j == 0) {
                    array2D[i][j] = " ";

                }
                if (i == 0 && j != 0) {
                    String myString = "" + number;
                    array2D[i][j] = myString;
                    number++;
                }
                if (j == 0 && i != 0) {
                    String myString = "" + letter;
                    array2D[i][j] = myString;
                    letter++;
                }
            }
        }

        return array2D;
    }
    public void buildPrintArray() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.build2DArray1()[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void buildPrintArrayF(String[][] arr) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

public static void bookASpot(String[][] setArrayFinal, int numOfTickets, theatreSeats name) {
    Scanner scanner = new Scanner(System.in);
    HashMap<Character, Integer> valueSet1 = new HashMap<Character, Integer>();
    valueSet1.put('B', 1);
    valueSet1.put('C', 2);
    valueSet1.put('D', 3);
    valueSet1.put('E', 4);
    valueSet1.put('F', 5);
    valueSet1.put('G', 6);

    int i = 0;
    while (i < numOfTickets) {
        System.out.print("Which seat? " + i);
        String seat = scanner.next();
        char charecter = '0';
        charecter = seat.charAt(1);
        if(seat.length() < 2 || seat.length() > 1 || !Character.isDigit(charecter) ){
            System.out.println("In correct input");
            return;
        }

        char firstChar = seat.charAt(0);
        char secondChar = seat.charAt(1);

        int firstVal = valueSet1.getOrDefault(firstChar, -1); // Use getOrDefault to handle invalid characters
        int secondVal = secondChar - '0';

        if (firstVal < 0 || firstVal >= setArrayFinal.length || secondVal < 0 || secondVal >= setArrayFinal[0].length) {
            System.out.println("Invalid seat selection. Please try again.");
        } else if (setArrayFinal[firstVal][secondVal].equals("X")) {
            System.out.println("Pick another seat");
            name.buildPrintArrayF(setArrayFinal);
        } else {
            System.out.println("Ticket Booked!");
            setArrayFinal[firstVal][secondVal] = "S";
            name.buildPrintArrayF(setArrayFinal);
            i++;
        }
    }
}

}


