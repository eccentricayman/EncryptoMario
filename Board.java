/* Controls the playing field and the characters moving on it */

import java.util.ArrayList;

public class Board {

    private ArrayList<Character> players;
    //2D arraylist of positions used as the board
    private Position[][] positions = Position[11][11];
    private Character[][] ranking = Character[4][0]
    
    
    //Constructor
    public Board(Character one, Character two, Character three, Character four) {
        shuffle();
        ranking[0] = {one, two, three, four};
        ranking[1] = {null,null,null};
        ranking[2] = {null,null};
        ranking[3] = {null,null};
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
    
    public void setRanking(Character one, Character two, Character three, Character four) {
        resetRanking(); 
        int[] numRank = new int[4];
        numRank[0] = (int)Math.pow(one.getCoins(), one.getStars() + 1);
        numRank[1] = (int)Math.pow(two.getCoins(), two.getStars() + 1);
        numRank[2] = (int)Math.pow(three.getCoins(), three.getStars() + 1);
        numRank[3] = (int)Math.pow(four.getCoins(), four.getStars() + 1);
        int sorted = 0;
        int threshold = 0;
        int max;
        int rank = 1;
        while (sorted < 4) {
            max = 0;
            for (int x = 0; x<4; x++) {
                if (sorted == 0) if(numRank[x] > max) max = numRank[x]; 
                else if (numRank[x] < threshold) if(numRank[x] > max) max = numRank[x];
            }
            for (int x = 0) x<4; x++) {
                if (numRank[x] == max) {
                    setRank(rank, x, one, two, three, four);
                    sorted++;
                }
            }
            threshold = max;
            rank++;
        }
    
    public void resetRanking() {
        ranking = Character[4][0];
        ranking[0] = {null,null,null,null};
        ranking[1] = {null,null,null};
        ranking[2] = {null,null};
        ranking[3] = {null};
    }
    
    public void setRank(int rank, int indicator, Character one, Character two, Character three, Character four) {
        int x = 0;
        for( ; ranking[rank][x] == null; x++)
        if (indicator == 0) ranking[rank][x] = one;
        else if (indicator == 1) ranking[rank][x] = two;
        else if (indicator == 2) ranking[rank][x] = three;
        else if (indicator == 3) ranking[rank][x] = four;
    }

    public void showMap(Character Boy_x) {
        System.out.println()
    }
    
    
}



