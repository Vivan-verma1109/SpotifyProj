

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who do.
// -- vivan verma 9066-03228
package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 *  this is the main class
 * 
 *  @author vivanverma
 *  @version Nov 5, 2023
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * main
     * @param args name
     * @throws FileNotFoundException exception
     * @throws ParseException exception
     * @throws DailyMixDataException exception
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException, DailyMixDataException
    {
        if (args.length == 2)
        {
            PlaylistReader pr = new PlaylistReader(args[0], args[1]);
        }
        PlaylistReader pr = new PlaylistReader("input.txt", "playlists.txt");
    }

}
