// Klasa zawierajaca funkcje uzywane w roznych grach.

package project;

import java.util.Random;
import java.util.Scanner;

public class Functions
{
    // Funckja losujaca integer'a.
    public static int randInt(int min, int max)
    {
        Random r = new Random();
        int res = r.nextInt(min, max + 1);
        return res;
    }

    // Funckja wczytujaca integer'a od uzytkownika.
    public static int scanInt()
    {
        Scanner scan = new Scanner(System.in);
        int res = scan.nextInt();
        return res;
    }
}
