package day7;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Directory implements SysObject{

    private final String name;
    private List<SysObject> child;
    private final Directory parent;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.child = new LinkedList<>();
        this.parent = parent;
    }

    public void addSysObject(SysObject so){
        this.child.add(so);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSize() {
        return this.child.stream().mapToDouble(SysObject::getSize).sum();
    }

    public Directory getParent(){
        return this.parent;
    }

    public Directory changeDirectory(String name) throws FileNotFoundException{
        if (name.equals("..")){
            return this.getParent();
        }
        if (name.equals(".")){
            return this;
        }

        for (SysObject so:child){
            if (so.getName().equals(name)){
                if (so instanceof File) {
                    throw new FileNotFoundException("This is not a directory!");
                }
                return (Directory) so;
            }
        }
        return null;
    }
}
