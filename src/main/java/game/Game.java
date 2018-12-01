package game;

public class Game {

    private Fellowship playerGroup;
    private Adversaries enemies;

    public Game(){
        this.playerGroup = new Fellowship();
        this.enemies = new Adversaries();
    }

    public void setEnemies(Adversaries adversaries) {
        this.enemies = adversaries;
    }

    public void setPlayerGroup(Fellowship fellowship) {
        this.playerGroup = fellowship;
    }

    public Adversaries getEnemies() {
        return this.enemies;
    }

    public Fellowship getPlayerGroup() {
        return this.playerGroup;
    }
}
