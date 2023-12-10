// Prosta gra do zgadywania liczby wylosowanej przez program.

package project;

public class Main
{
    public static void main(String[] args)
    {
        int attemps = 5;
        int num = Functions.randInt(0, 9);
        boolean guessed = false;
        
        System.out.println("Guess number");
        for(int i = 0; i < attemps; i++)
        {
            System.out.println("You have: " + (attemps - i) + " attemps left");
            System.out.print("Enter your number: ");
            int guessNum = Functions.scanInt();
            if(guessNum == num) guessed = true;
            if(guessed == true)
            {
                System.out.println("You guessed !!!");
                System.out.println("The number was " + num);
                break;
            }
            if(guessed == false)
            {
            System.out.println("You lost, no more attemps");
            System.out.println("The number was " + num);            
            }
        }
    }
}
