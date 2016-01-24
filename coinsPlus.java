public class coinsPlus extends Position {
    
    public coinsPlus() {
        super("Blue Space");
    }
    
    public triggerEvent(Character Boy_X) {
        System.out.println(Boy_X.getName() + " obtained 5 coins!");
        Boy_X.addCoins(4);
    }
}