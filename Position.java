public class Position {
    
    private String characters = "";
    private String eventName;
    private int xcoord, ycoord;
    private int eventNum;
    
    
    
    public void clearCharacters() {
        characters = "";
    }
    
    public void addCharacters(Character Ddaot) {
        characters += Ddaot.getName() + " ";
    }
    
    
}