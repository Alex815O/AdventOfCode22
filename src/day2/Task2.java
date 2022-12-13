package day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        File input = new File("res/day2/input.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot read from file: " +e.getMessage());
            return;
        }

        long totalPoints = 0;
        while(sc.hasNextLine()){
            String[] signs = sc.nextLine().split(" ");
            char a = signs[0].charAt(0);
            char mySign;
            switch (signs[1].charAt(0)){
                case 'X':
                    mySign = (char) (((a - 'A' + 2) % 3) + ('A'));
                    break;
                case 'Y':
                    mySign = a;
                    break;
                default:
                    mySign = (char) ((a - 'A' + 1) %3 + 'A');

                    break;
            }
            long matchPoints = calcMatchPoints(a, mySign);
            System.out.println(a +"  "+mySign + "   " + matchPoints);
            totalPoints += matchPoints;
        }
        System.out.println("Total points: " + totalPoints);
    }

    private static long calcMatchPoints(char a, char b){
        return (b-'A'+1) + matchPoints(a, b);
    }
    private static int matchPoints(char a, char b){
        if (a == b){
            return 3;
        }
        if ((a == 'A' && b == 'C')
                || (a == 'B' && b == 'A')
                || (a == 'C' && b == 'B')){
            return 0;
        }
        return 6;
    }

}
