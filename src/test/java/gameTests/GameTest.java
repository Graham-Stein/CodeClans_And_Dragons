package gameTests;

import characters.Character;
import characters.enemies.Dragon;
import characters.enemies.Minataur;
import characters.players.*;
import enums.Armour;
import enums.CreatureType;
import enums.Spell;
import enums.Weapon;
import game.Adversaries;
import game.Fellowship;
import game.Game;
import game.Vendor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Adversaries adversaries;
    Minataur minataur;
    Minataur minataur1;
    Minataur minataur2;
    Minataur minataur3;
    Minataur minataur4;
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
    public void before(){
        minataur = new Minataur("Cretan Bull", 10, 10, 3, Armour.LEATHER, Weapon.WARHAMMER);
        minataur1 = new Minataur("Fred", 10, 10, 3, Armour.CHAINMAIL, Weapon.BATTLEAXE);
        minataur2 = new Minataur("Rodger", 10, 10, 2, Armour.RINGMAIL, Weapon.SLINGSHOT);
        minataur3 = new Minataur("Crusty", 10, 10, 3, Armour.LEATHER, Weapon.SPEAR);
        minataur4 = new Minataur("Flipper", 10, 10, 3, Armour.LEATHER, Weapon.SPEAR);
        creature = new Creature("Mighty Midge", 4, 2, 9, CreatureType.MIDGIE);
        dragon = new Dragon("Fred", 10, 5, 7, Spell.ITCHYNOSE, creature);
        cleric = new Cleric("Budda", 10, 4, 9);

        barbarian = new Barbarian("Konan", 10, 8, 2, Armour.PLATEMAIL, Weapon.SWORD);
        cleric = new Cleric("Budda", 10, 4, 9);
        dwarf = new Dwarf("Thorin", 10, 9, 5, Armour.CHAINMAIL, Weapon.BATTLEAXE);
        knight = new Knight("Sir Robin", 10, 2, 9, Armour.PLATEMAIL, Weapon.SPEAR);
        creature = new Creature("Gollum", 10, 7, 9, CreatureType.MIDGIESWARM);
        warlock = new Warlock("Bob", 10, 4, 8, Spell.FROG, creature);
        creature2 = new Creature("Mighty Midge", 4, 2, 9, CreatureType.MIDGIE);
        wizard = new Wizard("Fred", 10, 5, 7, Spell.ITCHYNOSE, creature2);


        adversaries = new Adversaries();
        adversaries.addAdversary(minataur);
        adversaries.addAdversary(minataur1);
        adversaries.addAdversary(minataur2);
        adversaries.addAdversary(minataur3);
        adversaries.addAdversary(minataur4);
        adversaries.addAdversary(dragon);

        fellowship = new Fellowship();
        fellowship.addCharacter(barbarian);
        fellowship.addCharacter(cleric);
        fellowship.addCharacter(dwarf);
        fellowship.addCharacter(knight);
        fellowship.addCharacter(warlock);
        fellowship.addCharacter(wizard);

        vendor = new Vendor();
        vendor.changeStockLevel(Weapon.BATTLEAXE, 4);
        vendor.changeStockLevel(Spell.FROG, 3);
        vendor.changeStockLevel(Armour.CHAINMAIL, 5);

        game = new Game(fellowship, adversaries, vendor);
    }

    @Test
    public void hasAdversaries(){
        int result = game.getEnemies().getAdversaries().size();
        assertEquals(2,  result);
    }

    @Test
    public void hasFellowship(){
        int result = game.getPlayerGroup().getFellowship().size();
        assertEquals(6, result);
    }

    @Test
    public void returnsAndRemovesCharacterFromEnemiesArrayList(){
        assertEquals(2, game.getEnemies().getAdversaries().size());
        boolean result = game.getOpponent() instanceof Character;
        assertEquals(true, result);
    }

    @Test
    public void canCreateRoomList(){
        assertEquals(4, game.getRooms().size());
    }

    @Test
    public void canGetBestFightPlayer(){
        Character selected = game.selectBestCombatCharacter();
        boolean result = selected instanceof Character;
        assertEquals(true, result);
    }
}
