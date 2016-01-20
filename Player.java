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
        
    
    public void equip(Equips eq) {
        Scanner ui = new Scanner();
        String answer;
        if (eq.getType().equals("Helm")) {
            if ( Helm == null )  {
                System.out.println("Would you like to equip "+eq.getName()+"? \n"+eq+"\nEnter Y or N.");
                answer = ui.next();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.next();
                }
                if (answer.toLowerCase() == "y") Helm = eq;
                else {
                    addCoins(eq.level*20);
                    System.out.println("Equip sold for "+ eq.level*10 + " coins.");
                }
                
            }
            else {
                System.out.println("Equipped Helm: " + Helm);
                System.out.println("New Helm: " + eq);
                System.out.println("Would you like to swap Helms? Keep in mind the unused Helm will be sold. Enter Y or N.");
                
                
            }
        }
        if (eq.getType().equals("Armor")) {
            
        }
        if (eq.getType().equals("Boots")) {
            
        }
        if (eq.getType().equals("Amulet")) {
            
        }
        if (eq.getType().equals("Ring")) {
            
        }
    }
    
    
}
