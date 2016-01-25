/* Position is a class that manages a single position on the map */

import java.util.ArrayList;

public abstract class Position {
    
    private ArrayList<Character> characters;
    //replaced eventnum with object event, will do instanceof event
    private String eventName;
    
    public Position(String eName) {
        eventName = eName;
        characters = new ArrayList<Character>();
    }
    
    public void addCharacter(Character toadd) {
        characters.add(toadd);
    }

    public void clearCharacter() {
        characters = new ArrayList<Character>();
    }
    
    public String getEName() {
        return eventName;
    }
    
    public abstract void triggerEvent(Character Boy_X);
    
    public String look(Character Boy_X) {
        if (characters.contains(Boy_X)) return "[C]";
        else return "[ ]";
    }
    
}
