package javamon;
public class Javamon {
    public static void main(String[] args) {
        Pokemon p1 = Pokemon.bulbasaur("Bulba");
        Pokemon p2 = Pokemon.bulbasaur("Challenger");
        p2.setNpc(true);
        p1.showName();
        p1.showSp();        
        p1.showStatus();
        p1.showMoves();
        // p1.setFainted(true);
        p1.levelUp(10);
        p1.showStatus();
        Challenge c1 = new Challenge(p1,p2);
        c1.battle();
        p1.showStatus();
        p1.showMoves();
        //p1.showStatus();
        //p2.showStatus();*/
    }
    
}
