package javamon;
import java.util.Random;
public class Challenge {
    // attributes
    private Pokemon p1;         // pokémon 1
    private Pokemon p2;         // pokémon 2
    private boolean approved;   // check if both are not fainted
    private Move npcm;          // NPC move
    private Move playerm;       // player move
    private boolean end;        // false unless player quit battle or a pokémon faints 
    // constructor method
    public Challenge(Pokemon poke1, Pokemon poke2) {
        // verifying if both pokémon aren't fainted
        if (poke1.fainted == true || poke2.fainted == true) {
            System.out.println("Fainted pokémon can't battle!");
            this.p1 = poke1;
            this.p2 = poke2;
            this.approved = false;
        } else {
            // calculating who is the fastest pokemon (p1) to make the first move
            if (poke1.getSpe() > poke2.getSpe()) {
                this.p1 = poke1;
                this.p2 = poke2; 
            } else if (poke1.getSpe() == poke2.getSpe()) {
                Random n = new Random();
                int f = n.nextInt(2);
                if (f == 0) {
                    this.p1 = poke1;
                    this.p2 = poke2;
                } else {
                    this.p1 = poke2;
                    this.p2 = poke1;
                }
            } else {
               this.p1 = poke2;
               this.p2 = poke1; 
            }
            this.approved = true;
            this.end = false;
        }
        
    }
    
    // methods
     public void battle(int m) {        // playerm == player move
        if (isApproved() == false) {    // check if battle is approved
            System.out.println("Fainted pokémon can't battle!");
        } else if (m < 1 || m > 4) {    // check if selected move is valid
            System.out.println("Incorrect move selected!");
        } else {
            while (this.end == false) {
                System.out.println(p1.getName() + " Vs. " + p2.getName()); 
                // choose a random move for the NPC
                Random n = new Random();
                int f = n.nextInt(4); 
                // check which pokémon is the NPC
                if (p1.isNpc()) {   // p1 is the NPC
                    switch (f) {
                        case 0:
                            this.npcm = p1.getMove1();    // npcm == NPC move
                            break;
                        case 1:
                            this.npcm = p1.getMove2();    // npcm == NPC move
                            break;
                        case 2:
                            this.npcm = p1.getMove3();    // npcm == NPC move
                            break;
                        case 3:
                            this.npcm = p1.getMove4();    // npcm == NPC move
                            break;                        
                    }
                    switch (m) {    // player move
                        case 1:
                            this.playerm = p2.getMove1(); // npcm == NPC move
                            break;
                        case 2:
                            this.playerm = p2.getMove2(); // npcm == NPC move
                            break;
                        case 3:
                            this.playerm = p2.getMove3(); // npcm == NPC move
                            break;
                        case 4:
                            this.playerm = p2.getMove4(); // npcm == NPC move
                            break;     
                    }
                } else {            // p2 is the NPC
                    switch (f) {
                        case 0:
                            this.npcm = p2.getMove1();    // npcm == NPC move
                            break;
                        case 1:
                            this.npcm = p2.getMove2();    // npcm == NPC move
                            break;
                        case 2:
                            this.npcm = p2.getMove3();    // npcm == NPC move
                            break;
                        case 3:
                            this.npcm = p2.getMove4();    // npcm == NPC move
                            break;                        
                    }
                    switch (m) {    // player move
                        case 1:
                            this.playerm = p1.getMove1(); // npcm == NPC move
                            break;
                        case 2:
                            this.playerm = p1.getMove2(); // npcm == NPC move
                            break;
                        case 3:
                            this.playerm = p1.getMove3(); // npcm == NPC move
                            break;
                        case 4:
                            this.playerm = p1.getMove4(); // npcm == NPC move
                            break;     
                    }    
                }
                // the fastest pokémon (p1) makes the first move        
                if (p1.isNpc()) {
                   System.out.println(p1.getName() + " used " + npcm.getName());                   
                } else {
                    System.out.println(p1.getName() + " used " + playerm.getName());
                }
                this.end = true;
            }
        }        
    }
    
    // metodos temporarios
    
    public boolean isApproved() {
        return approved;
    }

    public void showP1() {
        System.out.println(this.p1.name);
    }

    public void showP2() {
        System.out.println(this.p2.name);
    }
    public void showNpcm() {
        System.out.println(this.npcm.getName());
    }
    public void showPlayerm() {
        System.out.println(this.playerm.getName());
    }    
}





/*
// the fastest pokémon (p1) makes the first move            
            System.out.println(p1.getName() + " used " + m.getName());
                
            // calculating effectiveness of move
                String phrase;   // phrase about effectiveness
                float effect;      // effectivenes index
                if (m.getType() == 1) { // grass
                    switch (p2.getType1()) {
                        case 2: // fire
                            phrase = "It's not very effective.";
                            effect = 0.5f;
                            break;
                        case 3:
                            phrase = "It's super effective!";
                            effect = 2;
                            break;
                        default:
                            effect = 1;
                    }                
                }
                else if (m.getType() == 2) { // fire
                    switch (p2.getType1()) {
                        case 3: // fire
                            phrase = "It's not very effective.";
                            effect = 0.5f;
                            break;
                        case 1:
                            phrase = "It's super effective!";
                            effect = 2;
                            break;
                        default:
                            effect = 1;
                    }                
             }
                else if (m.getType() == 3) { // water
                    switch (p2.getType1()) {
                        case 1: // fire
                            phrase = "It's not very effective.";
                            effect = 0.5f;
                            break;
                        case 2:
                            phrase = "It's super effective!";
                            effect = 2;
                            break;
                        default:
                            effect = 1;
                    }                
                }
                
                // calculating damage
                //float d = ((m.getPower()*(p1.getAtk()/p2.getDef()))/50+2)*effect;
                //p2.setCurhp(p2.getCurhp()-d);
            }
*/