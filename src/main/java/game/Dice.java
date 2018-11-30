package game;

public class Dice {

    public static int roll() {
        int roll = 0;
        roll = (int) ((Math.random() * 6) + 1);
        return roll;
    }
}
