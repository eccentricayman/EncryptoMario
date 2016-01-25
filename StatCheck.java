/* Statcheck is a java class that only let's a player pass if their 
stats are at the required level, it will be implemented into position. */

import java.util.ArrayList;

public class StatCheck {
    
    private int strreq;
    private int defreq;
    private int dexreq;
    private ArrayList<Character> players;
    private Object special;

    public StatCheck(int str, int def, int dex) {
        strreq = str;
        defreq= def;
        dexreq = dex;
    }

    public void addplayer(Character toadd) {
        if (players.indexOf(toadd) == -1) {
            players.add(toadd);
        }
        else {
            System.out.println("This player is already at this position.");
        }
    }
    
    public void removeplayer(Character torm) {
        if (players.indexOf(torm) != -1) {
            players.remove(torm);
        }
        else {
            System.out.println("This player is not at this position.");
        }
    }
    
    public boolean statCheck(Character tochk) {
        if (players.indexOf(tochk) != -1) {
            if (tochk.getStrength() >= strreq &&
                tochk.getDefense() >= defreq &&
                tochk.getDexterity() >= dexreq) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            System.out.println("Player is not at this position, so false.");
            return false;
        }
    }
    
}
