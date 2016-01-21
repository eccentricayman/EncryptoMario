/* Controls the board and gets place of players on the board */

import java.util.ArrayList;

public class Board {

    private ArrayList<Character> players;
    //2D arraylist of positions used as the board
    private Position[][] positions;
    
    public Board(String playername, int numagainst) {
        players.add(new Player(playername));
        players.add(new AI("Player2", ));
        players.add(new AI("Player3", ));
        players.add(new AI("Player4", ));
        for (int i = 0 ; i < positions.size() ; i++) {
            for (int j = 0 ; j < positions.get(i).size()) {
                //fill up board here
            }
        }
    }

    public void moveCharacter(Character tomv, int xcoord, int ycoord) {
        
    }
    
}
