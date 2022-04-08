package javamon;
public class Bulbasaur extends Pokemon {
    // constructor method
    public Bulbasaur(String name) {
        this.setName(name);
        this.setSpecies("Bulbasaur");
        // type 1
        Type type1 = new Type("Grass",2);
        this.setType1(type1);
        // type 2
        Type type2 = new Type("Poison",6);
        this.setType2(type2);
        // status
        this.setHp(45);
        this.setCurhp(this.getHp());
        this.setAtk(65);
        this.setDef(49);
        this.setSpe(45);
        // move 1
        Move move1 = new Move("Tackle",0,40,35);
        this.setMove1(move1);
        // move 2
        Move move2 = new Move("VineWhip",1,45,25);
        this.setMove2(move2);
        // move 3
        Move move3 = new Move("-",0,0,0);
        this.setMove3(move3);
        // move 4
        Move move4 = new Move("-",0,0,0);
        this.setMove4(move4);           
    }
    
}
