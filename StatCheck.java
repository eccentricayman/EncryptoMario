/* Statcheck is a java class that only let's a player pass if their 
stats are at the required level, it will be implemented into position. */

import java.util.ArrayList;

public class StatCheck {
    
    private int strnreq;
    private int intlreq;
    private int dextreq;
    private ArrayList<Character> players;
    private Object special;

    public StatCheck(int strn, int intl, int dext) {
        strnreq = strn;
        intlreq= intl;
        dextreq = dext;
    }

    public void addplayer(Character toadd) {
        if (players.IndexOf(toadd) == -1) {
            players.add(toadd);
        }
        else {
            System.out.println("This player is already at this position.");
        }
    }
    
    public void removeplayer(Character torm) {
        if (players.IndexOf(torm) != -1) {
            players.remove(torm);
        }
        else {
            System.out.println("This player is not at this position.");
        }
    }
    
    public boolean statCheck(Character tochk) {
        
    }
    
}
