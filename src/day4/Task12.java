package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {
        File file = new File("res/day4/input1.txt");

        Scanner sc;
        try{
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int anzContaining = 0;
        int anzOverlaping = 0;
        while(sc.hasNextLine()){
            String []rangeStr = sc.nextLine().split(",");
            String []bordersFst = rangeStr[0].split("-");
            String []bordersSnd = rangeStr[1].split("-");

            Range range1 = new Range(Integer.parseInt(bordersFst[0]), Integer.parseInt(bordersFst[1]));
            Range range2 = new Range(Integer.parseInt(bordersSnd[0]), Integer.parseInt(bordersSnd[1]));

            if (range1.fullyContains(range2) || range2.fullyContains(range1)){
                anzContaining++;
            }
            if (range1.overlap(range2)){
                anzOverlaping++;
                System.out.println(range1 +" --> " + range2);
            }
        }
        System.out.println("Fully contain: " + anzContaining);
        System.out.println("Overlap:" + anzOverlaping);
    }

}
