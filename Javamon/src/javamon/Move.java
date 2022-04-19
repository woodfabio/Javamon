package javamon;
public class Move {
    protected String name;
    protected Type type;  // 1 = normal
                          // 2 = grass
                          // 3 = fire
                          // 4 = water
                          // 5 = electric
                          // 6 = poison
                          // 7 = flying
    private Integer power;
    private Integer pp;      // power points - each usage spends 1 pp
    protected Integer curPp; // current power points
    // constructor methods
    public Move() {  
        this.name = "-";
    }    
    public Move(String name, Type type, int power, int pp) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.pp = pp;
    }    
    // getter and setter methods
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getPp() {
        return pp;
    }
    public void setPp(int pp) {
        this.pp = pp;
    }
    public int getCurPp() {
        return pp;
    }
    public void setCurPp(int pp) {
        this.pp = pp;
    }
    
    // show method
    public void showMove() {
        System.out.println("(" + this.getType().name + ") " + this.getName());
        System.out.println("Power: " + this.power);
        System.out.println("Pp: " + this.curPp + "/" + this.pp);
    }
    
    // effectivenesse method
    public double effect(Pokemon def) {
        double eff = 1; // effectiveness
        double eff2 = 1;
        switch (this.type.id) { // move type
            case 1: // grass move
                switch (def.type1.id) {
                    case 1: // grass
                        if (def.type2.id != null) {
                            switch (def.type2.id) {
                                case 2: // fire
                                    eff2 = 2;
                                    break;
                                case 3: // water
                                    eff2 = 0.5;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 0.5/eff2;
                        break;
                    case 2:  // fire
                        if (def.type2.id != null) {
                            switch (def.type2.id) {
                                case 3: // water
                                    eff2 = 0.5;
                                    break;
                                case 4: // grass
                                    eff2 = 2;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 0.5/eff2;
                        break;
                    case 3:  // water
                        if (def.type2.id != null) {
                            switch (def.type2.id) {
                                case 1: // grass
                                    eff2 = 2;
                                    break;
                                case 2: // fire
                                    eff2 = 2;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 2/eff2;
                        break;
                }
                break;
            case 2: // fire move
                switch (def.type1.id) {
                    case 1:  // grass
                        if (def.type2.id != null) {
                            switch (def.type2.id) {
                                case 2: // fire
                                    eff2 = 2;
                                    break;
                                case 3: // water
                                    eff2 = 2;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 2/eff2;
                        break;
                    case 2:  // fire
                        if (def.type2.id != null) {
                        switch (def.type2.id) {
                                case 1: // grass
                                    eff2 = 0.5;
                                    break;
                                case 3: // water
                                    eff2 = 2;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 0.5/eff2;
                        break;
                    case 3: // water
                        if (def.type2.id != null) {
                            switch (def.type2.id) {
                                case 1: // grass
                                    eff2 = 0.5;
                                    break;
                                case 2: // fire
                                    eff2 = 2;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 0.5/eff2;
                        break;
                }
                break;
            case 3: // water move
                switch (def.type1.id) {
                    case 1:  // grass
                        if (def.type2.id != null) {
                            switch (def.type2.id) {
                                case 2: // fire
                                    eff2 = 0.5;
                                    break;
                                case 3: // water
                                    eff2 = 2;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 0.5/eff2;
                        break;
                    case 2:  // fire
                        if (def.type2.id != null) {
                            switch (def.type2.id) {
                                case 1: // grass
                                    eff2 = 2;
                                    break;
                                case 3: // water
                                    eff2 = 0.5;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 2/eff2;
                        break;
                    case 3: // water
                        if (def.type2.id != null) {
                            switch (def.type2.id) {
                                case 1: // grass
                                    eff2 = 2;
                                    break;
                                case 2: // fire
                                    eff2 = 0.5;
                                    break;
                                default:
                                    break;
                            }
                        }
                        eff = 0.5/eff2;
                        break;
                }
                break;
            // case move type == normal, eff remains == 1
        }
        return eff;
    }
}
