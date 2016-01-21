/* The AI version of a Character/Player */

import java.util.Random;

public class AI extends Character {
    
    private int difficulty;    
        
    public AI(String name, int diff) {
        if (diff >= 0 && diff <= 3) {
            int stat = 3*diff;
            super(name, stat, stat, stat, stat);
        }
        else {
            System.out.println("Remake this AI, difficulty range is from 0-3.");
        }
    }
    
    public void move() {
        for ( ; roll > 0 ; roll--) {
            if (abs(x) + abs(y) > 5) {
                if (x == 0) {
                    if (y > 0) {
                        x--;
                        y--;
                    }
                    else {
                        System.out.println("Would you like to move Up(0,-4) or to the Right(-1,-4)?");
                    }
                }
                else if (y == 0) {
                    if (x > 0) {
                        System.out.println("Would you like to move Up(4,1) or to the Left(4,0)?");
                    }
                    else {
                        x++;
                        y--;
                    } 
                }
            }
            else {
                if (abs(x) + abs(y) <  5) {
                    if (x == 0) {
                        if (y == 0) {
                            System.out.println("Would you like to move Up(0,1) or to the Left(1,0)?");
                        }
                    else y++;
                    }
                    else if (y == 0) x--;
                    else if (y > 0) {
                        if (x > 0) {
                            x--;
                            y++;
                        }
                        else {
                            x--;
                            y--;
                        }
                    }
                    else if (y < 0) {
                        if (x > 0) {
                            x++;
                            y++;
                        }
                        else {
                            x++;
                            y--;
                        }
                    }
                }
            }
            
        }
    }
    
    public void equip() {
        //random used to make AI have 50% chance of equipping new equip
        Random rand = new Random();
        int toss = -1;
        //helm equipping
        if (eq.getType().equals("Helm")) {
            if (helm == null) {
                toss = (int)(rand.nextDouble());
                //randomizes if AI equips or not
                if (toss == 0) {
                    helm = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    addCoins(helm.getLevel() * 10);
                    helm = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }
        }
        //armor equipping
        if (eq.getType().equals("Armor")) {
            if (armor == null) {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    armor = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    addCoins(armor.getLevel() * 10);
                    armor = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }            
        }
        //boots equipping
        if (eq.getType().equals("Boots")) {
            if (boots == null) {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    boots = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    addCoins(boots.getLevel() * 10);
                    boots = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }            
        }
        //amulet equipping
        if (eq.getType().equals("Amulet")) {
            if (amulet == null) {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    amulet = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    addCoins(amulet.getLevel() * 10);
                    amulet = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }            
        }
        //ring equipping
        if (eq.getType().equals("Ring")) {
            if (ring == null) {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    ring = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss = 0) {
                    addCoins(ring.getLevel() * 10);
                    ring = eq;
                }
                else {
                    addCoins(eq.getLevel() * 10);
                }
            }            
        }
    }
    
}
