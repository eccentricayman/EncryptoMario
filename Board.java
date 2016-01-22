/* Controls the playing field and the characters moving on it */

import java.util.ArrayList;

public class Board {

    private ArrayList<Character> players;
    //2D arraylist of positions used as the board
    private Position[][] positions;
    
    public Board(String playername, int numagainst) {
        players.add(new Player(playername));
        players.add(new AI("Player2", Math.random() * 3));
        players.add(new AI("Player3", Math.random() * 3));
        players.add(new AI("Player4", Math.random() * 3));
        for (int i = 0 ; i < positions.length ; i++) {
            for (int j = 0 ; j < positions[i].length) {
                positions[i][j] = new Position();
            }
        }
    }

    public void moveCharacter(Character tomv, int xcoord, int ycoord) {
        
    }
    
}

