package javamon;
import java.util.Random;
import java.util.Scanner;
public class Javamon {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Pokemon playerPoke = new Pokemon(0,"");
        
        boolean invOp = true;
        do {
            System.out.println("Chose a starter pokémon: ");
            System.out.println("[1] - Bulbasaur (grass type)");
            System.out.println("[2] - Charmander (fire type)");
            System.out.println("[3] - Squirtle (water type}");
            int op = t.nextInt();
            if (op > 0 && op <4) {
                System.out.println("Choose a name for your pokémon: ");
                t.nextLine();
                String pname = t.nextLine();
                playerPoke = new Pokemon(op,pname);
                playerPoke.showStatus();
                invOp = false;
            } else {
                System.out.println("Invalid option!");
            }            
        } while (invOp);
        
        boolean on = true;
        while (on) {
            int op;
            System.out.println("Select an action: ");
            System.out.println("[1] - Walk");
            System.out.println("[2] - Use item");
            System.out.println("[3] - Go to Pokécenter");
            System.out.println("[4] - Exit game");
            op = t.nextInt();
            
            if (op > 0 && op < 4) {
                switch (op)  {
                    case 1:
                        System.out.println("You walk in th tall grass...");
                        boolean walkret = walk();
                        if (walkret) {
                            Pokemon wildPoke = randPoke();
                            System.out.println("A wild " + wildPoke.getSpecies() + " appears!");
                            Challenge c = new Challenge(playerPoke,wildPoke);
                            c.battle();
                        } else {
                            System.out.println("Nothing happens!");
                        }
                }
            } else if (op == 4) {
                System.out.println("Exiting game...");
                on = false;
            } else {
                System.out.println("Invalid option!");
            }            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*Pokemon p1 = Pokemon.bulbasaur("Bulba");
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
    // method for walking
    public static boolean walk() {
        boolean encounter;
        Random rand = new Random();
        int n = rand.nextInt(3);
        if (n == 0) {
            encounter = true;
        } else {
            encounter = false;
        }
        return encounter;
    }
    
   // method for selecting a random Pokémon
    public static Pokemon randPoke() {
        Pokemon p1 = new Pokemon(1,"Bulbasaur");
        Random randp = new Random();
        int poke = randp.nextInt(3);
        switch (poke) {
            case 0:
               p1 = new Pokemon(2,"Charmander");
               break;
            case 1:
                p1 = new Pokemon(3,"Squirtle");
                break;
        }
        p1.setNpc(true);
        return p1;
    }
    
}
