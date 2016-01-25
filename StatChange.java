public class StatChange extends Position {
    
    public StatChange() {
        super("StatsChange");
    }
    
    public void triggerEvent(Character Boy_X) {
        int chance = ((int)(Math.random()*8 )) + 1;
        int val = ((int)(Math.random()*5)) + 1;
        if (chance == 1) {
            System.out.println("An armadillo appears. The armadillo flees.");
            System.out.println("System Voice: " + Boy_X.getName() + " has gained " + val + " in Strength."); 
            Boy_X.addStrength(val);
        }
        else if (chance == 2) {
            System.out.println("It starts hailing.");
            System.out.println("System Voice: " + Boy_X.getName() + " has gained " + val + " in Defense.");
            Boy_X.addDefense(val);
        }
        else if (chance == 3) {
            System.out.println("A jackal chases you through the forest. You escape.");
            System.out.println("System Voice: " + Boy_X.getName() + " has gained " + val + " in Dexterity."); 
            Boy_X.addDexterity(val);
        }
        else if (chance == 4) {
            System.out.println("Nothing happens.");
            System.out.println("System Voice: " + Boy_X.getName() + " has gained " + val + " in Luck."); 
            Boy_X.addLuck(val);
        }
        else if (chance == 5) {
            System.out.println("An armadillo appears. The armadillo runs you over.");
            System.out.println("System Voice: " + Boy_X.getName() + " has lost " + val + " in Strength."); 
            Boy_X.addStrength(-1 * val);
        }
        else if (chance == 6) {
            System.out.println("It starts raining trees.");
            System.out.println("System Voice: " + Boy_X.getName() + " has lost " + val + " in Defense."); 
            Boy_X.addDefense(-1 * val);
        }
        else if (chance == 7) {
            System.out.println("A jackal chases you through the forest. You escape. Two jackals appear. Yeah really.");
            System.out.println("System Voice: " + Boy_X.getName() + " has lost " + val + " in Dexterity."); 
            Boy_X.addDexterity(-1 * val);
        }
        else if (chance == 8) {
            System.out.println("Nothing happen- a three-headed dog from hell appeared.");
            System.out.println("System Voice: " + Boy_X.getName() + " has lost " + val + " in Luck."); 
            Boy_X.addLuck(-1 * val);
        }
    }
}
