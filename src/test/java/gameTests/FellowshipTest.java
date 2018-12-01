package gameTests;

import characters.players.*;
import enums.Armour;
import enums.CreatureType;
import enums.Spell;
import enums.Weapon;
import game.Fellowship;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FellowshipTest {

    Fellowship fellowship;
    Barbarian barbarian;
    Cleric cleric;
    Dwarf dwarf;
    Knight knight;
    Creature creature;
    Warlock warlock;
    Creature creature2;
    Wizard wizard;

    @Before
    public void before(){
        barbarian = new Barbarian("Konan", 10, 8, 2, Armour.PLATEMAIL, Weapon.SWORD);
        cleric = new Cleric("Budda", 10, 4, 9);
        dwarf = new Dwarf("Thorin", 10, 9, 5, Armour.CHAINMAIL, Weapon.BATTLEAXE);
        knight = new Knight("Sir Robin", 10, 2, 9, Armour.PLATEMAIL, Weapon.SPEAR);
        creature = new Creature("Gollum", 10, 7, 9, CreatureType.MIDGIESWARM);
        warlock = new Warlock("Bob", 10, 4, 8, Spell.FROG, creature);
        creature2 = new Creature("Mighty Midge", 4, 2, 9, CreatureType.MIDGIE);
        wizard = new Wizard("Fred", 10, 5, 7, Spell.ITCHYNOSE, creature2);
        fellowship = new Fellowship();
    }


    @Test
    public void hasFellowship() {
        fellowship.addCharacter(barbarian);
        fellowship.addCharacter(cleric);
        fellowship.addCharacter(dwarf);
        fellowship.addCharacter(knight);
        fellowship.addCharacter(warlock);
        fellowship.addCharacter(wizard);
        assertEquals(6, fellowship.getFellowship().size());

    }

}
