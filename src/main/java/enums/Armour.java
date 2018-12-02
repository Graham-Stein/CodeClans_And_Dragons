package enums;

import behaviours.ISell;

public enum Armour implements ISell {
    CHAINMAIL(5),
    PLATEMAIL(10),
    RINGMAIL(3),
    LEATHER(1);

    private final int value;

    Armour(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
