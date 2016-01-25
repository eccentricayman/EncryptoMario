import java.util.Scanner;

public class Player extends Character {
    
    public Player(String name) {
        super(name, 5, 5, 5, 5);
        playa = true;
    }
    
    public void move(int phase, Board ex) {
        Scanner ui = new Scanner(System.in);
        String answer;
        for ( ; roll > 0 ; roll--) {
            if (Math.abs(x) + Math.abs(y) > 5) {
                if (x == 0) {
                    if (y > 0) {
                        x--;
                        y--;
                    }
                    else {
                        ex.showMap(phase,this);
                        System.out.println("Would you like to move Up(0,-4) or to the Right(-1,-4)?\nPlease input 1 or 2.");
                        answer = ui.nextLine();
                        while (answer != "1" && answer != "2") {
                            System.out.println("Please input 1 or 2.");
                            answer = ui.nextLine();
                        }
                        if (answer == "1") y++;
                        else {
                            x--;
                            y++;
                        }
                    }
                }
                else if (y == 0) {
                    if (x > 0) {
                        ex.showMap(phase,this);
                        System.out.println("Would you like to move Up(4,1) or to the Left(4,0)?\nPlease input 1 or 2.");
                        answer = ui.nextLine();
                        while (answer != "1" && answer != "2") {
                            System.out.println("Please input 1 or 2.");
                            answer = ui.nextLine();
                        }
                        if (answer == "1") {
                            x--;
                            y++;
                        }
                        else x--;
                    }
                    else {
                        x++;
                        y--;
                    } 
                }
            }
            else {
                if (Math.abs(x) + Math.abs(y) <  5) {
                    if (x == 0) {
                        if (y == 0) {
                            ex.showMap(phase,this);
                            System.out.println("Would you like to move Up(0,1) or to the Left(-1,0)?\nPlease input 1 or 2.");
                            answer = ui.nextLine();
                            while (answer != "1" && answer != "2") {
                                System.out.println("Please input 1 or 2.");
                                answer = ui.nextLine();
                            }
                            if (answer == "1") y++;
                            else x--;
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
            ex.rmC(this);
            ex.addC(this);
        }
    }
        
    
    public void equip(Equips eq) {
        Scanner ui = new Scanner(System.in);
        String answer;
        if (eq.getType().equals("Helm")) {
            if ( helm == null )  {
                System.out.println("Would you like to equip "+eq.getName()+"? \n"+eq+"\nEnter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    helm = eq;
                    super.addStats(eq);
                    System.out.println(eq.getName() + " has been equipped.");
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
                
            }
            else {
                System.out.println("Equipped Helm: " + helm);
                System.out.println("New Helm: " + eq);
                System.out.println("Would you like to swap Helms? Keep in mind the unused Helm will be sold. Enter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    System.out.println(eq.getName() + " has been equipped and " + helm.getName() + " has been sold for " + helm.getLevel() * 10 + ".");
                    addCoins(helm.getLevel()*10);
                    minusStats(helm);
                    super.addStats(eq);
                    helm = eq;
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
            }
        }
        
        
        if (eq.getType().equals("Armor")) {
            if ( armor == null )  {
                System.out.println("Would you like to equip "+eq.getName()+"? \n"+eq+"\nEnter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    armor = eq;
                    super.addStats(eq);
                    System.out.println(eq.getName() + " has been equipped.");
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
                
            }
            else {
                System.out.println("Equipped Armor: " + armor);
                System.out.println("New Armor: " + eq);
                System.out.println("Would you like to swap Armors? Keep in mind the unused Armor will be sold. Enter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    System.out.println(eq.getName() + " has been equipped and " + armor.getName() + " has been sold for " + armor.getLevel() * 10 + ".");
                    addCoins(armor.getLevel()*10);
                    minusStats(armor);
                    super.addStats(eq);
                    helm = eq;
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
            }
        }
        
        
        if (eq.getType().equals("Boots")) {
            if ( boots == null )  {
                System.out.println("Would you like to equip "+eq.getName()+"? \n"+eq+"\nEnter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    boots = eq;
                    super.addStats(eq);
                    System.out.println(eq.getName() + " has been equipped.");
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
                
            }
            else {
                System.out.println("Equipped Boots: " + boots);
                System.out.println("New Boots: " + eq);
                System.out.println("Would you like to swap Boots? Keep in mind the unused Boots will be sold. Enter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    System.out.println(eq.getName() + " has been equipped and " + boots.getName() + " has been sold for " + boots.getLevel() * 10 + ".");
                    addCoins(boots.getLevel()*10);
                    minusStats(boots);
                    super.addStats(eq);
                    boots = eq;
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
            }
        }
        
        
        if (eq.getType().equals("Amulet")) {
            if ( amulet == null )  {
                System.out.println("Would you like to equip "+eq.getName()+"? \n"+eq+"\nEnter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    amulet = eq;
                    super.addStats(eq);
                    System.out.println(eq.getName() + " has been equipped.");
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
                
            }
            else {
                System.out.println("Equipped Amulet: " + amulet);
                System.out.println("New Amulet " + eq);
                System.out.println("Would you like to swap Amulets? Keep in mind the unused Amulet will be sold. Enter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    System.out.println(eq.getName() + " has been equipped and " + amulet.getName() + " has been sold for " + amulet.getLevel() * 10 + ".");
                    addCoins(amulet.getLevel()*10);
                    minusStats(amulet);
                    super.addStats(eq);
                    amulet = eq;
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
            }
        }
        
        
        if (eq.getType().equals("Ring")) {
            if ( ring == null )  {
                System.out.println("Would you like to equip "+eq.getName()+"? \n"+eq+"\nEnter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    ring = eq;
                    super.addStats(eq);
                    System.out.println(eq.getName() + " has been equipped.");
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
                
            }
            else {
                System.out.println("Equipped Ring: " + ring);
                System.out.println("New Ring: " + eq);
                System.out.println("Would you like to swap Rings? Keep in mind the unused Ring will be sold. Enter Y or N.");
                answer = ui.nextLine();
                while (answer.toLowerCase() != "y" && answer.toLowerCase() != "n") {
                    System.out.println("Please input Y or N.");
                    answer = ui.nextLine();
                }
                if (answer.toLowerCase() == "y") {
                    System.out.println(eq.getName() + " has been equipped and " + ring.getName() + " has been sold for " + ring.getLevel() * 10 + ".");
                    addCoins(ring.getLevel()*10);
                    minusStats(ring);
                    super.addStats(eq);
                    helm = eq;
                }
                else {
                    addCoins(eq.getLevel()*10);
                    System.out.println(eq.getName() + " sold for "+ eq.getLevel()*10 + " coins.");
                }
            }
        }
    }
    
    
}
