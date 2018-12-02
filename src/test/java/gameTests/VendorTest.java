package gameTests;

import enums.Armour;
import enums.Spell;
import enums.Weapon;
import game.Vendor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendorTest {

    Vendor vendor;

    @Before
    public void before(){
        vendor = new Vendor();
    }

    @Test
    public void hasEmptyHashMap(){
        assertEquals(0, vendor.getNumberOfItems());
    }

    @Test
    public void canAddWeapon(){
        vendor.changeStockLevel(Weapon.BATTLEAXE, 4);
        assertEquals(1, vendor.getNumberOfItems());
        assertEquals(4, vendor.getShopStock(Weapon.BATTLEAXE));
    }

    @Test
    public void canAddSpell(){
        vendor.changeStockLevel(Spell.FROG, 3);
        assertEquals(1, vendor.getNumberOfItems());
        assertEquals(3, vendor.getShopStock(Spell.FROG));
    }

    @Test
    public void canAddWeaponsAndSpellsAndArmour(){
        vendor.changeStockLevel(Weapon.BATTLEAXE, 4);
        vendor.changeStockLevel(Spell.FROG, 3);
        vendor.changeStockLevel(Armour.CHAINMAIL, 5);
        assertEquals(3, vendor.getNumberOfItems());
        assertEquals(3, vendor.getShopStock(Spell.FROG));
        assertEquals(4, vendor.getShopStock(Weapon.BATTLEAXE));
        assertEquals(5, vendor.getShopStock(Armour.CHAINMAIL));
    }

    @Test
    public void canIncreaseStockOfExistingItems(){
        vendor.changeStockLevel(Spell.FROG, 3);
        vendor.changeStockLevel(Spell.FROG, 2);
        assertEquals(1, vendor.getNumberOfItems());
        assertEquals(5, vendor.getShopStock(Spell.FROG));
    }

    @Test
    public void canReduceStockOfExistingItems(){
        vendor.changeStockLevel(Spell.FROG, 3);
        vendor.changeStockLevel(Spell.FROG, -2);
        assertEquals(1, vendor.getNumberOfItems());
        assertEquals(1, vendor.getShopStock(Spell.FROG));
    }
}
