package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(new File("res/day7/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }


        Directory current = new Directory("/", null);
        while (sc.hasNextLine()){
            String command = sc.nextLine();

            if (command.contains("cd")){
                try {
                    current = current.changeDirectory(command.split(" ")[3]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.err.println("No Directory");
                    return;
                }
                if (current == null){
                    System.err.println();
                    return;
                }
            }

        }
    }
}
