package game;

import characters.Character;
import enums.RoomType;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private Fellowship playerGroup;
    private Adversaries enemies;
    private ArrayList<Room> rooms;

    public Game(){
        this.playerGroup = new Fellowship();
        this.enemies = new Adversaries();
        this.rooms = new ArrayList<>();
        this.populateRooms();
    }

    private void populateRooms(){
        for (RoomType roomName : RoomType.values()) {
            Room room = new Room(roomName.getValue());
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

    public ArrayList<Room> getRooms(){
        return this.rooms;
    }


    //    Select one enemy object at random from the arrayList of enemies and removes it
    public Character getOpponent(){
        Collections.shuffle(this.enemies.getAdversaries());
        Character result = this.enemies.getAdversaries().get(0);
        this.enemies.getAdversaries().remove(result);
        return result;
    }

}
