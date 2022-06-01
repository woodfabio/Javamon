package javamon;
import java.util.Random;
public class Pokemon implements Poke {
    // attributes
    protected String species;   // pokémon species
    protected String name;      // pokémon name
    protected Type type1;       // pokémon type 1
    protected Type type2;       // pokémon type 2
                                   // 0 = normal
                                   // 1 = grass
                                   // 2 = fire
                                   // 3 = water
                                   // 4 = electric
                                   // 5 = poison
                                   // 6 = flying
    protected Integer xp;       // experience
    protected Integer hp;       // maximum health points
    protected Integer curhp;    // current health points
    protected boolean fainted;  // if fainted, it's unable to battle
    protected Integer atk;      // attack
    protected Integer def;      // defense
    protected Integer spe;      // speed
    private   boolean npc;      // true if the pokémon is an NPC
    protected Move[] moves;     // pokémon moves
    
    // species constructor methods
    // bulbasaur constructors
    public static Pokemon bulbasaur(String name) {
        Pokemon b = new Pokemon();
        b.setName(name);
        b.xp = 0;
        b.setSpecies("Bulbasaur");
        // type 1
        b.setType1(new Type(1));
        // type 2
        b.setType2(new Type(4));
        // status
        b.setHp(45);
        b.setCurhp(b.getHp());
        b.setAtk(65);
        b.setDef(49);
        b.setSpe(45);
        // moves
        b.moves = new Move[4];
        b.setMove(0, new Move("Tackle", new Type(0),40,35));
        b.setMove(1, new Move("VineWhip", new Type(1),45,25));
        b.setMove(2, new Move());
        b.setMove(3, new Move());
        
        return b;
    }
    // getter and setter methods - not all attributes have public setter methods
    protected String getSpecies() {
        return this.species;
    }
    protected void setSpecies(String sp) {
        this.species = sp;
    }
    protected String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    protected Type getType1() {
        return this.type1;
    }
    protected void setType1(Type t) {
        this.type1 = t;
    }
    protected Type getType2() {
        return this.type2;
    }
    protected void setType2(Type t) {
        this.type2 = t;
    }
    protected Integer getXp() {
        return this.xp;
    }
    protected void setXp(int xp) {
        this.xp = xp;
    }
    protected Integer getHp() {
        return this.hp;
    }
    protected void setHp(int hp) {
        this.hp = hp;
    }
    protected Integer getCurhp() {
        return this.curhp;
    }
    protected void setCurhp(int curhp) {
        this.curhp = curhp;
        if (this.curhp <= 0) {
            this.curhp = 0;
        }
    }
    public void setFainted() {
        if (this.curhp <= 0) {
            this.fainted = true;
        }
    }
    protected Integer getAtk() {
        return this.atk;
    }
    protected void setAtk(int atk) {
        this.atk = atk;
    }
    protected Integer getDef() {
        return this.def;
    }
    protected void setDef(int def) {
        this.def = def;
    }
    protected Integer getSpe() {
        return this.spe;
    }
    public boolean isNpc() {
        return this.npc;
    }  
    protected void setNpc(boolean npc) {
        this.npc = npc;
    }    
    protected void setSpe(int spe) {
        this.spe = spe;
    }
    
    
    //--------------------------------------------------------------------------
    
    
    //protected Move getMove1() {
    //    return this.m1;
    //}
    protected Move getMove(int n) {
        return this.moves[n];
    }
    protected void setMove(int n, Move m) {
        this.moves[n] = m;
    }
    //protected void setMove1(Move m) {
    //    this.m1 = m;
    //}

    //--------------------------------------------------------------------------

    /*
    protected Move getMove2() {
        return this.m2;
    }
    protected void setMove2(Move m) {
        this.m2 = m;
    }
    protected Move getMove3() {
        return this.m3;
    }
    protected void setMove3(Move m) {
        this.m3 = m;
    }
    protected Move getMove4() {
        return this.m4;
    }
    protected void setMove4(Move m) {
        this.m4 = m;
    }
    */
    
