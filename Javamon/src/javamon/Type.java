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
    public Type(int id) {
        this.id = id;
        switch (this.id) {
            case 1:
                this.name = "Normal";
                break;
            case 2:
                this.name = "Grass";
                break;
            case 3:
                this.name = "Fire";
                break;
            case 4:
                this.name = "Water";
                break;
            default:
                this.name = "-";
                break;
        }
    }
}
