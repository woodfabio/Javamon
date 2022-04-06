package javamon;
public class Type {
    // attributes
    protected String name;  // type name
    protected int id;       // type number id:
                                    // 0 = none
                                    // 1 = normal
                                    // 2 = grass
                                    // 3 = fire
                                    // 4 = water
                                    // 5 = electric
                                    // 6 = poison
                                    // 7 = flying
    // constructor method
    public Type(String n, int i) {
        this.name = n;
        this.id = i;
    }
}
