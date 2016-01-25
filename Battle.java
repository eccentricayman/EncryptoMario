/* Battle is a java class that has two (or more) players battle on a spot */

public class Battle extends Position {

    private Character challenger;
    private Character defender;
    //challenger's stats
    private int chealth;
    //defender's stats
    private int dhealth;
    
    public Battle(Character engager, Character accepter) {
        eventName = "Battle";
        challenger = engager;
        defender = accepter;
        chealth = challenger.getStrength() + challenger.getDefense() + challenger.getDexterity() + challenger.getLuck();
        dhealth = defender.getStrength() + defender.getDefense() + defender.getDexterity() + defender.getLuck();
        challenger.setCoins(challenger.getCoins() / 10); 
    }

    private String cdamage() {
        String retstr = "";
        int crit = (int)(Math.random() * 9);
        //10% chance to crit
        if (crit != 0) {
            int damage = challenger.getStrength() * (challenger.getDexterity() / 2);
            dhealth -= damage;
            retstr += Challenger.getName() + " critted for " + damage + "!";
        }
        else {
            int damage = challenger.getStrength();
            dhealth -= damage;
            retstr += Challenger.getName() + " dealt " + damage + "."; 
        }
        return retstr;
    }

    private String ddefend() {
        //should only be used after cdamage()
        String retstr = "";
        int defend = defender.getDefense() / 2;
        dhealth += defend;
        retstr += defender.getName() + " blocked " + defend + " damage.";
        return retstr;
    }

    private String ddamage() {
        String retstr = "";
        int crit = (int)(Math.random() * 9);
        if (crit != 0) {
            int damage = defender.getStrength() * (defender.getDexterity() / 2);
            chealth -= damage;
            retstr += defender.getName() + " critted for " + damage + "!";
        }
        else {
            int damage = defender.getStrength();
            dhealth -= damage;
            retstr += defender.getName() + " dealt " + damage + ".";
        }
        return retstr;
    }

    private String cdefend() {
        //should only be used after ddamage()
        String retstr = "";
        int defend = challenger.getDefense() / 2;
        dhealth += defend;
        retstr += challenger.getName() + " blocked " + defend + " damage.";
        return retstr;
    }
    
    public void toBattle() {
        String progress = "|/-\\";
        int ctr = 0;
        while (chealth != 0 || dhealth != 0) {
            System.out.print("\r" + progress.charAt(ctr % progress.length()) + ddamage());
            ctr ++;
            Thread.sleep(200);
            System.out.print("\r" + progress.charAt(ctr % progress.length()) + cdefend());
            ctr ++;
            Thread.sleep(200);
            System.out.print("\r" + progress.charAt(ctr % progress.length()) + cdamage());
            ctr ++;
            Thread.sleep(200);
            System.out.print("\r" + progress.charAt(ctr % progress.length()) + ddefend());
            ctr ++;
        }
        if (chealth == 0) {
            System.out.println(defender.getName() + " is the winner!");
            if (challenger.getStars() - 1 >= 0) {
                defender.addStars(1);
                challenger.addStars(-1);
            }
        }
        //no chance there's a tie
        else {
            System.out.println(challenger.getName() + " is the winner!");
            if (defender.getStars() - 1 >= 0) {
                challenger.addStars(1);
                defender.addStars(-1);
            }
            defender.addStrength(challenger.getStrength() / 4);
            defender.addDefense(challenger.getDefense() / 4);
            defender.addDexterity(challenger.getDexterity() / 4);
            defender.addLuck(challenger.getLuck() / 4);
        }
    }
    
}
