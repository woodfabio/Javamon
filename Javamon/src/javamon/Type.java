package javamon;
public class Type {
    // attributes
    protected String name;  // type name
    protected Integer id;       // type number id:
                                    // null = none
                                    // 0 = normal
                                    // 1 = grass
                                    // 2 = fire
                                    // 3 = water
                                    // 4 = electric
                                    // 5 = poison
                                    // 6 = flying
    // constructor methods
    public Type() {
        this.name = "-";
    }
    public Type(int id) {
        this.id = id;
        switch (this.id) {
            case 0:
                this.name = "Normal";
                break;
            case 1:
                this.name = "Grass";
                break;
            case 2:
                this.name = "Fire";
                break;
            case 3:
                this.name = "Water";
                break;
            case 4:
                this.name = "Poison";
                break;
            default:
                this.id = null;
                this.name = "-";
                break;
        }
    }
}
