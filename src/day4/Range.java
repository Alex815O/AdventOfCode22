package day4;


public class Range{

    private final int a;
    private final int b;

    public Range(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean fullyContains(Range other){
        return other.a >= this.a && other.b <= this.b;
    }

    public boolean overlap(Range other){
        return other.a <= this.b && this.a <= other.b;
    }

    @Override
    public String toString() {
        return "{" + a+ "-" + b+'}';
    }
}
