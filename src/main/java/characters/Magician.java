package characters;

import behaviours.ISell;
import characters.players.Creature;
import enums.Armour;
import enums.Spell;
import enums.Weapon;
import game.Vendor;

public abstract class Magician extends Character {

    private Spell spell;
    private Creature creature;

    public Magician(String name, int health, int strength, int intelligence, Spell spell, Creature creature){
        super(name, health, strength, intelligence);
        this.spell = spell;
        this.creature = creature;
    }

    public Spell getSpell() {
        return this.spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public Creature getCreature() {
        return this.creature;
    }

    public void buyItem(ISell item, Vendor vendor) {
//        if the item is instance of spell or creature and is in the vendor stock, sell the item to the Magician
//        reduce the stock by one and replace the Magician's spell or creature.
        boolean inStock = vendor.getShopStock(item) > 0;
        if (item instanceof Spell && inStock) {
            setSpell((Spell) item);
            vendor.changeStockLevel(item, -1);
        } else if (item instanceof Creature && inStock) {
            setCreature((Creature) item);
            vendor.changeStockLevel(item, -1);
        }
    }

    public int fightScore(int diceScore){
        return ((this.spell.getValue() * this.intelligence + (diceScore * 6))/13);
    }


}
