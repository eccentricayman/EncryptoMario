public class BlueSpace extends Position {
    
    public BlueSpace() {
        super("Blue Space");
    }
    
    public triggerEvent(Character Boy_X) {
        System.out.println(Boy_X.getName() + " obtained 5 coins!");
        Boy_X.addCoins(4);
    }
}