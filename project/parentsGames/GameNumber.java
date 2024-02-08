package project.parentsGames;

import java.util.Random;

public abstract class GameNumber extends Game
{
    public GameNumber(){}
    public GameNumber(int id, String name){ super(id, name); }

    // Random integer method.
    public static int randInt(int min, int max)
    {
        Random r = new Random();
        int res = r.nextInt(min, max + 1);
        return res;
    }

    public static double randDouble(double min, double max)
    {
        Random r = new Random();
        double res = r.nextDouble(min, max + 1);
        return res;
    }

    public double double2(double number)
    {
        return Double.parseDouble(String.format("%.1f", number));
    }
}
