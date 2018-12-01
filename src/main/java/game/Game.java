package game;
import java.util.ArrayList;

public class Game {

    private Fellowship fellowship;
    private Adversaries adversaries;

    public Game(){
        this.fellowship = new Fellowship();
        this.adversaries = new Adversaries();
    }

    public void setAdversaries(Adversaries adversaries) {
        this.adversaries = adversaries;
    }

    public void setFellowship(Fellowship fellowship) {
        this.fellowship = fellowship;
    }

    public Adversaries getAdversaries() {
        return this.adversaries;
    }

    public Fellowship getFellowship() {
        return this.fellowship;
    }
}
