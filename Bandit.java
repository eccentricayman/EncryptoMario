import java.util.Scanner;

public class Bandit extends Position {
    
    private boolean trap;
    private Character trapper;
    
    
    public Bandit() {
        super("Bandit");
        trap = false;
    }
    
    public void triggerEvent(Character Boy_X) {
        if (! trap) {
            System.out.println("J: Hi, I'm the bandit Jerky ;)\nJ: I can attempt to pickpocket the next person who arrives here for a quarter of your coins.");
            System.out.println("J: Would you like me to do so?");
            if (Boy_X.getPlaya()) {
                Scanner ui = new Scanner(System.in);
                System.out.println("Enter 1 (yes) or 2 (no).");
                String input = ui.next();
                while (! (input.equals("1") || input.equals("2"))) {
                    System.out.println("Enter 1 (yes) or 2 (no).");
                    input = ui.next();
                }
                if (input.equals("1")) {
                    if (Boy_X.getCoins() >= 10) {
                        int val = (int)(Boy_X.getCoins() * .25);
                        System.out.println( Boy_X.getName() + " gave " + val + " coins.");
                        Boy_X.addCoins(-1 * val);
                        trap = true;
                        trapper = Boy_X;
                        System.out.println("J: Mucho Grassy Ass.");
                    }
                    else System.out.println("J: Cmon dude you neet atleast 10 coins.");
                }
                else System.out.println("J: All Planned.");
            }
            else {
                if (Boy_X.getCoins() >= 10) {
                    int val = (int)(Boy_X.getCoins() * .25);
                    System.out.println( Boy_X.getName() + " gave " + val + " coins.");
                    Boy_X.addCoins(-1 * val);
                    trap = true;
                    trapper = Boy_X;
                    System.out.println("J: Mucho Grassy Ass.");
                }
                else System.out.println("J: All Planned.");
            }
        }
        else {
            System.out.println("J: Aight leggooo.");
            int val = (int)((int)(Math.random() * 6) * .1 * Boy_X.getCoins() );
            System.out.println("System Voice: Jerky robbed " + Boy_X.getName() + " for " + val + " coins.");
            Boy_X.addCoins(-1 * val);
            System.out.println("System Voice: " + trapper.getName() + " gained " + val + " coins.");
            trapper.addCoins(val);
            trap = false;
            System.out.println("J: LOOL.");
        }
    }
    
}