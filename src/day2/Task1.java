package day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {

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

            long roundPoints = signs[1].charAt(0)-'W';
            long matchPoints = matchPoints(signs[0].charAt(0), signs[1].charAt(0));
            totalPoints += roundPoints + matchPoints;
        }
        System.out.println("Total points: " + totalPoints);
    }

    private static int matchPoints(char a, char b){
        if (a - 'A' == b - 'X'){
            return 3;
        }
        if ((a == 'A' && b == 'Z')
                || (a == 'B' && b == 'X')
                || (a == 'C' && b == 'Y')){
            return 0;
        }
        return 6;
    }

}
