package gameTests;

import characters.Character;
import characters.enemies.Dragon;
import characters.enemies.Minataur;
import characters.players.*;
import enums.Armour;
import enums.CreatureType;
import enums.Spell;
import enums.Weapon;
import game.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room;
    Game game;
    Adversaries adversaries;
    Minataur minataur;
    Creature creature;
    Dragon dragon;
    Cleric cleric;
    Barbarian barbarian;
    Dwarf dwarf;
    Knight knight;
    Warlock warlock;
    Creature creature2;
    Wizard wizard;
    Fellowship fellowship;
    Vendor vendor;


    @Before
    public void  before(){
        room = new Room("Cavern 1");
        minataur = new Minataur("Cretan Bull", 10, 10, 3, Armour.LEATHER, Weapon.WARHAMMER);
        creature = new Creature("Mighty Midge", 4, 2, 9, CreatureType.MIDGIE);
        dragon = new Dragon("Fred", 10, 5, 7, Spell.ITCHYNOSE, creature);
        barbarian = new Barbarian("Konan", 10, 8, 2, Armour.PLATEMAIL, Weapon.SWORD);
        cleric = new Cleric("Budda", 10, 4, 9);

        adversaries = new Adversaries();
        adversaries.addAdversary(minataur);
        adversaries.addAdversary(dragon);

        fellowship = new Fellowship();
        fellowship.addCharacter(barbarian);
        fellowship.addCharacter(cleric);

//        game.setEnemies(adversaries);
        vendor = new Vendor();
        vendor.changeStockLevel(Weapon.BATTLEAXE, 4);
        vendor.changeStockLevel(Spell.FROG, 3);
        vendor.changeStockLevel(Armour.CHAINMAIL, 5);
        game = new Game(fellowship, adversaries, vendor);
    }

    @Test
    public void hasRoomName(){
        assertEquals("Cavern 1", room.getName());
    }

    @Test
    public void canSetEnemy(){
        room.setEnemy(minataur);
        boolean result = room.getEnemy() instanceof Character;
        assertEquals(true, result);
        assertEquals(minataur, room.getEnemy());
    }

    @Test
    public void canSetVendor(){
        room.setVendor(vendor);
        int result = room.getVendor().getNumberOfItems();
        assertEquals(3, result);
    }
}
