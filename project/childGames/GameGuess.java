package project.childGames;

import project.Functions;
import project.parentsGames.Game;
import project.parentsGames.GameInterface;
import project.parentsGames.GameNumber;

public class GameGuess extends GameNumber implements GameInterface
{
    private int ATTEMPS;
    private int MIN;
    private int MAX;
    private int NUM_TO_GUESS;
    private int PHASE = 0; // 0 - start, 1 - x >, 2 - x <, 3 - win, 4 - lose

    public GameGuess() // default game
    {
        this.ATTEMPS = 5;
        this.MIN = 0;
        this.MAX = 10;
        this.NUM_TO_GUESS = randInt(this.MIN, this.MAX);
    }

    public GameGuess(int id, String name, int attemps, int min, int max) // custom game
    {
        super(id, name);
        this.ATTEMPS = attemps;
        this.MIN = min;
        this.MAX = max;
        this.NUM_TO_GUESS = randInt(this.MIN, this.MAX);
    }

    private void restart()
    {
        this.ATTEMPS = 5;
        this.NUM_TO_GUESS = randInt(0, 10);
        this.PHASE = 0;
    }

    // public String nextStep(String parameter)
    // {
    //     if(this.PHASE == 4){ restart(); }  
    // }

    @Override
    public String toString()
    {
        String r = "";
        r += "Name: " + this.NAME + "\n";
        r += "Min: " + this.MIN + "\n";
        r += "Max: " + this.MAX + "\n";
        r += "Num to guess: " + this.NUM_TO_GUESS + "\n";
        return r;
    }

    public void printGame()
    {
        System.out.println("===========================================");
        System.out.print(this.toString());
        System.out.println("===========================================\n");
    }
}
