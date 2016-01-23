/* Basic skeleton class for characters to implement */

import java.util.ArrayList;

public abstract class Character {
    
    //character stats
    protected String name;
    protected int strength;
    protected int intelligence;
    protected int dexterity;
    protected int luck;

    //character items
    protected Equips helm;
    protected Equips armor;
    protected Equips boots;
    protected Equips amulet;
    protected Equips ring;
    protected int coins;
    protected int stars;

    //character positions
    protected int x = 0;
    protected int y = 0;
        
    //roll
    protected int roll = -1;
    
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
    
    public String toString() {
        String retstr = new String();
        retstr += name;
        retstr += "Strength: " + strength;
        retstr += "Intelligence: " + intelligence;
        retstr += "Dexterity: " + dexterity;
        retstr += "Coins: " + coins;
        retstr += "Stars: " + stars;
        retstr += "Equips:";
        retstr += helm.toString();
        retstr += armor.toString();
        retstr += boots.toString();
        retstr += amulet.toString();
        retstr += ring.toString();
        return retstr;
    }
    
    public void addStats(Equips eq) {
        int[] effects = eq.getEstats();
        strength += effects[0];
        intelligence += effects[1];
        dexterity += effects[2];
        luck += effects[3];
    }
    
    public void minusStats(Equips eq) {
        int[] effects = eq.getEstats();
        strength -= effects[0];
        intelligence -= effects[1];
        dexterity -= effects[2];
        luck -= effects[3];
    }
    
    public abstract void move();
    
    public abstract void equip(Equips eq);
    
}
