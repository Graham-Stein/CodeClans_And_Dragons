package game;

import characters.Character;

public class Room {

    String name;
    Character enemy;

    public Room(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEnemy(Character enemy){
        this.enemy = enemy;
    }

    public Character getEnemy (){
        return this.enemy;
    }

    //    take in an instance of an enemy from Game
//    Character enemy;
//    and a fellowship arrayList<characters>

//

}