    // method for choosing a random move ---------------------------------------
    protected Move chooseMove(int n) {
        Move a = new Move();
        if (this.isNpc()) {
            boolean invalidMove = true;
            while (invalidMove) {
                Random op = new Random();
                int m  = op.nextInt(3);
                switch (m) {
                    case 0:
                        if (!this.getMove(0).name.equals("-")) {
                            a = this.getMove(0);
                            invalidMove = false;
                        }
                        break;
                    case 1:
                        if (!this.getMove(1).name.equals("-")) {
                            a = this.getMove(1);
                            invalidMove = false;
                        }
                        break;
                    case 2:
                        if (!this.getMove(2).name.equals("-")) {
                            a = this.getMove(2);
                            invalidMove = false;
                        }
                        break;
                    case 3:
                        if (!this.getMove(3).name.equals("-")) {
                            a = this.getMove(3);
                            invalidMove = false;
                        }
                        break;
                }
            }
        } else {
            if (!this.moves[n].name.equals("-")) {
                a = this.moves[n];
            } else {
                a = null;
            }
        }
        return a;
    }
    // method for STAB (Same Type Attack Bonus)
    protected double stab(Move m) {
        double stab;
        if (this.type1 == m.type || this.type2 == m.type) {
            stab = 1.5;
        } else {
            stab = 1;
        }
        return stab;
    }
    // interface public methods for showing attributes
    @Override
    public void showSp() {
        System.out.println(this.species);
    }
    @Override
    public void showName() {
        System.out.println(this.getName());
    }
    @Override
    public void showType1() {
        System.out.println(this.getType1());
    }
    @Override
    public void showType2() {
        System.out.println(this.getType2());
    }
    @Override
    public void showStatus() {
        System.out.println("Name: " + this.getName());
        System.out.println("Species: " + this.getSpecies());
        System.out.print("Type: " + this.getType1().name + "/");
        System.out.println(this.getType2().name);
        System.out.println("XP: " + this.getXp());
        System.out.print("HP: " + this.getCurhp()+ "/");
        System.out.println(this.getHp());
        System.out.println("Atk: " + this.getAtk());
        System.out.println("Def: " + this.getDef());
        System.out.println("Spe: " + this.getSpe());
    }    
    @Override
    public void showMoves() {
        System.out.println("Moves:");
        for (Move m : this.moves) {
            if (m.getName().equals("-")) {
                System.out.println("-");
            } else {
                System.out.println(m.getName()+" ("+m.getType().name+") Power: "+m.getPower()+" Pp: "+m.getCurPp()+"/"+m.getPp());
        
            }
        }
        /*
        if (this.m1.getName().equals("-")) {
            System.out.println("-");
        } else {
            System.out.println(this.m1.getName()+" ("+this.m1.getType().name+") Power: "+this.m1.getPower()+" Pp: "+this.m1.getCurPp()+"/"+this.m1.getPp());
        }
        if (this.m2.getName().equals("-")) {
            System.out.println("-");
        } else {
            System.out.println(this.m2.getName()+" ("+this.m2.getType().name+") Power: "+this.m2.getPower()+" Pp: "+this.m2.getCurPp()+"/"+this.m2.getPp());
        }
        if (this.m3.getName().equals("-")) {
            System.out.println("-");
        } else {
            System.out.println(this.m3.getName()+" ("+this.m3.getType().name+") Power: "+this.m3.getPower()+" Pp: "+this.m3.getCurPp()+"/"+this.m3.getPp());
        }
        if (this.m4.getName().equals("-")) {
            System.out.println("-");
        } else {
            System.out.println(this.m4.getName()+" ("+this.m4.getType().name+") Power: "+this.m4.getPower()+" Pp: "+this.m4.getCurPp()+"/"+this.m4.getPp());
        }*/
    }
}
