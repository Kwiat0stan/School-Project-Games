package project.parentsGames;

import java.util.Random;

public abstract class GameString extends Game
{
    public GameString(){}
    public GameString(int id, String name){ super(id, name); }

	public static int randInt(int min, int max)
    {
        Random r = new Random();
        int res = r.nextInt(min, max + 1);
        return res;
    }   
}
