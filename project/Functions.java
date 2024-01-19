// Class that contains functions using in games.

package project;

import java.util.Scanner;

public class Functions
{
    // Function gettings user's integer.
    // We can't close scan object because than we can only use it once.
    public static int scanInt()
    {
        Scanner scan = new Scanner(System.in);
        int res = scan.nextInt();
        return res;
    }
}
