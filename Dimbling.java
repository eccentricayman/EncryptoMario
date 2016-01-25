import java.util.Scanner;

public class Dimbling extends Position {
    
    public Dimbling() {
        super("Dice Match");
    }
    
    public void triggerEvent(Character Boy_X) {
        System.out.println("AD: Welcome to Ogwarts the premier traveling dimbling host-group. My name is Alvis Dimbledore and I will be your host today.");
        System.out.println("AD: The goal of dimbling is to match as many die as possible out of 6 die.\nAD: Dimbling costs 10 coins and you can view the exact rewards in the tutorial.");
        System.out.println("AD: Would you like to dimble?");
        Scanner ui = new Scanner(System.in);
        String input = "";
        if (Boy_X.getPlaya()) {
            while (input != "1" && input != "2") {
                System.out.println("Enter 1 (yes) or 2 (no).");
                input = ui.next();
            }
            if (input == "1") {
                if (Boy_X.getCoins() >= 10) {
                    System.out.println("System Voice: " + Boy_X.getName() + " gave 10 coins.");
                    Boy_X.addCoins(-10);
                    int[] list = new int[6];
                    int val;
                    System.out.println("AD: Let us begin the next great adventure!");
                    
                    System.out.print("System Voice: The first roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The second roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The third roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The fourth roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The fifth roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The sixth roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    val = 0;
                    for (int x : list) {
                        if (x == 1) val += 1;
                        else if (x == 2) val += 5;
                        else if (x == 3) val += 8;
                        else if (x == 4) val += 11;
                        else if (x == 5) val += 17;
                        else val+= 25;
                    }
                    
                    System.out.println("AD: Thank you for dimbling. Do come again.");
                    Boy_X.addCoins(val);
                    System.out.println("System Voice: " + Boy_X.getName() + " has gained " + val + " coins.");
                }
                else System.out.println("AD: You seem to be lacking the capital..");
                }
            else System.out.println("AD: Come anytime for the next great adventure!");
            }
        else {
            if (Boy_X.getCoins() >= 10) {
                if (Math.random() * 10 < 7) {
                    System.out.println("System Voice: " + Boy_X.getName() + " gave 10 coins.");
                    Boy_X.addCoins(-10);
                    int[] list = new int[6];
                    int val;
                    System.out.println("AD: Let us begin the next great adventure!");
                    
                    System.out.print("System Voice: The first roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The second roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The third roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The fourth roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The fifth roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    System.out.print("System Voice: The sixth roll is... ");
                    input = ui.next();
                    val = ((int)(Math.random() * 6)) + 1;
                    System.out.println(val);
                    list[val]++;
                    
                    val = 0;
                    for (int x : list) {
                        if (x == 1) val += 1;
                        else if (x == 2) val += 5;
                        else if (x == 3) val += 8;
                        else if (x == 4) val += 11;
                        else if (x == 5) val += 17;
                        else val+= 25;
                    }
                    
                    System.out.println("AD: Thank you for dimbling. Do come again.");
                    Boy_X.addCoins(val);
                    System.out.println("System Voice: " + Boy_X.getName() + " has gained " + val + " coins.");
                }
                else System.out.println("AD: Come anytime for the next great adventure!");
            }
            else System.out.println("AD: Come anytime for the next great adventure!");
        }
    }
}