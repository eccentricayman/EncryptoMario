public Player extends Character {
    
    public Player(String name) {
        super(name, 5, 5, 5, 5);
    }
    
    public void move() {
        for ( ; roll > 0 ; roll--) {
            if (abs(x) + abs(y) == 5) {
                if (x == 0) {
                    if (y == 0) {
                        
                    }
                    if (y > 0) {
                        x-=1;
                        y-=1; }
                    else {
                        System.out.println("Would you like to move Up(0,-4) or Right(1,-4)?"); }
                else if (y == 0) {
                        if (x > 0) {
                            System.out.println("Would you like to move Left(4,0) or Up(4,1)?"); }    
                    else {
                        x+=1;
                        y-=1; } } }
            else {
                if (x == 0) y++;
                if (y == 0) x++;
                if (y > 0) {
                    if (x > 0) {
                        x--;
                        y++; }
                    else {
                        x--;
                        y--;
                    }
                }
                else {
                    if (x > 0) {
                        x++;
                        y++;
                    }
                    else {
                        x--;
                        y--;
                    }
                }
            }
            }
        }
    }
    
    public void showStats() {
        
    }
    
    public void equip() {
        
    }
    
    
}