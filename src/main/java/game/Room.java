package game;

import characters.Character;

public class Room {

    String name;
    Character enemy;
    Vendor vendor;

    public Room(String name){
        this.name = name;
        this.vendor = null;
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

    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    //    take in an instance of an enemy from Game
//    Character enemy;
//    and a fellowship arrayList<characters>

//

}
