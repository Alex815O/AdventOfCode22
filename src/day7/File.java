package day7;

public class File implements SysObject{

    public final String name;
    public double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSize() {
        return this.size;
    }
}
