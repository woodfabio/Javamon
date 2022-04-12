package javamon;
public class Move {
    protected String name;
    protected Type type;  // 1 = normal
                        // 2 = grass
                        // 3 = fire
                        // 4 = water
                        // 5 = electric
                        // 6 = poison
                         // 7 = flying
    private int power;
    private int pp;      // power points - each usage spends 1 pp
    protected int curPp; // current power points
    // constructor methods
    public Move() {  
        this.name = "-";
    }    
    public Move(String name, Type type, int power, int pp) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.pp = pp;
    }    
    // getter and setter methods
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getPp() {
        return pp;
    }
    public void setPp(int pp) {
        this.pp = pp;
    }
    public int getCurPp() {
        return pp;
    }
    public void setCurPp(int pp) {
        this.pp = pp;
    }
    
    // show method
    public void showMove() {
        System.out.println("(" + this.getType().name + ") " + this.getName());
        System.out.println("Power: " + this.power);
        System.out.println("Pp: " + this.curPp + "/" + this.pp);
    }
    
    // effectivenesse method
    public double effect(int def) {
        double eff; // effectiveness
        switch (this.type.id) { // atk type
            case 2: // grass atk
                switch (def) {
                    case 3:  // fire def
                        eff = 0.5;
                        break;
                    case 4:  // water def
                        eff = 2;
                        break;
                    case 2: // grass def
                        eff = 0.5;
                        break;
                    default:
                        eff = 1;
                        break;
                }
                break;
            case 3: // fire atk
                switch (def) {
                    case 2:  // grass def
                        eff = 2;
                        break;
                    case 4:  // water def
                        eff = 0.5;
                        break;
                    case 3: // fire def
                        eff = 0.5;
                        break;
                    default:
                        eff = 1;
                        break;
                }
                break;
            case 4: // water attack
                switch (def) {
                    case 2:  // grass def
                        eff = 0.5;
                        break;
                    case 3:  // fire def
                        eff = 2;
                        break;
                    case 4: // water def
                        eff = 0.5;
                        break;
                    default:
                        eff = 1;
                        break;
                }
                break;
            default: // normal atk
                eff = 1;
        }
        return eff;
    }
}
