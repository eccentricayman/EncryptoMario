public class RedSpace extends Position {
    
    public RedSpace() {
        super("Red Space");
    }
    
    public void triggerEvent(Character Boy_X) {
        System.out.println(Boy_X.getName() + " lost 4 coins!");
        Boy_X.addCoins(-4);
    }
}