package project.parentsGames;

import java.util.Random;

// We used abstract to prevent creating object of this class because we only use it for inherit. 
public abstract class GameNumber extends Game
{
    public GameNumber(){}
    public GameNumber(int id, String name){ super(id, name); }

    // Random integer method.
    public int randInt(int min, int max)
    {
        Random r = new Random();
        int res = r.nextInt(min, max + 1);
        return res;
    }
}
