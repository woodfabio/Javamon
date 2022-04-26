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
    protected Move m1;          // first move
    protected Move m2;          // second move
    protected Move m3;          // third move
    protected Move m4;          // fourth move
    // species constructor methods
    // bulbasaur constructors
    public static Pokemon bulbasaur(String name) {
        Pokemon b = new Pokemon();
        b.setName(name);
        b.xp = 0;
        b.setSpecies("Bulbasaur");
        // type 1
        Type t1 = new Type(1);
        b.setType1(t1);
        // type 2
        Type t2 = new Type(4);
        b.setType2(t2);
        /*Type type2 = new Type(6);
        this.setType2(type2); */
        // status
        b.setHp(45);
        b.setCurhp(b.getHp());
        b.setAtk(65);
        b.setDef(49);
        b.setSpe(45);
        // move 1
        Move move1 = new Move("Tackle", new Type(0),40,35);
        b.setMove1(move1);
        // move 2
        Move move2 = new Move("VineWhip", new Type(1),45,25);
        b.setMove2(move2);
        // move 3
        Move move3 = new Move();
        b.setMove3(move3);
        // move 4
        Move move4 = new Move();
        b.setMove4(move4);
        
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
    protected Move getMove1() {
        return this.m1;
    }
    protected void setMove1(Move m) {
        this.m1 = m;
    }
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
    // method for choosing a random move, if it's an NPC
    protected Move chooseMove() {
        Random n = new Random();
        int m  = n.nextInt(3);
        Move a = new Move();
        switch (m) {
            case 0:
                a = this.getMove1();                
            case 1:
                a = this.getMove2();                
            case 2:
                a = this.getMove3();                  
            case 3:
                a = this.getMove4();                   
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
        }
    }
}
