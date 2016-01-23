/* Position is a class that manages a single position on the map */

public abstract class Position {
    
    private String characters = "";
    //replaced eventnum with object event, will do instanceof event
    private abstract String eventName;
    
    public Position(String eName) {
        eventName = eName;
    }
    
    public void addCharacter(Character toadd) {
        characters = toadd.getName();
    }

    public void removeCharacter() {
        characters = "";
    }
    
    public abstract void triggerEvent(Character Boy_X);
    
}
