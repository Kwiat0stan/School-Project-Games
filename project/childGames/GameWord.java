package project.childGames;

import java.util.HashSet;
import java.util.Set;

import project.parentsGames.GameInterface;
import project.parentsGames.GameString;

public class GameWord extends GameString implements GameInterface
{
    private String[] CARS = {"audi", "porsche", "mercedes", "toyota", "suzuki", "honda", "ferrari"};
    private int LIVES;
    private int EMPTY_BOXES;
    private String CAR_TO_GUESS;
    StringBuilder UNKNOWN_CAR;
    private int PHASE = 0; // 0 - start, 1 - x != , 2 - x =, 3 - win, 4 - lose

    

    public GameWord() // default game
    {
        this.LIVES = 3;
        this.EMPTY_BOXES = 2;
        this.CAR_TO_GUESS = getCar();
        this.UNKNOWN_CAR = new StringBuilder(CAR_TO_GUESS);
        hideCar();
    }

    public GameWord(int id, String name, int lives, int emptyBoxes) // custom game
    {
        super(id, name);
        this.LIVES = lives;
        this.EMPTY_BOXES = emptyBoxes;
        this.CAR_TO_GUESS = getCar();
        this.UNKNOWN_CAR = new StringBuilder(CAR_TO_GUESS);
        hideCar();
    }
    
    public void hideCar()
    {
        int l = this.UNKNOWN_CAR.length() - 1;
        Set<Integer> usedIndices = new HashSet<>();
        for(int i = 0; i < this.EMPTY_BOXES; i++)
        {
            int index;
            do { index = randInt(0, l); }
            while(usedIndices.contains(index));
            usedIndices.add(index);
            this.UNKNOWN_CAR.setCharAt(index, '_');
        }
    }

    public String getCar()
    {
        int s = CARS.length - 1;
        int i = GameString.randInt(0, s);
        String car = CARS[i];
        return car;
    }

    public String toString()
    {
        String r = "";
        r += "ID: " + this.ID + "\n";
        r += "Name: " + this.NAME + "\n";
        r += "Lives: " + this.LIVES + "\n";
        r += "Empty boxes: " + this.EMPTY_BOXES + "\n";
        r += "Car to guess: " + this.CAR_TO_GUESS + "\n";

        return r;
    }
    
    public String toStringHTML()
    {
        String r = "<div class=\"w3-panel\">";
        r += "ID: " + this.ID + "<br>";
        r += "Name: " + this.NAME + "<br>";
        r += "Lives: " + this.LIVES + "<br>";
        r += "EmptyBox: " + this.EMPTY_BOXES + "<br>";
        r += "Car to guess: " + this.CAR_TO_GUESS + "<br>";
        r += "</div>";

        r += "<div class=\"w3-panel w3-green\">";
        if(this.PHASE == 0) r += "Zaczynamy, podaj pasujaca litere: ";
        if(this.PHASE == 1) r += "Podana litera nie pasuje: ";
        if(this.PHASE == 2) r += "Podana litera pasuje: ";
        if(this.PHASE == 3) r += "Gratulacje zgadles";
        if(this.PHASE == 4) r += "Przegrana";
        r += "<br>" + "Status: " + UNKNOWN_CAR;
        r += "</div>";

        return r;
    }

    public void restart()
    {
        this.PHASE = 0;
        this.LIVES = 3;
        this.EMPTY_BOXES = 2;
        this.CAR_TO_GUESS = getCar();
        this.UNKNOWN_CAR = new StringBuilder(CAR_TO_GUESS);
        hideCar();
    }

    public String nextStep(String parameter)
    {
        if(this.PHASE == 3 || this.PHASE == 4){ restart(); }
        if(this.LIVES <= 0){ this.PHASE = 4; }
        else
        {
            if(parameter != "")
            {
                String s = parameter;
                if(CAR_TO_GUESS.contains(s))
                {
                    this.PHASE = 2;
                    for(int i  = 0; i < this.CAR_TO_GUESS.length(); i++)
                    {
                        if(CAR_TO_GUESS.charAt(i) == s.charAt(0))
                        {
                            UNKNOWN_CAR.setCharAt(i, s.charAt(0));
                        };
                    }
                    if(UNKNOWN_CAR.indexOf("_") == -1){ this.PHASE = 3;}
                }
                if(!CAR_TO_GUESS.contains(s))
                {
                    this.PHASE = 1;
                    this.LIVES -= 1;
                    if(this.LIVES <= 0){ this.PHASE = 4; }
                }
            }
        }
        return this.toStringHTML();
    }
    
    @Override
    public void printGame(){ super.printGame(); }
}