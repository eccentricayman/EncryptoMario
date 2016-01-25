public class Chest extends Position {
    
    public static final String[] types = {"Strength", "Intelligence","Dexterity"};
    private String type;
    private int req;
    private boolean full;
    private Equips treasure;
    
    public Chest(int Phase) {
        super("Chest");
        type = types[(int)(Math.random() * 3)];
        req = (int)(Phase*5 + Math.random()*Phase*2);
        treasure = new Equips(Phase);
        full = true;
    }
    
    public boolean isFull() {
        return full;
    }
    
    public void triggerEvent(Character Boy_X) {
        if (full) {
            boolean pass = true;
            
            if (type == "Strength") pass = Boy_X.getStrength() >= req;
            else if (type == "Intelligence") pass = Boy_X.getIntelligence() >= req;
            else if (type == "Dexterity") pass = Boy_X.getDexterity() >= req;
            
            System.out.println("StatCheck: " + type + " " + req);
            
            if (pass) {
                if (Boy_X.getCoins() >= 20) {
                    System.out.println(Boy_X.getName() + " obtained an equip in exchange for 20 coins.");
                    Boy_X.addCoins(-20);
                    Boy_X.equip(treasure);
                }
                else {
                    System.out.println(Boy_X.getName() + " does not have 20 coins.\nStat requirement lowered by 15%.");
                    req = (int)(.15 * req);
                }
            }
            else {
                System.out.println(Boy_X.getName() + " does not meet the Stat requirement.\nStat requirement lowered by 15%.");
                req = (int)(.15 * req);
            }
        }
        else {
            System.out.println("This chest has been looted! " + Boy_X.getName() + " gained 8 coins instead.");
            Boy_X.addCoins(8);
        }
    }
    
}