package game;
import characters.Character;
import java.util.ArrayList;
public class Adversaries {

    private ArrayList<Character> adversaries;

    public Adversaries(){
        this.adversaries = new ArrayList<>();
    }

    public void setAdversaries(ArrayList<Character> adversaries) {
        this.adversaries = adversaries;
    }

    public ArrayList<Character> getAdversaries() {
        return this.adversaries;
    }

    public void addAdversary(Character adversary){
        this.adversaries.add(adversary);
    }

}
