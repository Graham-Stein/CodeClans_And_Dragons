package game;
import characters.Character;

public class Fight {

    Character attacker;
    Character defender;

    public Fight(Character attacker, Character defender){
        this.attacker = attacker;
        this.defender = defender;
    }

    public void engage(){
        this.attackerHitsDefender();
        this.defenderHitsAttacker();
    }

    private void attackerHitsDefender(){
        int fightScore = this.attacker.fightScore(Dice.roll());
        this.defender.setHealth(this.defender.getHealth() - fightScore);
    }

    private void defenderHitsAttacker(){
        int fightScore = this.defender.fightScore(Dice.roll());
        this.attacker.setHealth(this.attacker.getHealth() - fightScore);
    }

}
