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
        if (eq.getType().equals("Helm")) {
            if ( Helm == null )  {
                Scanner ui = new Scanner();
                System.out.println("Would you like to equip "+eq.getName()+"? \nEnter Y or N.");
                String answer = ui.next();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.next();
                }
                if (answer.toLowerCase() == "y") {
                    Helm
                }
                
            }
            else {
                
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
