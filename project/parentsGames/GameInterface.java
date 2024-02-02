package project.parentsGames;

public interface GameInterface
{
    // Every class with this interface has to specify those methods.
    public String nextStep(String parameter);
    public String toStringHTML();
    // changed / to reverse - add override about this method in classes/
    public String toString();
    public void printGame();
    public void restart();
}