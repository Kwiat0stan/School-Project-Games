// Simple game guessing number choosed by program.

package project;

import project.parentsGames.GameNumber;
import java.util.Scanner;

public class Main extends GameNumber
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int attemps = 5;
        int num = randInt(0, 9);
        boolean guessed = false;
        
        System.out.println("Guess number");
        for(int i = 0; i < attemps; i++)
        {
            System.out.println("You have: " + (attemps - i) + " attemps left");
            System.out.print("Enter your number: ");
            int guessNum = scanner.nextInt();
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
        scanner.close();
    }
}
