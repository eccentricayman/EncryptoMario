import java.util.Scanner;

public class Game {
    
    public static void playTurn(Character Boy_X, int phase, Board bored) {
        bored.showMap(phase, Boy_X);
        int roll = Boy_X.roll();
        System.out.println(Boy_X.getName() + " rolled a " + roll);
        Boy_X.move(phase, bored);
        bored.showMap(phase, Boy_X);
        bored.getPos(Boy_X.getX() + 5,Boy_X.getY() + 5).triggerEvent(Boy_X);
    }
    
    public static int getOpened(Board bored) {
        int opened = 0;
        if(! ((Chest) bored.getPos(5,10)).isFull()) opened++;
        if(! ((Chest) bored.getPos(10,5)).isFull()) opened++;
        if(! ((Chest) bored.getPos(0,5)).isFull()) opened++;
        if(! ((Chest) bored.getPos(5,0)).isFull()) opened++;
        return opened;
    }
    
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        String input;
        int EndPhase = 0;
        boolean done = false;
        System.out.println("1) Tutorial\n2) Game");
        input = ui.next();
        if (input.equals("1")) {
            Tutorial.starttutorial();
        }
        System.out.println("System Voice: Welcome to __. What is your name?");
        input = ui.next();
        Character one = new Player(input);
        
        System.out.println("System Voice: What difficulty would you like to play on?\nSystem Voice: Please choose from Easy(1), Normal(2), Intermediate(3), and Advanced(4).\nPlease input 1, 2, 3, or 4.");
        input = ui.next();
        while (input == "1" || input == "2" || input == "3" || input == "4") {
            System.out.println("Please input 1, 2, 3, or 4.");
            input = ui.next();
        }
        Character two = new AI("Shine",Integer.parseInt(input));
        Character three = new AI("Zach",Integer.parseInt(input));
        Character four = new AI("South",Integer.parseInt(input));
        
        //System.out.println("System Voice: Would you like to initiate the tutorial?\nPlease input 1(yes) or 2(no).");
        //input = ui.next();
        //while (input != "1" && input != "2") {
        //    System.out.println("Please input 1(yes) or 2(no).");
        //    input = ui.next();
        //}
        //if (input == "1") ___;
        
        while (!done) {
            System.out.println("System Voice: How many phases shall the game last?\nPlease input a valid number from 1-20.");
            input = ui.next();
            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= 20) {
                    EndPhase = num;
                    done = true;    
                }
                else System.out.println("Please input a valid number from 1-20.");
            }
            catch (NumberFormatException e) {System.out.println("Invalid number");}
        }
        
        Board game = new Board(one, two, three, four);
        int opened = 0;
        for (int phase = 1; phase<(EndPhase+1); phase++) {
            if (phase != 1) game.shuffle(phase);
            while (opened < 3) {
                opened = 0;
                
                one.addCoins(1);
                
                game.setRanking(one,two,three,four);
                playTurn(one, phase, game);
                
                game.setRanking(one,two,three,four);
                playTurn(two, phase, game);
                
                game.setRanking(one,two,three,four);
                playTurn(three, phase, game);
                
                game.setRanking(one,two,three,four);
                playTurn(four, phase, game);
                
                opened = getOpened(game);
            }
        }
        
        System.out.println("System Voice: The game has come to an end in " + EndPhase + " phases.");
        System.out.println("System Voice: Here is the end ranking.");
        
        if (game.getRanking()[0][0] == null) System.out.println("null");
        else System.out.println("not null");
        
        for(int rank = 1; rank < 5; rank++) {
            for(int x = 0; game.getRanking()[rank-1][x] == null; x++) {
                Character c = game.getRanking()[rank-1][x];
                System.out.println("Rank " + rank + ": " + c.getName());
                System.out.println("Stars: " + c.getStars());
                System.out.println("Coins: " + c.getCoins());
                System.out.println("Stats: ");
                System.out.println("Strength- " + c.getStrength());
                System.out.println("Defense- " + c.getDefense());
                System.out.println("Dexterity- " + c.getDexterity() + "\n");
            }
        }
        
    }
}
