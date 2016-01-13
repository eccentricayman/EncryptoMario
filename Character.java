/* Basic skeleton class for characters to implement later */

import java.util.ArrayList;

public abstract class Character {
    
    //character stats
    private String name;
    private int strength;
    private int intelligence;
    private int dexterity;
    private int luck;

    //character items
    private ArrayList<Equip> items;
    private int coins;
    private int keys;
    private int stars;

    //character positions
    private int x = 0;
    private int y = 0;
    
    //roll
    private int roll = -1;
    
    public Character(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getStrength() {
        return strength;
    }
    
    public int getIntelligence() {
        return intelligence;
    }
    
    public int getDexterity() {
        return dexterity
    }
    
    public int getLuck() {
        return luck;
    }
    
    public int getCoins() {
        return coins;
    }
    
    public int getKeys() {
        return keys;
    }
    
    public int getStars() {
        return stars;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
        

    public void addCoins(int toadd) {
        if (coins + toadd > 0) {
            coins += toadd;
        }
        else {
            coins = 0;
        }
    }
    
    public void addKeys(int toadd) {
        if (keys + toadd > 0) {
            keys += toadd;
        }
        else {
            keys = 0;
        }
    }
    
    public void addStars(int toadd) {
        if (stars + toadd > 0) {
            stars += toadd;
        }
        else {
            stars = 0;
        }
    }
    
    public void roll() {
    	
    }
    
    public abstract void move();
    
    public abstract void showStats();
    
    public abstract void equip();
    
}
