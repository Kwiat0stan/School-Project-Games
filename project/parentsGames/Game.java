package project.parentsGames;

public abstract class Game
{
    protected String NAME;
    protected int ID;

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