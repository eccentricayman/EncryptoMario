public class coinsMinus extends Position {
    
    public coinsMinus() {
        super("Red Space");
    }
    
    public triggerEvent(Character Boy_X) {
        System.out.println(Boy_X.getName() + " lost 5 coins!");
        Boy_X.addCoins(-4);
    }
}