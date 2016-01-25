/* Position is a class that manages a single position on the map */

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Position {
    
    private Character challenger;
    private Character defender;
    //challenger's stats
    private int chealth;
    //defender's stats
    private int dhealth;
    private boolean time = false;;
    
    private ArrayList<Character> characters;
    //replaced eventnum with object event, will do instanceof event
    private String eventName;
    
    public Position(String eName) {
        eventName = eName;
        characters = new ArrayList<Character>();
    }
    
    public void addCharacter(Character toadd) {
        characters.add(toadd);
    }
    
    public void addCharacterB(Character toadd) throws InterruptedException, Exception{
        characters.add(toadd);
        if (time) {
            if(characters.size() > 1) {
                System.out.println("Would you like to challenge " + characters.get(0).getName() + "?");
                if (toadd.getPlaya()) {
                    Scanner ui = new Scanner(System.in);
                    System.out.println("BattleTIME!: Enter 1(Yes) or 2(No).");
                    String input = ui.next();
                    while (! (input.equals("1") || input.equals("2")) ) {
                        System.out.println("Enter 1(Yes) or 2(No).");
                        input = ui.next();
                    }
                    if(input.equals("1")) {
                        startBattle(toadd, characters.get(0));
                    }
                    else System.out.println("System Voice: Battle chance has been denied.");
                }
                else {
                    if ((int)(Math.random()*2) == 0) startBattle(toadd, characters.get(0));
                    else System.out.println("System Voice: Battle chance has been denied.");
                }
            }
        }
    }

    public void clearCharacter(Character Boy_X) {
        characters.remove(characters.indexOf(Boy_X));
    }
    
    public String getEName() {
        return eventName;
    }
    
    public void setTime() {
        time = true;
    }
    
    public abstract void triggerEvent(Character Boy_X) throws Exception;
    
    public String look(Character Boy_X) {
        if (characters.contains(Boy_X)) {
            if (Boy_X.getPlaya()) return "[" + Boy_X.getName().substring(0,1) +"]";
            else {
                if(Boy_X.getName().equals("Weiss")) return "[W]";
                else if (Boy_X.getName().equals("Zatch")) return "[Z]";
                else return "[S]";
            }
        }
        else return "[ ]";
    }
    
    private void startBattle(Character a, Character b) throws InterruptedException, Exception{
        challenger = a;
        defender = b;
        chealth = a.getStrength() + a.getDefense() + a.getDexterity() + a.getLuck();
        dhealth = b.getStrength() + b.getDefense() + b.getDexterity() + b.getLuck();
        challenger.addCoins(-1 * challenger.getCoins() / 10);
        toBattle();
    }
    
    private String cdamage() {
        String retstr = "";
        int crit = (int)(Math.random() * 9);
        //10% chance to crit
        if (crit != 0) {
            int damage = challenger.getStrength() * (challenger.getDexterity() / 2);
            dhealth -= damage;
            retstr += challenger.getName() + " critted for " + damage + "!";
        }
        else {
            int damage = challenger.getStrength();
            dhealth -= damage;
            retstr += challenger.getName() + " dealt " + damage + "."; 
        }
        return retstr;
    }

    private String ddefend() {
        //should only be used after cdamage()
        String retstr = "";
        int defend = defender.getDefense() / 2;
        dhealth += defend;
        retstr += defender.getName() + " blocked " + defend + " damage.";
        return retstr;
    }

    private String ddamage() {
        String retstr = "";
        int crit = (int)(Math.random() * 9);
        if (crit != 0) {
            int damage = defender.getStrength() * (defender.getDexterity() / 2);
            chealth -= damage;
            retstr += defender.getName() + " critted for " + damage + "!";
        }
        else {
            int damage = defender.getStrength();
            dhealth -= damage;
            retstr += defender.getName() + " dealt " + damage + ".";
        }
        return retstr;
    }

    private String cdefend() {
        //should only be used after ddamage()
        String retstr = "";
        int defend = challenger.getDefense() / 2;
        dhealth += defend;
        retstr += challenger.getName() + " blocked " + defend + " damage.";
        return retstr;
    }
    
    public void toBattle() throws InterruptedException, Exception {
        String progress = "|/-\\";
        int ctr = 0;
        while (chealth > 0 && dhealth > 0) {
            System.out.print("\r" + progress.charAt(ctr % progress.length()) + ddamage());
            ctr ++;
            Thread.sleep(200);
            System.out.print("\r" + progress.charAt(ctr % progress.length()) + cdefend());
            ctr ++;
            Thread.sleep(200);
            System.out.print("\r" + progress.charAt(ctr % progress.length()) + cdamage());
            ctr ++;
            Thread.sleep(200);
            System.out.print("\r" + progress.charAt(ctr % progress.length()) + ddefend());
            ctr ++;
        }
        if (chealth <= 0) {
            System.out.println("\n" + defender.getName() + " is the winner!");
            if (challenger.getStars() - 1 >= 0) {
                defender.addStars(1);
                challenger.addStars(-1);
                System.out.println(defender.getName() + " gained 1 star and "+ challenger.getName() + " lost one star.");
            }
            challenger.addStrength(defender.getStrength() / 4);
            challenger.addDefense(defender.getDefense() / 4);
            challenger.addDexterity(defender.getDexterity() / 4);
            challenger.addLuck(defender.getLuck() / 4);
            System.out.println(challenger.getName() + " got stronger!");
            System.in.read();
        }
        //no chance there's a tie
        else {
            System.out.println("\n" + challenger.getName() + " is the winner!");
            if (defender.getStars() - 1 >= 0) {
                challenger.addStars(1);
                defender.addStars(-1);
                System.out.println(challenger.getName() + " gained 1 star and "+ defender.getName() + " lost one star.");
            }
            defender.addStrength(challenger.getStrength() / 4);
            defender.addDefense(challenger.getDefense() / 4);
            defender.addDexterity(challenger.getDexterity() / 4);
            defender.addLuck(challenger.getLuck() / 4);
            System.out.println(defender.getName() + " got stronger!");
            System.in.read();
        }
    }
    
}
