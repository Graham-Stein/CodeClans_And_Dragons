package gameTests;

import characters.enemies.Minataur;
import characters.players.Barbarian;
import enums.Armour;
import enums.Weapon;
import game.Fight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FightTest {

    Fight fight;
    Barbarian barbarian;
    Minataur minataur;

    @Before
    public void before() {
        barbarian = new Barbarian("Konan", 10, 8, 2, Armour.PLATEMAIL, Weapon.SWORD);
        minataur = new Minataur("Cretan Bull", 10, 10, 3, Armour.LEATHER, Weapon.WARHAMMER);

    }

    @Test
    public void attackerCanDeductHealthFromDefender(){
        int health = minataur.getHealth();
        assertEquals(true, health == 10);
        fight = new Fight(barbarian, minataur);
        fight.attackerHitsDefender();
        int health2 = minataur.getHealth();
        assertEquals( true, health2 < 10);
    }

    @Test
    public void defenderCanDeductHealthFromAttacker(){
        int health = barbarian.getHealth();
        assertEquals(true, health == 10);
        fight = new Fight(barbarian, minataur);
        fight.defenderHitsAttacker();
        int health2 = barbarian.getHealth();
        assertEquals( true, health2 < 10);
    }

    @Test
    public void canHave2WayFight(){
        fight = new Fight(barbarian, minataur);
        int healthM = minataur.getHealth();
        assertEquals(true, healthM == 10);
        int healthB = barbarian.getHealth();
        assertEquals(true, healthB == 10);
        fight.engage();
        int healthM2 = minataur.getHealth();
        assertEquals( true, healthM2 < 10);
        int healthB2 = barbarian.getHealth();
        assertEquals( true, healthB2 < 10);
    }

}
