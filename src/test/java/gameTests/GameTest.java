package gameTests;

import characters.enemies.Dragon;
import characters.enemies.Minataur;
import characters.players.*;
import enums.Armour;
import enums.CreatureType;
import enums.Spell;
import enums.Weapon;
import game.Adversaries;
import game.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

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

    @Before
    public void before(){
        minataur = new Minataur("Cretan Bull", 10, 10, 3, Armour.LEATHER, Weapon.WARHAMMER);
        creature = new Creature("Mighty Midge", 4, 2, 9, CreatureType.MIDGIE);
        dragon = new Dragon("Fred", 10, 5, 7, Spell.ITCHYNOSE, creature);
        cleric = new Cleric("Budda", 10, 4, 9);
        adversaries = new Adversaries();
        adversaries.addAdversary(minataur);
        adversaries.addAdversary(dragon);
        barbarian = new Barbarian("Konan", 10, 8, 2, Armour.PLATEMAIL, Weapon.SWORD);
        cleric = new Cleric("Budda", 10, 4, 9);
        dwarf = new Dwarf("Thorin", 10, 9, 5, Armour.CHAINMAIL, Weapon.BATTLEAXE);
        knight = new Knight("Sir Robin", 10, 2, 9, Armour.PLATEMAIL, Weapon.SPEAR);
        creature = new Creature("Gollum", 10, 7, 9, CreatureType.MIDGIESWARM);
        warlock = new Warlock("Bob", 10, 4, 8, Spell.FROG, creature);
        creature2 = new Creature("Mighty Midge", 4, 2, 9, CreatureType.MIDGIE);
        wizard = new Wizard("Fred", 10, 5, 7, Spell.ITCHYNOSE, creature2);
        game = new Game();
    }

    @Test
    public void hasAdversaries(){
        game.setAdversaries(adversaries);
        Adversaries result = game.getAdversaries();
        int result2 = result.getAdversaries().size();
        assertEquals(2,  result2);
    }
}
