/* Equips is a java class that makes equippable items for characters */

import java.util.ArrayList;

public class Equips {
    
    public static final String[] equip_desc = {"Savage", "Smart","Fast","Fortunate"};
    public static final String[] typeList = {"Helm", "Armor", "Boots", "Amulet", "Ring"};
	public static final String[] equip_type = {"Power", "Intelligence", "Speed", "Luck"};
    private int[] effects = {0, 0, 0, 0};
    private String name;
    private String type;
    private int level;

    public Equips(int level) {
        this.level = level;
    	type = typeList[(int)(Math.random() * 5)];
    	int num = (int)(Math.random() * 4);
    	loadStat(num, level);
    	name = equip_desc[num] + " " + type + " of ";
    	num = (int)(Math.random() * 4);
    	loadStat(num, level);
    	name += equip_type[num];
    }
    
    public void loadStat(int input, int level) {
        if (input == 0) {
    		effects[0] += 2 * level;
    	}
    	else if (input == 1) {
    		effects[1] += 2 * level;
    	}
    	else if (input == 2) { 
    		effects[2] += 2 * level;
    	}
    	else effects[3] += 2 * level;
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

    public int getLevel() {
        return level;
    }
    
    public String toString() {
        String retstr = name + " -- Level " + level + "\n";
        retstr += "Stats:\n";
        if (effects[0] != 0) retstr += "Strength- " + effects[0] + "\n";
        if (effects[1] != 0) retstr += "Intelligence- " + effects[1] + "\n";
        if (effects[2] != 0) retstr += "Dexterity- " + effects[2] + "\n";
        if (effects[3] != 0) retstr += "Luck- " + effects[3] + "\n";
        return retstr;
    }
	
}
