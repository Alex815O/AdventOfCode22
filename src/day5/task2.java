package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        File file = new File("res/day5/input1.txt");
        Scanner sc;
        try{
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
//        // read initial stack
//        String value = "";
//        int idx = 0;
//        List<CrateStack> stacks = new ArrayList<>();
//        String pattern = "(\\s\\s\\s|\n|\\[[A-Z]\\]|1)";
//        boolean finish = false;
//        while (true){
//            value = sc.next(pattern);
//            System.out.println(value);
//            switch (value) {
//                case "   ":
//                    System.out.println("leer");
//                    idx++;
//                    break;
//                case "\n":
//                    System.out.println("\n");
//                    idx = 0;
//                    break;
//                case "1":
//                    finish = true;
//                    break;
//                default:
//                    if (stacks.size() <= idx){
//                        stacks.add(new CrateStack(idx+""));
//                    }
//                    stacks.get(idx).push(value.charAt(1));
//                    idx++;
//                    break;
//            }
//            if (finish) break;
//        }


        List<CrateStack> stacks = new ArrayList<>();
        stacks.add(new CrateStack("1", 'V', 'N', 'F', 'S', 'M', 'P', 'H', 'J'));
        stacks.add(new CrateStack("2", 'Q', 'D', 'J', 'M', 'L', 'R', 'S'));
        stacks.add(new CrateStack("3", 'B', 'W', 'S', 'C', 'H', 'D', 'Q', 'N'));
        stacks.add(new CrateStack("4", 'L', 'C', 'S', 'R'));
        stacks.add(new CrateStack("5", 'B', 'F', 'P', 'T', 'V', 'M'));
        stacks.add(new CrateStack("6", 'C', 'N', 'Q', 'R', 'T'));
        stacks.add(new CrateStack("7", 'R', 'V', 'G'));
        stacks.add(new CrateStack("8", 'R', 'L', 'D', 'P', 'S', 'Z', 'C'));
        stacks.add(new CrateStack("9", 'F', 'B', 'P', 'G', 'V', 'J', 'S', 'D'));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.isEmpty() || line.charAt(0)  == ' ' || line.contains("[")){
                continue;
            }
            String []values = line.split(" ");

            int anzToMove = Integer.parseInt(values[1]);
            int from = Integer.parseInt(values[3]) - 1;
            int to = Integer.parseInt(values[5]) - 1;

            stacks.get(from).moveTo(anzToMove, stacks.get(to));

        }

        for(CrateStack cs:stacks){
            System.out.print(cs.pop());
        }


    }
}
