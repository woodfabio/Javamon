package javamon;
public class Move {
    private String name;
    private int type;   // 0 = normal
                        // 1 = grass
                        // 2 = fire
                        // 3 = water
                        // 4 = electric
                        // 5 = poison
                        // 6 = flying
    private int power;
    private int pp;     // power points - each usage spends 1 pp
    // non-obligatory constructor method
    public void defineMove(String name, int type, int power, int pp) {
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
