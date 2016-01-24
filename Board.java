/* Controls the playing field and the characters moving on it */

import java.util.ArrayList;

public class Board {

    private ArrayList<Character> players;
    //2D arraylist of positions used as the board
    private Position[][] positions = Position[11][11];
    
    
    //Constructor
    public Board() {
        shuffle();
    }
    
    
    //Methods
    public void addC(Character Boy_X) {
        positions[Boy_X.getX()][Boy_X.getY()].addCharacter(Boy_X);
    }
    
    public void rmC(Character Boy_X) {
        positions[Boy_X.getX()][Boy_X.getY()].clearCharacter();
    }
    
    public void shuffle() {
        int val = (int)(Math.random()* 4);
        if (val == 0) {
            positions[5][10] = new StarChest();
            positions[0][5] = new Chest();
            positions[10][5] = new Chest();
            positions[5][0] = new Chest();
        }
        else if (val == 1) {
            positions[0][5] = new StarChest();
            positions[5][10] = new Chest();
            positions[10][5] = new Chest();
            positions[5][0] = new Chest();
        }
        else if (val == 2) {
            positions[10][5] = new StarChest();
            positions[5][10] = new Chest();
            positions[0][5] = new Chest();
            positions[5][0] = new Chest();
        }
        else {
            positions[5][0] = new StarChest();
            positions[5][10] = new Chest();
            positions[0][5] = new Chest();
            positions[10][5] = new Chest();
        }
        
        for (int x = 0, y = 5; x<11; x++) {
            setEvent(x,y);
            setEvent(y,x);
        }
        
        for(int x = 1, y = 6; x<5; x++, y++) {
            setEvent(x,y);
            setEvent(y,x);
            setEvent(x,y-2*x);
            setEvent(y,y-2*x+5);
        }
    }
    
    public void setEvent(int x, int y) {
        int chance = (int)(Math.random() * 100);
        if (val < 50) positions[x][y] = new BlueSpace();
        else if (val < 85) positions[x][y] = new RedSpace();
        else if (val < 90) positions[x][y] = new Bandit();
        else positions[x][y] = new Dimbling();
    }

    public void showMap(Character Boy_w, Character Boy_x, Character Boy_y, Character Boy_Z) {
        System.out.println()
    }
    
    
}



