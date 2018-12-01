package gameTests;

import characters.enemies.Dragon;
import characters.enemies.Minataur;
import characters.players.Cleric;
import characters.players.Creature;
import enums.Armour;
import enums.CreatureType;
import enums.Spell;
import enums.Weapon;
import game.Adversaries;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdversariesTest {

    Adversaries adversaries;
    Minataur minataur;
    Creature creature;
    Dragon dragon;
    Cleric cleric;

    @Before
    public void before(){
            minataur = new Minataur("Cretan Bull", 10, 10, 3, Armour.LEATHER, Weapon.WARHAMMER);
            creature = new Creature("Mighty Midge", 4, 2, 9, CreatureType.MIDGIE);
            dragon = new Dragon("Fred", 10, 5, 7, Spell.ITCHYNOSE, creature);
            cleric = new Cleric("Budda", 10, 4, 9);
            adversaries = new Adversaries();

    }

    @Test
    public void adversariesStartsEmpty(){
        assertEquals(0, adversaries.getAdversaries().size());
    }

    @Test
    public void canAddAdversary(){
        adversaries.addAdversary(minataur);
        assertEquals(1, adversaries.getAdversaries().size());
    }
//
    @Test
    public void canAddMultipleAdversaries(){
        adversaries.addAdversary(minataur);
        adversaries.addAdversary(dragon);
        adversaries.addAdversary(cleric);
        assertEquals(3, adversaries.getAdversaries().size());
    }
}
