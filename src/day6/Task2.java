package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(new File("res/day6/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        int markerIdx = 0;
        char[] marker = new char[14];
        while(sc.hasNext()){
            markerIdx++;
            char ch = sc.findInLine(".").charAt(0);
            System.arraycopy(marker, 1, marker, 0, marker.length - 1);
            marker[13] =  ch;
            if (isSignalMarker(marker) && markerIdx >= 14){
                break;
            }
        }
        System.out.println(markerIdx);
    }


    private static boolean isSignalMarker(char[] marker){
        Set<Character> h = new HashSet<>();
        for (char ch:marker){
            h.add(ch);
        }
        return h.size()== 14;
    }
}
