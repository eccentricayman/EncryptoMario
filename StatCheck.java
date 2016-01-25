public class StatChange extends Position {
    
    public StatChange() {
        super("StatsChange");
    }
    
    public triggerEvent(Character Boy_X) {
        int chance = ((int)(Math.random()*8 )) + 1;
        int val = ((int)(Math.random()*10)) + 1;
        if (chance == 1) {
            System.out.println("System Voice: " + Boy_X.getName() + " has gained " + val + " in Strength." 
        }
        else if (chance == 2) {
            System.out.println("System Voice: " + Boy_X.getName() + " has gained " + val + " in Strength." 
        }
    }
}
