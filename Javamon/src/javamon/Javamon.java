package javamon;
public class Javamon {
    public static void main(String[] args) {
        Bulbasaur p1 = new Bulbasaur("Bulba");
        Bulbasaur p2 = new Bulbasaur("Challenger");
        p2.setNpc(true);
        p1.showName();
        p1.showSp();
        p1.showStatus();
        p1.showMoves();
        //p1.setFainted(true);
        Challenge c1 = new Challenge(p1,p2);
        c1.showP1();
        c1.showP2();
        c1.battle();
        //p1.showStatus();
        //p2.showStatus();
    }
    
}
