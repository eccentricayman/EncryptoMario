/* Controls the board and gets place of players on the board */

import java.util.ArrayList;

public class Board {

    private ArrayList<Character> players;

    public Board(String playername, int numagainst) {
	players.add(new Player(playername));
	players.add(new AI());
	players.add(new AI());
	players.add(new AI());
    }
    
}
