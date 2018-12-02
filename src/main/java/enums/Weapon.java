package enums;

import behaviours.ISell;

public enum Weapon implements ISell {
    SWORD(6),
    BATTLEAXE(8),
    WARHAMMER(7),
    ARROWS(6),
    SLINGSHOT(2),
    SPEAR(9);

    private int value;

    Weapon(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
