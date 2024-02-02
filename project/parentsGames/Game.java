package project.parentsGames;

// We used abstract to prevent creating object of this class because we only use it for inherit. 
public abstract class Game
{
    protected String NAME;
    protected int ID;

    // We will use these constructors in inheritance games.
    public Game()
    {
        this.ID = 0;
        this.NAME = "Default";
    }
    
    public Game(int id, String name)
    {
        this.ID = id;
        this.NAME = name;
    }

    public void printGame()
    {
        System.out.println("===========================================");
        System.out.print(this.toString());
        System.out.println("===========================================\n");
    }
}