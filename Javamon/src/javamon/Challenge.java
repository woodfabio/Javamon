package javamon;
import java.util.Random;
import java.util.Scanner;
public class Challenge {
    // attributes
    private Move[] player;      // player pokémon moves
    private Move[] npc;         // npc pokémon moves
    private Pokemon p1;         // fastest pokémon
    private Pokemon p2;         // slower pokémon
    private boolean eqspe;      // true if both speeds are equal
    private boolean approved;   // check if both are not fainted
    private Move npcm;          // NPC current move
    private Move playerm;       // player current move
    // constructor method
    public Challenge(Pokemon poke1, Pokemon poke2) {
        // check if both pokémon aren't fainted
        if (poke1.fainted == true || poke2.fainted == true) {
            System.out.println("Fainted pokémon can't battle!");
            this.approved = false;
        } else {
            this.approved = true;
            if (poke1.isNpc()) {
                this.npc = new Move[] {poke1.m1, poke1.m2, poke1.m3, poke1.m4};
                this.player = new Move[] {poke2.m1, poke2.m2, poke2.m3, poke2.m4};
            } else {
                this.player = new Move[] {poke1.m1, poke1.m2, poke1.m3, poke1.m4};
                this.npc = new Move[] {poke2.m1, poke2.m2, poke2.m3, poke2.m4};
            }
            // check if both speeds are equal
            // if not, check who's the fastest (p1)
            if (poke1.getSpe() == poke2.getSpe()) {
                this.eqspe = true;
                this.p1 = poke1; // just temporarily
                this.p2 = poke2;
            } else {
                this.eqspe = false;
                if (poke1.getSpe() > poke2.getSpe()) {
                    this.p1 = poke1;
                    this.p2 = poke2;
                } else {
                    this.p1 = poke2;
                    this.p2 = poke1;
                }
            }
        }   
    }    
    // methods
     public void battle() {
        // check if neither pokémon is fainted
        if (!this.isApproved()) {
            System.out.println("Fainted pokémon can't battle!");
        } else {
            String defeated;
            if (p1.isNpc()) {
                System.out.println(p2.getName() + " Vs. " + p1.getName());
            } else {
                System.out.println(p1.getName() + " Vs. " + p2.getName());
            }
            while (this.isApproved()) {
                Scanner t = new Scanner(System.in);
                // choose options
                boolean invalidOption = true;
                int op;                
                do {
                    System.out.println("Menu: ");
                    System.out.println("[1] - Fight");
                    System.out.println("[2] - Check status");
                    System.out.println("[3] - Check moves");
                    System.out.println("[4] - Run");
                    System.out.print("Choose an option number: ");
                    op = t.nextInt();
                    switch (op) {
                        case 1:
                            invalidOption = false;
                            break;
                        case 2:
                            if (p1.isNpc()) {
                                p2.showStatus();
                            } else {
                                p1.showStatus();
                            }
                            break;
                        case 3:
                            if (p1.isNpc()) {
                                p2.showMoves();
                            } else {
                                p1.showMoves();
                            }
                            break;
                        case 4:
                            System.out.println("You run away safely!");
                            this.approved = false;
                            invalidOption = false;
                            break;
                    }
                    if (op < 1 || op > 4) {
                        System.out.println("Invalid option selected!");
                    }
                } while (invalidOption == true);
                
                
                // choose player move
                if (this.isApproved()) {
                    boolean invalidMove = true;
                    int m;
                    System.out.print("Choose a move number: ");
                    m = t.nextInt();
                    do {
                        if (m >= 1 && m <= 4) {
                           switch (m) {    // player move
                                case 1:
                                    if (!this.player[0].name.equals("-")) {
                                       this.playerm = this.player[0];
                                       invalidMove = false;
                                    }
                                    break;
                                case 2:
                                    if (!this.player[1].name.equals("-")) {
                                       this.playerm = this.player[1];
                                       invalidMove = false;
                                    }
                                    break;
                                case 3:
                                    if (!this.player[2].name.equals("-")) {
                                       this.playerm = this.player[3];
                                       invalidMove = false;
                                    }
                                    break;
                                case 4:
                                    if (!this.player[3].name.equals("-")) {
                                       this.playerm = this.player[4];
                                       invalidMove = false;                               
                                    }
                                    break;                            
                            } 
                        }                
                        if (invalidMove) {
                            System.out.println("Invalid move selected!");
                            System.out.print("Choose a valid move number: ");                        
                            m = t.nextInt();                        
                        }                    
                    } while (invalidMove);
                    // t.close();                
                    // choose a random move for the NPC
                    boolean check = true;
                    while (check) {
                        Random n = new Random();
                        int f = n.nextInt(4); 
                        switch (f) {
                            case 0:
                                if (!this.npc[0].name.equals("-")) {
                                    this.npcm = this.npc[0];
                                    check = false;
                                    break;
                                }
                            case 1:
                                if (!this.npc[1].name.equals("-")) {
                                    this.npcm = this.npc[1];
                                    check = false;
                                    break;
                                }
                           case 2:
                                if (!this.npc[2].name.equals("-")) {
                                    this.npcm = this.npc[2];
                                    check = false;
                                    break;
                                }
                            case 3:
                                if (!this.npc[3].name.equals("-")) {
                                    this.npcm = this.npc[3];
                                    check = false;
                                    break;
                                }                        
                        }
                    } // while check
                    // the fastest pokémon (p1) makes the first move
                    // check if both speeds are equal
                    // if they are, choose a random pokémon as faster (p1) in the turn
                    if (eqspe) {
                        Random n = new Random();
                        boolean fastpoke = n.nextBoolean();
                        if (fastpoke) {
                            Pokemon aux = p1;
                            this.p1 = p2;
                             this.p2 = aux;  
                        }
                    }  
                    // p1 makes the move
                    double dmg1;
                    if (p1.isNpc()) {
                        System.out.println(p1.getName() + " used " + npcm.getName());
                        dmg1 = Math.round(((npcm.getPower()*(p1.getAtk()/p2.getDef()))/50+2)*(npcm.effect(p2)));
                        // show effectiveness
                        if (npcm.effect(p2) >= 2) {
                            System.out.println("It's super effective!");
                        } else if (npcm.effect(p2) <= 0.5) {
                            System.out.println("It's not very effective...");
                        }
                    } else {
                        System.out.println(p1.getName() + " used " + playerm.getName());
                        dmg1 = Math.round(((playerm.getPower()*(p1.getAtk()/p2.getDef()))/50+2)*(playerm.effect(p2)));
                        // show effectiveness
                        if (playerm.effect(p2) >= 2) {
                            System.out.println("It's super effective!");
                        } else if (playerm.effect(p2) <= 0.5) {
                            System.out.println("It's not very effective...");
                        }
                    }
                    p2.setCurhp(p2.getCurhp() - (int) dmg1);
                    //
                    this.p2.setFainted();
                    System.out.println(p2.getName() + "'s Hp: " + p2.getCurhp() + "/" + p2.getHp());

                    // check if p2 fainted                
                    if (this.p2.fainted) {
                        System.out.println(this.p2.getName() + " fainted!");
                        this.approved = false;
                        break;
                    } else {
                        double dmg2;
                        if (p2.isNpc()) {
                            System.out.println(p2.getName() + " used " + npcm.getName());
                            dmg2 = Math.round(((npcm.getPower()*(p2.getAtk()/p1.getDef()))/50+2)*(npcm.effect(p1)));
                            // show effectiveness
                            if (npcm.effect(p1) >= 2) {
                                System.out.println("It's super effective!");
                            } else if (npcm.effect(p1) <= 0.5) {
                                System.out.println("It's not very effective...");
                            }
                        } else {
                            System.out.println(p2.getName() + " used " + playerm.getName());
                            dmg2 = Math.round(((playerm.getPower()*(p2.getAtk()/p1.getDef()))/50+2)*(playerm.effect(p1)));
                            // show effectiveness
                            if (playerm.effect(p1) >= 2) {
                                System.out.println("It's super effective!");
                            } else if (playerm.effect(p1) <= 0.5) {
                                System.out.println("It's not very effective...");
                            }
                        }
                        // set damage
                        p1.setCurhp(p1.getCurhp() - (int) dmg2);
                        //
                        this.p2.setFainted();
                        System.out.println(p1.getName() + "'s Hp: " + p1.getCurhp() + "/" + p1.getHp());
                    }
                    // check if p1 fainted             
                    if (p1.fainted) {
                        System.out.println(p1.getName() + " fainted!");
                        this.approved = false;
                        break;
                    }

                    // System.out.println("TESTE----------------------------");

                    //this.approved = false;
                } // while approved 2
            } // while approved 1               
        } // if approved at first
            
                
                
    } // battle()          
     
        
    
    // metodos temporarios
    
    public boolean isApproved() {
        return this.approved;
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