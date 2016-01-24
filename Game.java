import java.util.Scanner

public class Game {
    public static void main(String[] args) {
        Scanner ui = new Scanner();
        String input;
        int roll;
        int EndPhase;
        boolean done = false;
        
        System.out.println("System Voice: Welcome to __. What is your name?");
        input = ui.next();
        Character one = new Player(input);
        
        System.out.println("System Voice: What difficulty would you like to play on?\nSystem Voice: Please choose from Easy(1), Normal(2), Intermediate(3), and Advanced(4).\nPlease input 1, 2, 3, or 4.");
        input = ui.next();
        while (input != "1" && input != "2" && input != "3" && input != "4") {
            System.out.println("Please input 1, 2, 3, or 4.");
            input = ui.next();
        }
        Character two = new AI(Integer.parseInt(input));
        Character three = new AI(Integer.parseInt(input));
        Character four = new AI(Integer.parseInt(input));
        
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
            catch (NumberFormatException e) System.out.println("Invalid number");
        }
        
        Board game = new Board(one, two, three, four);
        int opened;
        for (int phase = 1; phase<(EndPhase+1); phase++) {
            while (opened < 3) {
                opened = 0;
                
                game.showMap(phase, one);
                roll = one.roll();
                one.move();
                game.getPos(one.getX() + 5,one.getY() + 5).triggerEvent(one);
            
                game.showMap(phase, two);
                roll = two.roll();
                two.move();
                game.getPos(two.getX() + 5,two.getY() + 5).triggerEvent(two);
            
                game.showMap(phase, three);
                roll = three.roll();
                three.move();
                game.getPos(three.getX() + 5,three.getY() + 5).triggerEvent(three);
            
                game.showMap(phase, four);
                roll = four.roll();
                four.move();
                game.getPos(four.getX() + 5,four.getY() + 5).triggerEvent(four);
                
                if(! game.getPos[5][10]).isFull()) opened++;
                if(! game.getPos[10][5]).isFull()) opened++;
                if(! game.getPos[0][5]).isFull()) opened++;
                if(! game.getPos[5][0]).isFull()) opened++;
            }
        }
        
    }
}