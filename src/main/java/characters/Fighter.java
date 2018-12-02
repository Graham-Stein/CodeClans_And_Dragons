package characters;

import behaviours.ISell;
import enums.Armour;
import enums.Weapon;
import game.Vendor;

public abstract class Fighter extends Character{

    protected Armour armour;
    protected Weapon weapon;

    public Fighter(String name, int health, int strength, int intelligence, Armour armour, Weapon weapon){
        super(name, health, strength, intelligence);
        this.armour = armour;
        this.weapon = weapon;
    }

    public int fightScore(int diceScore) {
        return ((this.weapon.getValue() * this.strength + (diceScore * 6))/13);
    }

    public void buyItem(ISell item, Vendor vendor) {
//        if the item is instance of armour or weapon and is in the vendor stock, sell the item to the Fighter
//        reduce the stock by one and replace the fighter's weapon or armour.
        boolean inStock = vendor.getShopStock(item) > 0;
        if (item instanceof Armour && inStock) {
            setArmour((Armour) item);
            vendor.changeStockLevel(item, -1);
        } else if (item instanceof Weapon && inStock) {
            setWeapon((Weapon) item);
            vendor.changeStockLevel(item, -1);
        }
    }

    public Armour getArmour() {
        return this.armour;
    }

    private void setArmour(Armour armour){
        this.armour = armour;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    private void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
}


