package project.test;

import project.childGames.GameOperators;
import project.childGames.GameGuess;

public class Test
{
    public static void main(String[] args)
    {
        GameGuess game1 = new GameGuess();
        game1.printGame();
        
        GameGuess game2 = new GameGuess(1, "Custom game", 15, 10, 50);
        game2.printGame();
        
        // ----------------------

        GameOperators go1 = new GameOperators();
        go1.printGame();

        GameOperators go2 = new GameOperators(1, "Custom Game", 1, 10, 150);
        go2.printGame();
    }
}