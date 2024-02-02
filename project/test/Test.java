package project.test;

import project.childGames.GameOperators;
import project.childGames.GameGuess;
import project.childGames.GameWord;

public class Test
{
    public static void main(String[] args)
    {
        // GameGuess gg1 = new GameGuess();
        // gg1.printGame();
        
        // GameGuess gg2 = new GameGuess(1, "Custom game", 15, 10, 50);
        // gg2.printGame();
        
        // // ----------------------

        // GameOperators go1 = new GameOperators();
        // go1.printGame();
        // GameOperators go2 = new GameOperators(1, "Custom Game", 1, 10, 150);
        // go2.printGame();

        // ----------------------
        
        GameWord gw1 = new GameWord();
        gw1.printGame();
        GameWord gw2 = new GameWord(1, "Custom Game", 1, 3);
        gw2.printGame();
    }
}