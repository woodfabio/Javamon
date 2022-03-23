package javamon;
public class Bulbasaur extends Pokemon {
    // constructor method
    public Bulbasaur(String name) {
        this.setName(name);
        this.setSpecies("Bulbasaur");
        this.setType1(1);
        this.setType2(5);
        this.setHp(45);
        this.setAtk(65);
        this.setDef(49);
        this.setSpe(45);
        // move 1
        Move move1 = new Move();
        move1.defineMove("Tackle",0,40,35);
        this.setMove1(move1);
        // move 2
        Move move2 = new Move();
        move2.defineMove("VineWhip",1,45,25);
        this.setMove2(move2);
        // move 3
        Move move3 = new Move();
        move3.defineMove("VineWhip",1,45,25);
        this.setMove3(move3);
        // move 4
        Move move4 = new Move();
        move4.defineMove("VineWhip",1,45,25);
        this.setMove4(move4);           
    }
    
}
