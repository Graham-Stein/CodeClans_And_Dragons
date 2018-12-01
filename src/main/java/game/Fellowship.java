package game;

import characters.Character;

import java.util.ArrayList;

public class Fellowship {

    private ArrayList<Character> fellowship;

    public Fellowship(){
        this.fellowship = new ArrayList<>();
    }

    public void addCharacter(Character player){
        this.fellowship.add(player);
    }

    public ArrayList<Character> getFellowship(){
        return this.fellowship;
    }
}
