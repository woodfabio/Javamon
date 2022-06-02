package javamon;
import java.util.Random;
import java.util.Scanner;
public class Challenge {
    // attributes
    private Pokemon speeds[];   // speed ranking (the first is the faster)
    private Pokemon npc[];      // npc ranking (the first is the npc)
    private boolean eqspe;      // true if both speeds are equal
    private boolean approved;   // check if both are not fainted
    private int playerm;        // player current move
    // constructor method
    public Challenge(Pokemon poke1, Pokemon poke2) {
        // check if both pokémon aren't fainted before the start ---------------
        if (poke1.fainted == true || poke2.fainted == true) {
            System.out.println("Fainted pokémon can't battle!");
            this.approved = false;
        } else {
            this.speeds = new Pokemon[2];
            this.npc = new Pokemon[2];
            this.approved = true;
            // check if both speeds are equal ----------------------------------
            // if not, check who's the faster and add as first in this.speeds[]
            if (poke1.getSpe() == poke2.getSpe()) {
                this.eqspe = true;
                this.speeds[0] = poke1; // just temporarily
                this.speeds[1] = poke2;
            } else {
                this.eqspe = false;
                if (poke1.getSpe() > poke2.getSpe()) {
                    this.speeds[0] = poke1;
                    this.speeds[1] = poke2;
                } else {
                    this.speeds[0] = poke2;
                    this.speeds[1] = poke1;
                }
            }
            // check which is the npc and add as first in this.npc[] -----------
            if (poke1.isNpc()) {
                this.npc[0] = poke1;
                this.npc[1] = poke2;
            } else{
                this.npc[0] = poke2;
                this.npc[1] = poke1;
            }
        }   
    }    
    // methods -----------------------------------------------------------------
     public void battle() {
        // check if neither pokémon is fainted before the current turn
        if (!this.isApproved()) {
            System.out.println("Fainted pokémon can't battle!");
        } else {
            String defeated; // 
            // show challengers ------------------------------------------------
            System.out.println(this.npc[1].getName() + " Vs. " + this.npc[0].getName());
            // menu loop -------------------------------------------------------
            while (this.isApproved()) {
                Scanner t = new Scanner(System.in);
                // choose options
                boolean invalidMenuOp = true;
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
                            invalidMenuOp = false;
                            break;
                        case 2:
                            this.npc[1].showStatus();
                            break;
                        case 3:
                            this.npc[1].showMoves();
                            break;
                        case 4:
                            System.out.println("You run away safely!");
                            this.approved = false;
                            invalidMenuOp = false;
                            break;
                    }
                    if (op < 1 || op > 4) {
                        System.out.println("Invalid option selected!");
                    }
                } while (invalidMenuOp == true);
                                
                // choose player move ------------------------------------------
                boolean invalidMoveOp = true;
                boolean moveSelected = false;
                int m;
                if (op == 1) {
                    do {
                        System.out.print("Choose a move number or 5 to go back to menu: ");
                        m = t.nextInt();                        
                        if (m >= 1 && m <= 4 && !this.npc[1].moves[m-1].name.equals("-")) {
                            this.playerm = m-1;
                            invalidMoveOp = false;
                            moveSelected = true;
                        } else if (m == 5 ) {
                            invalidMoveOp = false;
                        } else {
                            System.out.println("Invalid option or move selected!");
                        }                    
                    } while (invalidMoveOp);
                    // -------------------------------------------------------------
                    if (moveSelected) {
                    // the faster pokémon (speeds[0]) makes the first move
                    // check if both speeds are equal
                    // if they are, choose a random pokémon as faster (speeds[0]) in the turn
                        if (eqspe) {
                            Random n = new Random();
                            boolean fastpoke = n.nextBoolean();
                            if (fastpoke) {
                                Pokemon aux = this.speeds[0];
                                this.speeds[0] = this.speeds[1];
                                this.speeds[1] = aux;  
                            }
                        }  
                    // faster pokémon makes the move -------------------------------
                        double dmg1;
                        Move currMove1 = this.speeds[0].chooseMove(playerm);
                        System.out.println(speeds[0].getName() + " used " + currMove1.getName());
                        dmg1 = Math.round(((currMove1.getPower()*(speeds[0].getAtk()/speeds[1].getDef()))/50+2)*(currMove1.effect(speeds[1]))*speeds[0].stab(currMove1));
                        // show effectiveness
                        if (currMove1.effect(speeds[1]) >= 2) {
                            System.out.println("It's super effective!");
                        } else if (currMove1.effect(speeds[1]) <= 0.5) {
                            System.out.println("It's not very effective...");
                        }
                        // set damage -------------------------------------------
                        speeds[1].setCurhp(speeds[1].getCurhp() - (int) dmg1);
                        this.speeds[1].setFainted();
                        System.out.println(speeds[1].getName() + "'s Hp: " + speeds[1].getCurhp() + "/" + speeds[1].getHp());

                        // slower pokémon makes the move (if not fainted) ------               
                        if (this.speeds[1].fainted) {
                            System.out.println(this.speeds[1].getName() + " fainted!");
                            this.approved = false;
                            break;
                        } else {
                            double dmg2;
                            Move currMove2 = this.speeds[1].chooseMove(playerm);
                            System.out.println(speeds[1].getName() + " used " + currMove2.getName());
                            dmg2 = Math.round(((currMove2.getPower()*(speeds[1].getAtk()/speeds[0].getDef()))/50+2)*(currMove2.effect(speeds[0]))*speeds[1].stab(currMove2));
                            // show effectiveness
                            if (currMove2.effect(speeds[0]) >= 2) {
                                System.out.println("It's super effective!");
                            } else if (currMove2.effect(speeds[0]) <= 0.5) {
                                System.out.println("It's not very effective...");
                            }
                            // set damage
                            speeds[0].setCurhp(speeds[0].getCurhp() - (int) dmg2);
                            //
                            this.speeds[0].setFainted();
                            System.out.println(speeds[0].getName() + "'s Hp: " + speeds[0].getCurhp() + "/" + speeds[0].getHp());
                        }
                        // check if faster pokémon fainted ---------------------            
                        if (speeds[0].fainted) {
                            System.out.println(speeds[0].getName() + " fainted!");
                            this.approved = false;
                            break;
                        }
                    } // if a move was selected
                } // if op == 1 (fight)
            } // while approved (menu options)
            // if the player pokémon won, gains 1 level ------------------------
            if (!this.npc[1].fainted && this.npc[0].fainted) {
                this.npc[1].levelUp(1);
            }
        } // if approved at first
            
                
                
    } // battle()          
     
        
    
    // metodos temporarios
    
    public boolean isApproved() {
        return this.approved;
    }
    public void showP1() {
        System.out.println(this.speeds[0].name);
    }
    public void showP2() {
        System.out.println(this.speeds[1].name);
    }
    
}




