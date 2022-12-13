package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        File file = new File("res/day3/input.txt");
        try {
            Scanner sc = new Scanner(file);

            List<Character> duplicate = new LinkedList<>();
            int idxG = 0;
            ArrayList<String> []group = new ArrayList[3];

            long sum = 0;
            while (sc.hasNextLine()){
                group[idxG] = new ArrayList<String>();
                Collections.addAll(group[idxG++], sc.nextLine().split(""));

                if (idxG <= 2){
                    continue;
                }
                idxG = 0;


                for (String ch:group[0]){
                    if (group[1].contains(ch) && group[2].contains(ch)){
                        duplicate.add(ch.charAt(0));
                        break;
                    }
                }


            }
            for (Character c:duplicate){
                if (c >= 'a'){
                    System.out.println("klein:" + ((c - 'a') + 1) + " -- " + c);
                    sum += ((c - 'a') + 1);
                }else{
                    System.out.println("groß: " + ((c - 'A') + 27 )+ " -- " + c);
                    sum += ((c - 'A') + 27 );
                }
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
