/* Position is a class that manages a single position on the map */

public class Position {
    
    private String characters = "";
    //replaced eventnum with object event, will do instanceof event
    private Object event;
    private int xcoord, ycoord;
    
    
    
    public Position(int x, int y) {
        xcoord = x;
        ycoord = y;
    }

    public Position(int x, int y, Object thisevent) {
        this(x, y);
        event = thisevent;
    }
    
    public void addCharacter(Character toadd) {
        characters.add(toadd);
    }

    public void removeCharacter(Character torm) {
        characters.remove(torm);
    }
    
    public int getX() {
        return xcoord;
    }

    public int getY() {
        return ycoord;
    }
    
}
