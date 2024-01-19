package project.test;

import project.childGames.GameGuess;
import project.parentsGames.Game;

public class Test
{
    public static void main(String[] args)
    {
        GameGuess game1 = new GameGuess();
        game1.printGame();
        
        GameGuess game2 = new GameGuess(1, "Custom game", 15, 10, 50);
        game2.printGame();
    }
}
