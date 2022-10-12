//Jet Brains Academy Project

package tictactoe;
import java.util.*;

public class Main {
    public static boolean win_state(String[][] temp){
        boolean ch = false;
        if((temp[0][0].equals("X") && temp[0][1].equals("X") && temp[0][2].equals("X")) ||
                (temp[1][0].equals("X") && temp[1][1].equals("X") && temp[1][2].equals("X")) ||
                (temp[2][0].equals("X") && temp[2][1].equals("X") && temp[2][2].equals("X"))) {
                    ch = true;
        }else if((temp[0][0].equals("O") && temp[0][1].equals("O") && temp[0][2].equals("O")) ||
                (temp[1][0].equals("O") && temp[1][1].equals("O") && temp[1][2].equals("O")) ||
                (temp[2][0].equals("O") && temp[2][1].equals("O") && temp[2][2].equals("O"))) {
                    ch = true;
        } else if ((temp[0][0].equals("X") && temp[1][0].equals("X") && temp[2][0].equals("X")) ||
                (temp[0][1].equals("X") && temp[1][1].equals("X") && temp[2][1].equals("X")) ||
                (temp[0][2].equals("X") && temp[1][2].equals("X") && temp[2][2].equals("X"))) {
                    ch = true;
        }else if ((temp[0][0].equals("O") && temp[1][0].equals("O") && temp[2][0].equals("O")) ||
                (temp[0][1].equals("O") && temp[1][1].equals("O") && temp[2][1].equals("O")) ||
                (temp[0][2].equals("O") && temp[1][2].equals("O") && temp[2][2].equals("O"))) {
                    ch = true;
        } else if ((temp[0][0].equals("X") && temp[1][1].equals("X") && temp[2][2].equals("X"))||
                (temp[0][2].equals("X") && temp[1][1].equals("X") && temp[2][0].equals("X"))) {
                    ch = true;
        }   else if ((temp[0][0].equals("O") && temp[1][1].equals("O") && temp[2][2].equals("O"))||
                (temp[0][2].equals("O") && temp[1][1].equals("O") && temp[2][0].equals("O"))) {
                    ch = true;
        }
        return ch;
    }

    //Print Matrix
    public static void printField(String[][] str){
        for(int i=0; i<9; i++){
            System.out.print("-");
        }
        System.out.println();

        for (int i=0; i<3; i++){
            System.out.print("| ");
            for (int j=0; j<3; j++){
                System.out.print(str[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i=0; i<9; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        String[][] str = new String[3][3];

        //Generate Matrix
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                str[i][j] = " ";
            }
        }
        printField(str);

        int a, b;
        int chance = 1;
        while(chance <= 9){
            try
            {
                a = scanner.nextInt();
                b = scanner.nextInt();
                if ((a > 0 && a <= 3) && (b > 0 && b <= 3))
                {
                    if(str[a - 1][b - 1].equals("X") || str[a - 1][b - 1].equals("O")) {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                    else if (chance % 2 != 0) {
                        str[a - 1][b - 1] = "X";
                        chance++;
                    }
                    else {
                        str[a - 1][b - 1] = "O";
                        chance++;
                    }

                    printField(str);
                    if (win_state(str)) {
                        if (chance % 2 == 0) {
                            System.out.println("X wins");
                            break;
                        } else {
                            System.out.println("O wins");
                            break;
                        }
                    } else if (chance == 9) {
                        System.out.println("Draw");
                    }
                }
                else if ((a < 0 || a > 3) || (b < 0 || b > 3)) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                }
            }
        }

    }
