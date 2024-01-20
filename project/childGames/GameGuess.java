package project.childGames;

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

    public String nextStep(String parameter)
    {
        if(this.PHASE == 4){ restart(); }
        if(this.ATTEMPS <= 0){ this.PHASE = 4; }
        else
        {
            if(parameter != "")
            {
                int n = Integer.parseInt(parameter);
                if(n < NUM_TO_GUESS){ this.PHASE = 1; }
                if(n > NUM_TO_GUESS){ this.PHASE = 2; }
                if(n == this.NUM_TO_GUESS){ this.PHASE = 3; }
                this.ATTEMPS -= 1;
            }
        }
        return this.toStringHTML();
    }

    public String toString()
    {
        String r = "";
        r += "ID: " + this.ID + "\n";
        r += "Name: " + this.NAME + "\n";
        r += "Attemps: " + this.ATTEMPS + "\n";
        r += "Min: " + this.MIN + "\n";
        r += "Max: " + this.MAX + "\n";
        r += "Num to guess: " + this.NUM_TO_GUESS + "\n";
        return r;
    }

    public String toStringHTML()
    {
        String r = "<div class=\"w3-panel\">";
        r += "ID: " + this.ID + "<br>";
        r += "Name: " + this.NAME + "<br>";
        r += "Attemps: " + this.ATTEMPS + "<br>";
        r += "Min: " + this.MIN + "<br>";
        r += "Max: " + this.MAX + "<br>";
        r += "Num to guess: " + this.NUM_TO_GUESS + "<br>";
        r += "</div>";

        r += "<div class=\"w3-panel w3-green\">";
        if(this.PHASE == 0) r += "Zaczynamy, podaj wartosc: ";
        if(this.PHASE == 1) r += "Szukana wartosc jest wieksza od podanej: ";
        if(this.PHASE == 2) r += "Szukana wartosc jest mniejsza od podanej: ";
        if(this.PHASE == 3) r += "Zwyciestwo";
        if(this.PHASE == 4) r += "Przegrana";
        r += "</div>";

        return r;
    }

    public void printGame()
    {
        System.out.println("===========================================");
        System.out.print(this.toString());
        System.out.println("===========================================\n");
    }
}
