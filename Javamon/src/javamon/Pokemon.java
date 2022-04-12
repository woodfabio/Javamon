package javamon;
import java.util.Random;
public abstract class Pokemon implements Poke {
    // attributes
    protected String species;   // pokémon species
    protected String name;      // pokémon name
    protected Type type1;        // pokémon type 1
    protected Type type2;        // pokémon type 2
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
    // metodos temporarios
    public void setFainted(boolean f) {
        this.fainted = f;
    }
}
