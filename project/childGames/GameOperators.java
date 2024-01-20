package project.childGames;

import project.parentsGames.GameInterface;
import project.parentsGames.GameNumber;

public class GameOperators extends GameNumber implements GameInterface
{
    private int ATTEMPS;
    private double MIN;
    private double MAX;
    private double NUM1;
    private double NUM2;
    private final char[] OPERATORS_ARRAY = {'+', '-', '*', '/'};
    private char OPERATOR;
    private int PHASE = 0; // 0 - start, 1 - wrong, 3 - win, 4 - lose
    private double NUM_TO_GUESS;

    public GameOperators() // default game
    {
        this.ATTEMPS = 3;
        this.MIN = 0.0;
        this.MAX = 10.0;
        this.NUM1 = double2(randDouble(this.MIN, this.MAX));
        this.NUM2 = double2(randDouble(this.MIN, this.MAX));
        this.OPERATOR = OPERATORS_ARRAY[randInt(0, this.OPERATORS_ARRAY.length - 1)];
        switch(OPERATOR)
        {
            case '+':
                this.NUM_TO_GUESS = double2(this.NUM1) + double2(this.NUM2);
                break;
            case '-':
                this.NUM_TO_GUESS = double2(this.NUM1) - double2(this.NUM2);
                break;
            case '*':
                this.NUM_TO_GUESS = double2(this.NUM1) * double2(this.NUM2);
                break;
            case '/':
                this.NUM_TO_GUESS = double2(this.NUM1) / double2(this.NUM2);
                break;
            default:
                System.out.println("Wrong operator!");
                break;
        }
    }

    public GameOperators(int id, String name, int attemps, double min, double max)
    {
        super(id, name);
        this.ATTEMPS = attemps;
        this.MIN = min;
        this.MAX = max;
        this.NUM1 = randDouble(this.MIN, this.MAX);
        this.NUM2 = randDouble(this.MIN, this.MAX);
        this.OPERATOR = OPERATORS_ARRAY[randInt(0, this.OPERATORS_ARRAY.length - 1)];
        switch(OPERATOR)
        {
            case '+':
                this.NUM_TO_GUESS = double2(this.NUM1) + double2(this.NUM2);
                break;
            case '-':
                this.NUM_TO_GUESS = double2(this.NUM1) - double2(this.NUM2);
                break;
            case '*':
                this.NUM_TO_GUESS = double2(this.NUM1) * double2(this.NUM2);
                break;
            case '/':
                this.NUM_TO_GUESS = double2(this.NUM1) / double2(this.NUM2);
                break;
            default:
                System.out.println("Wrong operator!");
                break;
        }
    }

    private void restart()
    {
        this.ATTEMPS = 3;
        this.NUM1 = randDouble(this.MIN, this.MAX);
        this.NUM2 = randDouble(this.MIN, this.MAX);
        this.OPERATOR = OPERATORS_ARRAY[randInt(0, this.OPERATORS_ARRAY.length - 1)];
        switch(OPERATOR)
        {
            case '+':
                this.NUM_TO_GUESS = double2(this.NUM1) + double2(this.NUM2);
                break;
            case '-':
                this.NUM_TO_GUESS = double2(this.NUM1) - double2(this.NUM2);
                break;
            case '*':
                this.NUM_TO_GUESS = double2(this.NUM1) * double2(this.NUM2);
                break;
            case '/':
                this.NUM_TO_GUESS = double2(this.NUM1) / double2(this.NUM2);
                break;
            default:
                System.out.println("Wrong operator!");
                break;
        }
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
                double n = Double.parseDouble(parameter);
                if(n == double2(NUM_TO_GUESS)){ this.PHASE = 3; }
                if(n != double2(NUM_TO_GUESS)){ this.PHASE = 1; }
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
        r += "Num1: " + this.NUM1 + "\n";
        r += "Num2: "+ this.NUM2 + "\n";
        r += "Operator: " + this.OPERATOR + "\n";
        r += "Num to calculate: " + this.NUM_TO_GUESS + "<br>";

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
        r += "Num1: " + double2(this.NUM1) + "<br>";
        r += "Num2: "+ double2(this.NUM2) + "<br>";
        r += "Operator: " + this.OPERATOR + "<br>";
        r += "Num to calculate: " + double2(this.NUM_TO_GUESS) + "<br>";
        r += "</div>";

        r += "<div class=\"w3-panel w3-green\">";
        if(this.PHASE == 0) r += "Zaczynamy, podaj wynik: ";
        if(this.PHASE == 1) r += "Podany wynik jest nieprawidlowy";
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