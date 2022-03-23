package javamon;
import java.util.Random;
public class Pokemon {
    // attributes
    protected String species;   // pokémon species
    protected String name;      // pokémon name
    protected int type1;        // pokémon type 1
    protected int type2;        // pokémon type 2
                                    // 0 = normal
                                    // 1 = grass
                                    // 2 = fire
                                    // 3 = water
                                    // 4 = electric
                                    // 5 = poison
                                    // 6 = flying
    protected int xp;           // experience
    protected int hp;           // maximum health points
    protected int curhp;        // current health points
    protected boolean fainted;  // if fainted, it's unable to battle
    protected int atk;          // attack
    protected int def;          // defense
    protected int spe;          // speed
    protected boolean npc;      // true if the pokémon is an NPC
    protected Move m1;          // first move
    protected Move m2;          // second move
    protected Move m3;          // third move
    protected Move m4;          // fourth move
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
    protected int getType1() {
        return this.type1;
    }
    protected void setType1(int t) {
        this.type1 = t;
    }
    protected int getType2() {
        return this.type2;
    }
    protected void setType2(int t) {
        this.type2 = t;
    }
    protected int getXp() {
        return this.xp;
    }
    protected void setXp(int xp) {
        this.xp = xp;
    }
    protected int getHp() {
        return this.hp;
    }
    protected void setHp(int hp) {
        this.hp = hp;
    }
    protected int getCurhp() {
        return this.curhp;
    }
    protected void setCurhp(int curhp) {
        this.curhp = curhp;
    }
    protected int getAtk() {
        return this.atk;
    }
    protected void setAtk(int atk) {
        this.atk = atk;
    }
    protected int getDef() {
        return this.def;
    }
    protected void setDef(int def) {
        this.def = def;
    }
    protected int getSpe() {
        return this.spe;
    }
    public boolean isNpc() {
        return this.npc;
    }  
    public void setNpc(boolean npc) {
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
    // public methods for showing attributes
    public void showSpecies() {
        System.out.println(this.species);
    }
    public void showName() {
        System.out.println(this.getName());
    }
    public void showType1() {
        System.out.println(this.getType1());
    }
    public void showType2() {
        System.out.println(this.getType2());
    }
    public void showXp() {
        System.out.println(this.getXp());
    }    
    public void showHp() {
        System.out.println(this.getHp());
    }    
    public void showCurHp() {
        System.out.println(this.getCurhp());
    }    
    public void showAtk() {
        System.out.println(this.getAtk());
    }
    public void showDef() {
        System.out.println(this.getDef());
    }    
    public void showSpe() {
        System.out.println(this.getSpe());
    }    
    public void showMoves() {
        System.out.println(this.m1.getName());
        System.out.println(this.m2.getName());
        System.out.println(this.m3.getName());
        System.out.println(this.m4.getName());
    }
    // metodos temporarios
    public void setFainted(boolean f) {
        this.fainted = f;
    }
}
