public class Player extends Character {
    
    public Player(String name) {
        super(name, 5, 5, 5, 5);
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
        
    //replaced public void showStats() with toString() 
    public String toString() {
        String retstr = new String();
        retstr += name;
        retstr += "Strength: " + strength;
        retstr += "Intelligence: " + intelligence;
        retstr += "Dexterity: " + dexterity;
        retstr += "Coins: " + coins;
        retstr += "Keys: " + keys;
        retstr += "Stars: " + stars;
        retstr += "Equips:";
        for (int i = 0 ; i < items.size() ; i++) {
            retstr += items.get(i).toString();
        }
        return retstr;
    }
    
    public void equip() {
        
    }
    
    
}
