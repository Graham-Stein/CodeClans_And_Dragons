package game;

import characters.Character;
import characters.Fighter;
import characters.Magician;
import enums.RoomType;
import game.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Game {

    private Fellowship playerGroup;
    private Adversaries enemies;
    private ArrayList<Room> rooms;

    public Game(Fellowship playerGroup, Adversaries enemies) {
        this.playerGroup = playerGroup;
        this.enemies = enemies;
        this.rooms = new ArrayList<>();
        this.populateRooms();
    }

    private void populateRooms() {
        for (RoomType roomName : RoomType.values()) {
            Room room = new Room(roomName.getValue());
            room.setEnemy(this.getOpponent());
            rooms.add(room);
        }
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

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    //    Select one enemy object at random from the arrayList of enemies and removes it
    public Character getOpponent() {
        Character result = null;
        if (this.enemies.getAdversaries().size() > 0) {
            Collections.shuffle(this.enemies.getAdversaries());
            result = this.enemies.getAdversaries().get(0);
            this.enemies.getAdversaries().remove(result);
        }
        return result;
    }

//    select the best player from Fellowship to fight on the basis of 1) most health then 2) compare best scores (cpmbat value?)
// for different cases of:
//  fighter: best strength * weapon value and magician intelligence * spell value
//    return the Character

    public Character selectBestCombatCharacter() {
        ArrayList<Character> healthiestPlayers = new ArrayList<>();
        healthiestPlayers = getHealthiestPlayers();
        ArrayList<Character> strongestForCombat = new ArrayList<>();
        int maxCombatValue = 0;
            for (Character character : healthiestPlayers){
                if (getCombatValue(character) > maxCombatValue)
                maxCombatValue = getCombatValue(character);
            }
        for (Character character : healthiestPlayers){
            if (getCombatValue(character) == maxCombatValue)
                strongestForCombat.add(character);
        }
            return strongestForCombat.get(0);
        }


    private ArrayList<Character> getHealthiestPlayers(){
        ArrayList<Character> healthiestPlayers = new ArrayList<>();
        int maxValue = 0;
        for (Character character : this.playerGroup.getFellowship()) {
            if (character.getHealth() > maxValue){
                maxValue = character.getHealth();
            }
        }
        for (Character character : this.playerGroup.getFellowship()){
            if (character.getHealth() == maxValue){
                healthiestPlayers.add(character);
            }
        }
        return healthiestPlayers;
    }

    private int getCombatValue(Character character){
    int combatValue = 0;
        if (character instanceof Fighter){
            combatValue = character.getStrength() * ((Fighter) character).getWeapon().getValue();
        }
        if (character instanceof Magician){
            combatValue = character.getIntelligence() * ((Magician) character).getSpell().getValue();
        } else {
            combatValue = character.getStrength();
        }
    return combatValue;
    }


}
