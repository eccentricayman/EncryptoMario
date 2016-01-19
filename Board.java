/* Controls the board and gets place of players on the board */

import java.util.ArrayList;

public class Board {

    private ArrayList<Character> players;
    //2D arraylist of positions used as the board
    private ArrayList<ArrayList<Position>> positions;
    
    public Board(String playername, int numagainst) {
        players.add(new Player(playername));
        players.add(new AI());
        players.add(new AI());
        players.add(new AI());
        for (int i = 0 ; i < positions.size() ; i++) {
            for (int j = 0 ; j < positions.get(i).size()) {
                //fill up board here
            }
        }
    }
}
