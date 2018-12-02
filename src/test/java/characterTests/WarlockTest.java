package characterTests;

import characters.players.Creature;
import characters.players.Warlock;
import enums.Armour;
import enums.CreatureType;
import enums.Spell;
import enums.Weapon;
import game.Vendor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarlockTest {

    Warlock warlock;
    Creature creature;
    Spell spell;
    Vendor vendor;

    @Before
    public void before(){
        creature = new Creature("Gollum", 10, 7, 9, CreatureType.MIDGIESWARM);
        warlock = new Warlock("Bob", 10, 4, 8, Spell.FROG, creature);
        vendor = new Vendor();
        vendor.changeStockLevel(Weapon.BATTLEAXE, 4);
        vendor.changeStockLevel(Spell.FROG, 3);
        vendor.changeStockLevel(Armour.CHAINMAIL, 5);
    }

    @Test
    public void hasName(){
        assertEquals("Bob", warlock.getName());
    }

    @Test
    public void hasHealth(){
        assertEquals(10, warlock.getHealth());
    }

    @Test
    public void hasStrength(){
        assertEquals(4, warlock.getStrength());
    }

    @Test
    public void hasIntelligence(){
        assertEquals(8, warlock.getIntelligence());
    }

    @Test
    public void hasSpell(){
        assertEquals(Spell.FROG, warlock.getSpell());
    }

    @Test
    public void hasCreature(){
        assertEquals(creature, warlock.getCreature());
    }


    @Test
    public void canFightReturningDamageValue(){
        assertEquals(8, warlock.fightScore(4));
    }

    @Test
    public void canBuySpellFromVendor(){
        warlock.buyItem(Spell.FROG, vendor);
        assertEquals(Spell.FROG, warlock.getSpell());
    }
}
