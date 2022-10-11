package cinema;
import java.util.*;

public class Cinema {

    // Statistics
    public static void statistics(int row, int col, String[][] arr){
        int purchased_ticket = 0;
        int curr_inc = 0;
        int total_seats = row*col;
        for (int i=0; i<= row; i++){
            for(int j=0; j<=col; j++){
                if(Objects.equals(arr[i][j], "B")) {
                    purchased_ticket++;
                    if(i <= row/2 || total_seats < 60)
                        curr_inc  = curr_inc + 10;
                    else
                        curr_inc = curr_inc + 8;
                }
            }
        }
        int total_income = 0;
        if(total_seats < 60 )
            total_income = total_seats*10;
        else{
            total_income = (row - (row/2))*col*8 + (row/2)*col*10;
        }
        System.out.println("\nNumber of purchased tickets: " + purchased_ticket);
        double percentage = ((double) purchased_ticket * 100)/ (double)total_seats;
        System.out.printf("Percentage: %.2f%% \n", percentage);
        System.out.println("Current income: $" + curr_inc);
        System.out.println("Total income: $" + total_income);
    }


    // Buy A Ticket
    public static void buyTicket(int row, int col, String[][] arr) {
        int total_seats = row * col;
        int price = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a row number:");
        int row_no = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat_no = scanner.nextInt();

        if((row_no < 1 || seat_no < 1) || (row_no > row || seat_no > col)) {
            System.out.println("\nWrong input!");
            buyTicket(row, col, arr);
        } else if(Objects.equals(arr[row_no][seat_no], "B")) {
            System.out.println("\nThat ticket has already been purchased!");
            buyTicket(row, col, arr);
        }
        else {
            if(total_seats < 60 || row_no <= row/2) {
                price = 10;
            } else {
                price = 8;
            }
            System.out.println("\nTicket Price: $" + price);
            arr[row_no][seat_no] = "B";
            //System.out.println();
        }
    }


    //Show Cinema Seats
    public static void showTheSeats(int row, int col, String[][] arr){
        System.out.println("\nCinema:");
        for (int i=0; i<= row; i++){
            for (int j=0; j<=col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Enter the number of rows:");
            row = scanner.nextInt();
            System.out.println("Enter the number of seats in each row:");
            col = scanner.nextInt();
        }while (row < 0 || col <= 0);

    //Generate Cinema
        String[][] arr = new String[row+1][col+1];

        for(int i = 0; i <= row; i++)
        {
            for (int j = 0; j <= col; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = " ";
                }
                else if (i == 0 && j > 0) {
                    arr[i][j] = String.valueOf(j);
                }
                else if (j == 0) {
                    arr[i][j] = String.valueOf(i);
                }
                else {
                    arr[i][j] = "S";
                }
            }
        }

        boolean x = true;
        while (x) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 0 -> x = false;
                case 1 -> showTheSeats(row, col, arr);
                case 2 -> buyTicket(row, col, arr);
                case 3 -> statistics(row, col, arr);
            }

        }

    }
}