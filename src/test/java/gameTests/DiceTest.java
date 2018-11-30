package gameTests;

import game.Dice;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class DiceTest {

    @Test
    public void canRollDice() {
        Integer roll = Dice.roll();
        boolean test = roll instanceof Integer;
        assertEquals( true, test);
        assertEquals(true, roll > 0);
        assertEquals(true, roll <= 6);
    }
}
