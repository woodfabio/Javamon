package javamon;
public class Move {
    private String name;
    private int type;   // 1 = normal
                        // 2 = grass
                        // 3 = fire
                        // 4 = water
                        // 5 = electric
                        // 6 = poison
                        // 7 = flying
    private int power;
    private int pp;     // power points - each usage spends 1 pp
    // constructor method
    public Move(String name, int type, int power, int pp) {
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
    public int getType() {
        return type;
    }
    public void setType(int type) {
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
}
