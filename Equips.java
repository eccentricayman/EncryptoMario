/* Equips is a java class that makes */

import java.util.ArrayList;

public class Equips {
    
    public static final String[] equip_desc = {"Savage", "Smart","Fortunate","Fast"};
    public static final String[] typeList = {"Helm", "Armor", "Boots", "Amulet", "Ring"};
	public static final String[] equip_type = {"Power", "Intelligence", "Luck", "Speed"};
    private int[] effects = new int[4];
    private String name;
    private String type;
    private int strength = 0;
    private int intelligence = 0;
    private int dexterity = 0;
    private int luck = 0;
    private int level;

    public Equip(int level) {
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
    		strength += 2*level;
    	}
    	if (input == 1) {
    		intelligence += 2 * level;
    	}
    	if (input == 2) { 
    		luck += 2 * level;
    	}
    	else dexterity += 2 * level;
<<<<<<< HEAD:Game of Lyfe/Equips.java
    	name = equip_desc[num] + " " + type + " of ";
    	num = (int)(Math.random(3));
    	if (num == 0) {
    		strength += 2 * level;
    	}
    	if (num == 1) {
    		intelligence += 2 * level;
    	}
    	if (num == 2) {
			luck += 2 * level;
    	}
    	else  {
    		dexterity += 2 * level;
    	}
    	name += equip_type[num];
/*get rid of dis and comment stuff please
        name =  + " " + type + " of " + equip_type[(int)(Math.random(3))];
        this = level;
        if 
        */
=======
>>>>>>> ddce79a14e27b745e364f7dbfd6b246547c8a23b:Equips.java
    }
	
}
