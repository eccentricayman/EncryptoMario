/* The computer version of a character */

import java.util.Random;

public class AI extends Character {
    
    private int difficulty;    

    //does not check if difficulty is from 0-3, because super needs to
    //be first line; 0 == super easy, 1 == easy, 2 == normal, 3 == hard
    //above will be imposed in Board.java
    public AI(String name, int diff) {
        super(name, 3 * diff, 3 * diff, 3 * diff, 3 * diff);
        playa = false;
    }
    
    public void move(int phase, Board ex) throws InterruptedException, Exception{
        for ( ; roll > 0 ; roll--) {
            ex.rmC(this);
            if (Math.abs(x) + Math.abs(y) >= 5) {
                if (x == 0) {
                    if (y > 0) {
                        x--;
                        y--;
                    }
                    else {
                        if((int)(Math.random() * 2) == 0) {
                            System.out.println(name + " decided to move up.");
                            y++;
                        }
                        else {
                            System.out.println(name + " decided to move right.");
                            x++;
                            y++;
                        }
                    }
                }
                else if (y == 0) {
                    if (x > 0) {
                        if((int)(Math.random() * 2) == 0) {
                            System.out.println(name + " decided to move up.");
                            x--;
                        }
                        else {
                            System.out.println(name + " decided to move left.");
                            x--;
                            y++;
                        }
                    }
                    else {
                        x++;
                        y--;
                    } 
                }
                else if (x<0) {
                    if (y>0) {
                        x--;
                        y--;
                    }
                    else {
                        x++;
                        y--;
                    }
                }
                else {
                    if(y>0) {
                        x--;
                        y++;
                    }
                    else {
                        x++;
                        y++;
                    }
                }
            }
            else {
                if (Math.abs(x) + Math.abs(y) <  5) {
                    if (x == 0) {
                        if (y == 0) {
                            if((int)(Math.random() * 2) == 0)  {
                                System.out.println(name + " decided to move up.");
                                y++;
                            }
                            else {
                                System.out.println(name + " decided to move left.");
                                x--;
                            }
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
            ex.addCB(phase, this);
        }
    }
    
    public void equip(Equips eq) {
        //random used to make AI have 50% chance of equipping new equip
        Random rand = new Random();
        int toss = -1;
        //helm equipping
        if (eq.getType().equals("Helm")) {
            if (helm == null) {
                helm = eq;
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss == 0) {
                    addCoins(helm.getLevel() * 10);
                    minusStats(helm);
                    addStats(eq);
                    helm = eq;
                }
                else {
                    addCoins(eq.getWorth());
                }
            }
        }
        //armor equipping
        if (eq.getType().equals("Armor")) {
            if (armor == null) {
                armor = eq;
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss == 0) {
                    addCoins(armor.getLevel() * 10);
                    minusStats(armor);
                    addStats(eq);
                    armor = eq;
                }
                else {
                    addCoins(eq.getWorth());
                }
            }            
        }
        //boots equipping
        if (eq.getType().equals("Boots")) {
            if (boots == null) {
                boots = eq;
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss == 0) {
                    addCoins(boots.getLevel() * 10);
                    minusStats(boots);
                    addStats(eq);
                    boots = eq;
                }
                else {
                    addCoins(eq.getWorth());
                }
            }            
        }
        //amulet equipping
        if (eq.getType().equals("Amulet")) {
            if (amulet == null) {
                amulet = eq;
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss == 0) {
                    addCoins(amulet.getLevel() * 10);
                    minusStats(amulet);
                    addStats(eq);
                    amulet = eq;
                }
                else {
                    addCoins(eq.getWorth());
                }
            }            
        }
        //ring equipping
        if (eq.getType().equals("Ring")) {
            if (ring == null) {
                ring = eq;
            }
            else {
                toss = (int)(rand.nextDouble());
                if (toss == 0) {
                    addCoins(ring.getLevel() * 10);
                    minusStats(ring);
                    addStats(eq);
                    ring = eq;
                }
                else {
                    addCoins(eq.getWorth());
                }
            }            
        }
    }
    
}
