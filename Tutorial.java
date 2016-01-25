/* a java class that teaches the user how to play the game*/

import java.util.Scanner;

public class Tutorial {

    private static String intro =
        "Welcome to Terminal Mario Party!\n\n"
        + "1) Go through entire tutorial.\n"
        + "2) Select a specific section to read.\n";

    private static String toc =
        "Table of Contents\n\n"
        + "1) Basics and Map\n"
        + "2) Coins and Stars\n"
        + "3) Stats and Equips and Chests\n"
        + "4) Special Events\n"
        + "5) Winning (The Important Chapter)\n";

    private static String basics =
        "The basic commands are mainly outline by the prompts; If the prompt\n"
        + "asks you to say Y or N, you input one of them into the terminal and\n"
        + "press enter.\n\n"
        + "After every turn, the board will be displayed, and your current stats\n"
        + "as well. An example map:\n"
        + "Phase:  Character:  Roll:   Coins:  Stars:\n\n"
        + "                    [X]                     1st: Player \n\n"
        + "                [ ] [ ] [ ]                 2nd: AI-1 \n\n"
        + "            [ ]     [ ]     [ ]             3rd: AI-2 \n\n"
        + "        [ ]         [ ]         [ ]         4th: AI-3 \n\n"
        + "    [ ]             [ ]             [ ]     \n\n"
        + "[X] [ ] [ ] [ ] [ ] [C] [ ] [ ] [ ] [ ] [X] \n\n"
        + "    [ ]             [ ]             [ ] \n\n"
        + "        [ ]         [ ]         [ ] \n\n"
        + "            [ ]     [ ]     [ ] \n\n"
        + "                [ ] [ ] [ ] \n\n"
        + "                    [X] \n\n"
        + "The map shows a bunch of information: The names of the different\n"
        + "Characters, the information of the current character who's going,\n"
        + "and their position on the map. The X's represent locations with\n"
        +"chests, which are explained in part 3. The C represents the current\n"
        + "location of the character who is going.";

    private static String coins =
        "Coins are the currency of the game, and are used to purchase stars.\n"
        + "Stars serve only one purpose, which is explained in the last\n"
        + "chapter. Coins can be obtained in a variety of ways, explained in \n"
        + "part 4, which describes special events.";

    private static String stats =
        "Stats are the basic attributes a Character can have, and they are:]n"
        + "Strength\n"
        + "Defense\n"
        + "Dexterity\n"
        + "Luck\n"
        + "Stats have multiple uses, and are used in special events and battles.\n"
        + "Strength determines how much damage you deal to the other player, and\n"
        + "Defense determines how much is mitigated per attack. Dexterity lets\n"
        + "the player have a higher chance of dodging attacks and dealing\n"
        + "critical hits, which do twice the amount of damage as usual. Luck is\n"
        + "a special stat; the player cannot see how much luck they have, and it\n"
        + "plays no part in battles. A greater luck increases the chance of\n"
        + "getting a better equip. Chests are located at certain positions on\n"
        + "the map, and may contain either Stars or Equips. However, they are\n"
        + "locked by statchecks. This means that the player needs their\n"
        + "strength, defense, and dexterity at a certain level to open\n"
        + "the chest. Equips are items that add stats to a player when equipped.\n"
        + "There are 5 different equip types: helmets, armor, boots, rings, and\n"
        + "amulets. A player can only have one of each equip; if they get a new\n"
        + "equip from a chest, they can sell their current one for coins, based\n"
        + "on how good the equip is.";

    private static String events =
        "These are the various events that can be located at certain positions.\n"
        + "Select a number to visit an event:"
        + "1) View All\n"
        + "2) Bandits\n"
        + "3) Battles\n"
        + "4) Blue Positions\n"
        + "5) Dimbling\n"
        + "6) Red Positions";

    private static String bandits =
        "Bandits are traps that a player can set to steal coins from the next\n"
        + "player that lands on that spot, in exchange for an initial payment.\n"
        + "They can steal from 0-50% of someone's coins.";


    private static String battles =
        "Battles are between two players, and consist of repeatedly attacking\n"
        + "each other. The health of each player is the sum of their stats\n"
        + "times two, and the strength is how much damage they deal. Defense\n"
        + "determines how much damage they mitigate, blocking 0.5 * defense\n"
        + "worth of damage. Dexterity affects critical hits, and the chance\n"
        + "to dodge an attack is random for every player. Once a player loses\n"
        + "all their health, they lose. To start a battle, a player has to\n"
        + "give up 1/10th of their coins. The winner gets a star from the\n"
        + "player, and the other player gets a 25% increase in all stats. If\n"
        + "if the loser has no stars, there is no stat gain.";

    private static String bluepos =
        "Blue positions are spaces that give the player 4 coins.";

    private static String dimbling =
        "A gambling game that lets you roll 6 die. If they match the numbers\n"
        + "given, you'll get a certain amount of coins.";

    private static String redpos =
        "Red positions are spaces that take 4 coins away from the player.";

    private static String winning =
        "The game ends in a certain amount of phases, from 1-20, chosen by\n"
        + "the player. Each phase consists of every single player going\n"
        + "through a turn. Once it ends, the player with the most amount of\n"
        + "stars wins the game!";

    private static String conclusion =
        "Thanks for reading! Would you like to:\n"
        + "Y) Read the tutorial again\n"
        + "OR\n"
        + "N) Play the game";
        
    private static void viewevents() {
        String answer = "";
        Scanner ui = new Scanner(System.in);
        while (!(answer.equals("N"))) {
            System.out.println(events);
            answer = ui.next();
            if (answer.equals("1")) {
                System.out.println(bandits);
                System.out.println(battles);
                System.out.println(bluepos);
                System.out.println(dimbling);
                System.out.println(redpos);
            }
            else if (answer.equals("2")) {
                System.out.println(bandits);
            }
            else if (answer.equals("3")) {
                System.out.println(battles);
            }
            else if (answer.equals("4")) {
                System.out.println(bluepos);
            }
            else if (answer.equals("5")) {
                System.out.println(dimbling);
            }
            else if (answer.equals("6")) {
                System.out.println(redpos);
            }
            else {
                System.out.println("Please input a number from 1-6.");
            }
            System.out.println("Would you like to view another section?");
            System.out.println("Please type Y or N.");
            answer = ui.next();
        }       
    } 

    public static void starttutorial() {
        String answer = "";
        Scanner ui = new Scanner(System.in);        
        while (!(answer.equals("N"))) {
            System.out.println(intro);
            answer = ui.next();
            if (answer.equals("1")) {
                System.out.println(basics);
                System.out.println("Continue...");
                System.in.read();
                System.out.println(coins);
                System.out.println("Continue...");
                System.in.read();
                System.out.println(stats);
                System.out.println("Continue...");
                System.in.read();
                viewevents();
                System.out.println("Continue...");
                System.in.read();
            }
            else if (answer.equals("2")) {
                System.out.println(toc);
                answer = ui.next();
                if (answer.equals("1")) {
                    System.out.println(basics);
                }
                else if (answer.equals("2")) {
                    System.out.println(coins);
                }
                else if (answer.equals("3")) {
                    System.out.println(stats);
                }
                else if (answer.equals("4")) {
                    viewevents();
                }
                else if (answer.equals("5")) {
                    System.out.println(winning);
                }
                else {
                    System.out.println("Please enter a number from 1-5.");
                }
                System.out.println(conclusion);
                answer = ui.next();
            }
        }
    }

}

