package gameTests;

import game.Dice;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class DiceTest {

    @Test
    public void canRollDice() {
        assertEquals(1, Dice.roll());
    }
}
