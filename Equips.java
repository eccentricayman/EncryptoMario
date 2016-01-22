/* Equips is a java class that makes equippable items for characters */

import java.util.ArrayList;

public class Equips {
    
    public static final String[] equip_desc = {"Savage", "Smart","Fortunate","Fast"};
    public static final String[] typeList = {"Helm", "Armor", "Boots", "Amulet", "Ring"};
	public static final String[] equip_type = {"Power", "Intelligence", "Luck", "Speed"};
    private int[] effects = {0, 0, 0, 0};
    private String name;
    private String type;
    private int level;

    public Equips(int level) {
        this.level = level;
    	type = typeList[(int)(Math.random(4))];
    	int num = (int)(Math.random(3));
    	addStat(num,level);
    	name = equip_desc[num] + " " + type + " of ";
    	num = (int)(Math.random(3));
    	addStat(num,level);
    	name += equip_type[num];
    }
    
    public void addStat(int input, int level) {
        if (input == 0) {
    		effects[0] += 2*level;
    	}
    	if (input == 1) {
    		effects[1] += 2 * level;
    	}
    	if (input == 2) { 
    		effects[3] += 2 * level;
    	}
    	else effects[2] += 2 * level;

    	name = equip_desc[num] + " " + type + " of ";
    	num = (int)(Math.random(3));
    	if (input == 0) {
    		effects[0] += 2*level;
    	}
    	if (input == 1) {
    		effects[1] += 2 * level;
    	}
    	if (input == 2) { 
    		effects[3] += 2 * level;
    	}
    	else effects[2] += 2 * level;
    	
    	name += equip_type[num];
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public int[] getEstats() {
        return effects;
    }

    public String toString() {
        String retstr = name + " -- Level " + level + "\n";
        retstr += "Stats:\n";
        if (strength != 0) retstr += "Strength- " + strength + "\n";
        if (intelligence != 0) retstr += "Intelligence- " + intelligence + "\n";
        if (dexterity != 0) retstr += "Dexterity- " + dexterity + "\n";
        if (luck != 0) retstr += "Luck- " + luck + "\n";
    }
	
}
