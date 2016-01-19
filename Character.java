/* Basic skeleton class for characters to implement */

import java.util.ArrayList;

public abstract class Character {
    
    //character stats
    private String name;
    private int strength;
    private int intelligence;
    private int dexterity;
    private int luck;

    //character items
    private Equips helm;
    private Equips armor;
    private Equips boots;
    private Equips amulet;
    private Equips ring;
    private int coins;
    private int keys;
    private int stars;

    //character positions
    //private int x = 0;
    //private int y = 0;
    //perhaps we should use this instead?
    private Position currentpos;
    
    //roll
    private int roll = -1;
    
    public Character(String name) {
        this.name = name;
    }
    
    public Character(String name, int str, int Int, int dex, int luk) {
        this.name = name;
        strength = str;
        intelligence = Int;
        dexterity = dex;
        luck = luk;
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
        return dexterity;
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
        currentpos.getX();
    }

    public int getY() {
        currentpos.getY();
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
    
    public void c2K() {
    	if(coins >= 10) {
    		coins-=10;
    		keys+=1;
    	}
    	else System.out.println("u broke boi, get more coins...");
    }
    
    public String toString() {
        String retstr = new String();
        retstr += name;
        retstr += "Strength: " + strength;
        retstr += "Intelligence: " + intelligence;
        retstr += "Dexterity: " + dexterity;
        retstr += "Coins: " + coins;
        retstr += "Keys: " + keys;
        retstr += "Stars: " + stars;
        retstr += "Equips:";
        for (int i = 0 ; i < items.size() ; i++) {
            retstr += items.get(i).toString();
        }
        return retstr;
    }
    
    public abstract void move();
    
    public abstract void equip();
    
}
