package enums;

import behaviours.ISell;

public enum Spell implements ISell {
    FIREBALL(6),
    LIGHTNIGHT(4),
    FROG(10),
    ITCHYNOSE(1);

    private int value;

    Spell(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
