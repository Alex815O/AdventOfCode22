package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        File file = new File("res/day3/input.txt");
        try {
            Scanner sc = new Scanner(file);

            List<Character> duplicate = new LinkedList<>();
            long sum = 0;
            while (sc.hasNextLine()){
                String backpack = sc.nextLine();
                List<String> items = Arrays.asList(backpack.split(""));
                List<String> left = items.subList(0, (int) items.size()/2);
                List<String> right = items.subList( (int) items.size()/2, items.size());

                boolean finish = false;
                for (String chL:left){
                    for(String chR:right){
                        if (chL.equals(chR)){
                            duplicate.add(chL.charAt(0));
                            finish = true;
                            break;
                        }
                    }
                    if (finish) break;
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
