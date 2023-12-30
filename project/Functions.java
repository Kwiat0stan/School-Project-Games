// Class that contains functions using in games.

package project;

import java.util.Random;
import java.util.Scanner;

public class Functions
{
    // Random integer function.
    public static int randInt(int min, int max)
    {
        Random r = new Random();
        int res = r.nextInt(min, max + 1);
        return res;
    }

    // Function gettings user's integer.
    // We can't close scan object because than we can only use it once.
    public static int scanInt()
    {
        Scanner scan = new Scanner(System.in);
        int res = scan.nextInt();
        return res;
    }
}
