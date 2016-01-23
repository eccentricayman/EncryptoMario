/* Position is a class that manages a single position on the map */

public abstract class Position {
    
    private String characters = "";
    //replaced eventnum with object event, will do instanceof event
    private Object event;
    private int xcoord, ycoord;
    private abstract eventName;
    
    
    
    public Position(int x, int y) {
        xcoord = x;
        ycoord = y;
    }

    public Position(int x, int y, Object thisevent) {
        this(x, y);
        event = thisevent;
    }
    
    public void addCharacter(Character toadd) {
        characters = toadd.getName();
    }

    public void removeCharacter() {
        characters = "";
    }
    
    public getX() {
        return xcoord;
    }

    public getY() {
        return ycoord;
    }
    
    public abstract void triggerEvent();
    
    public String getEventName() {
        return eventName;
    }
}
