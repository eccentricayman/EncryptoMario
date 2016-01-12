/* Basic skeleton class for characters to implement later */

import java.util.ArrayList;

public abstract class Character {
    
    private String name;
    private int strength;
    private int intelligence;
    private int dexterity;
    private ArrayList<Equip> items;
    private int[] pos = new int[2];
    
    public Character(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract move() {
        
    }
    
    public abstract showStats() {
        
    }
    
    public abstract
}
