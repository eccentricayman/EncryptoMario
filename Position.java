/* Position is a class that manages a single position on the map */

public abstract class Position {
    
    private String characters = "";
    //replaced eventnum with object event, will do instanceof event
    private String eventName;
    
    public Position(String eName) {
        eventName = eName;
    }
    
    public void addCharacter(Character toadd) {
        characters = toadd.getName();
    }

    public void clearCharacter() {
        characters = "";
    }
    
    public String getEName() {
        return eventName;
    }
    
    public abstract void triggerEvent(Character Boy_X);
    
    public String look(Character Boy_X) {
        if (characters == Boy_X.getName()) return "[C]";
        else return "[ ]";
    }
    
}
