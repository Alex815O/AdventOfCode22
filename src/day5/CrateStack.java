package day5;

import java.util.*;

public class CrateStack {

    private final String name;
    Stack<Character> crates = new Stack<>();

    public CrateStack(String name){
        this.name = name;
    }

    public CrateStack(String name, Character... crates){
        this.name = name;
        for (int i = crates.length-1; i >= 0; i--){
            this.crates.push(crates[i]);
        }
    }


    public Character push(Character ch){
        return this.crates.push(ch);
    }

    public Character pop(){
        return this.crates.pop();
    }

    public Character moveTo(CrateStack target){
        return target.push(this.pop());
    }

    public void moveTo(int n, CrateStack target){
        List<Character> move = new ArrayList<>();
        for (int i = 0; i < n; i++){
            move.add(this.pop());
        }
        for (int i = n-1; i >= 0; i--){
            target.push(move.get(i));
        }
    }

    @Override
    public String toString() {
        return this.name + " --> " + this.crates;
    }



}
