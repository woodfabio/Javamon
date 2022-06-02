package javamon;
import java.util.Random;
public class Pokemon implements Poke {
    // attributes
    protected String species;    // pokémon species
    protected String name;       // pokémon name
    protected Type type1;        // pokémon type 1
    protected Type type2;        // pokémon type 2
                                   // 0 = normal
                                   // 1 = grass
                                   // 2 = fire
                                   // 3 = water
                                   // 4 = electric
                                   // 5 = poison
                                   // 6 = flying
    protected Integer xp;        // experience
    protected Integer hp;        // maximum health points
    protected Integer curhp;     // current health points
    protected boolean fainted;   // if fainted, it's unable to battle
    protected Integer atk;       // attack
    protected Integer def;       // defense
    protected Integer spe;       // speed
    private boolean npc;         // true if the pokémon is an NPC
    protected Move[] moves;      // pokémon moves
    private Integer ev[];        // levels required for evolution
    private Integer evstats[][]; // status for evolutions
    private String evnames[];    // names for evolutions
    private Type evtypes[][];      // types for evolutions
    
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
        // evolution levels
        b.ev = new Integer[2];
        b.ev[0] = 16;
        b.ev[1] = 32;
        // evolutions stats
        b.evstats = new Integer [2][4];
        Integer n1[] = {60, 62, 63, 60};
        Integer n2[] = {80, 100, 100, 80};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0) {
                    b.evstats[i][j] = n1[j];
                } else {
                    b.evstats[i][j] = n2[j];
                }
            }
            
        }
        // evolution names
        String names [] = {"Ivysaur", "Venusaur"};
        b.evnames = names;
        // evolution types
        b.evtypes = new Type[2][2];
        Type types [] = {new Type(1), new Type(4)};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                b.evtypes[i][j] = types[j];
            }
            
        }
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
        this.xp = this.getXp() + xp;
        this.evolve();
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
    protected Move getMove(int n) {
        return this.moves[n];
    }
    protected void setMove(int n, Move m) {
        this.moves[n] = m;
    }
       
    // method for choosing a move (random if is a NPC) -------------------------
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
    // method for STAB (Same Type Attack Bonus)---------------------------------
    protected double stab(Move m) {
        double stab;
        if (this.type1 == m.type || this.type2 == m.type) {
            stab = 1.5;
        } else {
            stab = 1;
        }
        return stab;
    }
    
    // method for evolving the pokémon if the required level is achieved -------
    private void evolve() {
        if (this.getXp() == this.ev[0]) {
            System.out.println(this.getName()+" has evolved to "+this.evnames[0]+"!");
            this.setSpecies(this.evnames[0]);
            this.setType1(this.evtypes[0][0]);
            this.setType2(this.evtypes[0][1]);
            this.setHp(this.evstats[0][0]);
            this.setAtk(this.evstats[0][1]);
            this.setDef(this.evstats[0][2]);
            this.setSpe(this.evstats[0][3]);
        } else if (this.getXp() == this.ev[1]) {
            System.out.println(this.getName()+" has evolved to "+this.evnames[0]+"!");
            this.setSpecies(this.evnames[1]);
            this.setType1(this.evtypes[1][0]);
            this.setType2(this.evtypes[1][1]);
            this.setHp(this.evstats[1][0]);
            this.setAtk(this.evstats[1][1]);
            this.setDef(this.evstats[1][2]);
            this.setSpe(this.evstats[1][3]);
    }
    }
    
    // interface public methods for showing attributes -------------------------
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
    }
}
