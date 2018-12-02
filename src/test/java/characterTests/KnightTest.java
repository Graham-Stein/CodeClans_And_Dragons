package characterTests;

import characters.players.Knight;
import enums.Armour;
import enums.Spell;
import enums.Weapon;
import game.Vendor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Knight knight;
    Vendor vendor;

    @Before
    public void before(){
        knight = new Knight("Sir Robin", 10, 2, 9, Armour.PLATEMAIL, Weapon.SPEAR);
        vendor = new Vendor();
        vendor.changeStockLevel(Weapon.BATTLEAXE, 4);
        vendor.changeStockLevel(Spell.FROG, 3);
        vendor.changeStockLevel(Armour.CHAINMAIL, 5);
    }

    @Test
    public void hasName(){
        assertEquals("Sir Robin", knight.getName());
    }

    @Test
    public void hasHealth(){
        assertEquals(10, knight.getHealth());
    }

    @Test
    public void hasStrength(){
        assertEquals(2, knight.getStrength());
    }

    @Test
    public void hasIntelligence(){
        assertEquals(9, knight.getIntelligence());
    }

    @Test
    public void hasArmour(){
        assertEquals(Armour.PLATEMAIL, knight.getArmour());
    }

    @Test
    public void hasWeapon(){
        assertEquals(Weapon.SPEAR, knight.getWeapon());
    }

    @Test
    public void canFightReturningDamageValue(){
        assertEquals(2, knight.fightScore(2));
    }

    @Test
    public void canBuyWeaponFromVendor(){
        knight.buyItem(Weapon.BATTLEAXE, vendor);
        assertEquals(Weapon.BATTLEAXE, knight.getWeapon());
    }

    @Test
    public void willNotSellSpellFromVendor(){
        knight.buyItem(Spell.ITCHYNOSE, vendor);
        assertEquals(Weapon.SPEAR, knight.getWeapon());
    }

}
