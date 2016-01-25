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
        + "The map shows a bunch of information: The names of the different Characters,\n"
        + "the information of the current character who's going, and their position on \n"
        + "the map. The X's represent locations with chests, which are explained in part 3.\n"
        + "The C represents the current location of the character who is going.";

     private static String coins =
        "Coins are the currency of the game, and are used to purchase stars. Stars serve\n"
         + "only one purpose, which is explained in the last chapter. Coins can be gotten\n"
         + "in a variety of ways, which is explained in part 4, through special events.";

    private static String stats =
        "Stats are the basic attributes a Character can have, and they are:]n"
        + "Strength\n"
        + "Intelligence\n"
        + "Dexterity\n"
        + "Luck\n"
        + ""
   
    public static void main(String[] args) {
        System.out.println(basics);
    }
}

