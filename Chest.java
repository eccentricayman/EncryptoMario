public abstract class Chest extends Position {
    
    protected boolean full;
    
    public Chest(String name) {
        super(name);
        full = true;
    }
    
    public boolean isFull() {
        return full;
    }
    
    public abstract void triggerEvent(Character Boy_X);
}