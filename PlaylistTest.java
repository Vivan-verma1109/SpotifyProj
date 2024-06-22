package dailymixes;

import java.util.Arrays;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * test it
 * 
 * @author vivanverma
 * @version Nov 1, 2023
 */
public class PlaylistTest
    extends TestCase
{
    private Playlist p1;
    private Song s1;
    private Song[] songs;

    // ----------------------------------------------------------
    /**
     * setUp
     */
    public void setUp()
    {
        p1 = new Playlist("name", 5, 5, 5, 10, 10, 10, 3);
        s1 = new Song("Song 1", 8, 6, 6, "Playlist 1");
        songs = new Song[p1.getCapacity()];
    }


    // ----------------------------------------------------------
    /**
     * test is full
     */
    public void testIsFull()
    {
        p1.addSong(s1);
        p1.addSong(s1);
        assertFalse(p1.isFull());
        p1.addSong(s1);
        assertTrue(p1.isFull());
    }


    // ----------------------------------------------------------
    /**
     * testGetSongs
     */
    public void testGetSongs()
    {

        p1.addSong(s1);
        songs[0] = s1;
        assertTrue(Arrays.equals(p1.getSongs(), songs));
        songs[1] = s1;
        assertFalse(Arrays.equals(p1.getSongs(), songs));
    }


    // ----------------------------------------------------------
    /**
     * testSetName
     */
    public void testSetName()
    {
        p1.setName("dave");
        assertEquals(p1.getName(), "dave");
        assertFalse(p1.getName().equals("dacave"));

    }


    // ----------------------------------------------------------
    /**
     * getSpacesLeft test
     */
    public void testGetSpacesLeft()
    {
        assertEquals(3, p1.getSpacesLeft());
        assertTrue(p1.addSong(s1));
        assertEquals(2, p1.getSpacesLeft());
    }


    // ----------------------------------------------------------
    /**
     * testaddsong
     */
    public void testAddSong()
    {
        assertTrue(p1.addSong(s1));
        p1.addSong(s1);
        p1.addSong(s1);
        assertFalse(p1.addSong(s1));
    }


    // ----------------------------------------------------------
    /**
     * test equals
     */
    public void testEquals()
    {
        Playlist p2 = p1;
        Playlist p3 = new Playlist("name", 1, 1, 1, 10, 10, 10, 3);
        Playlist p0 = new Playlist("nam", 1, 1, 1, 10, 10, 10, 2);
        Playlist p4 = new Playlist("name", 1, 1, 1, 10, 10, 10, 2);
        assertTrue(p2.equals(p1));
        assertFalse(p1.equals("opop"));
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p4));
        assertFalse(p4.equals(p0));

    }


    // ----------------------------------------------------------
    /**
     * toString test
     */
    public void testToString()
    {
        assertEquals(
            p1.toString(),
            "Playlist: name, # of songs: 0 (cap: 3), Requires: "
                + "Pop:5%-10%, Rock:5%-10%, Country:5%-10%");
        p1.addSong(s1);
        assertEquals(
            p1.toString(),
            "Playlist: name, # of songs: 1 (cap: 3), Requires: "
                + "Pop:5%-10%, Rock:5%-10%, Country:5%-10%");
    }


    // ----------------------------------------------------------
    /**
     * testCompareTo
     */
    public void testCompareTo()
    {
        Playlist p5 = new Playlist("name", 6, 5, 5, 10, 10, 10, 3);
        Playlist p6 = new Playlist("name", 5, 6, 5, 10, 10, 10, 3);
        Playlist p7 = new Playlist("name", 5, 5, 6, 10, 10, 10, 3);
        Playlist p8 = new Playlist("name", 5, 5, 5, 11, 10, 10, 3);
        Playlist p9 = new Playlist("name", 5, 5, 5, 10, 11, 10, 3);
        Playlist p10 = new Playlist("name", 5, 5, 5, 10, 10, 11, 3);
        Playlist p11 = new Playlist("name", 5, 5, 5, 10, 10, 10, 4);
        Playlist p12 = new Playlist("nam", 5, 5, 5, 10, 10, 10, 4);

        assertEquals(p1.compareTo(p1), 0);
        assertEquals(p5.compareTo(p1), 1);
        assertEquals(p1.compareTo(p5), -1);
        assertEquals(p6.compareTo(p1), 1);
        assertEquals(p1.compareTo(p6), -1);
        assertEquals(p7.compareTo(p1), 1);
        assertEquals(p1.compareTo(p7), -1);
        assertEquals(p8.compareTo(p1), 1);
        assertEquals(p1.compareTo(p8), -1);
        assertEquals(p9.compareTo(p1), 1);
        assertEquals(p1.compareTo(p9), -1);
        assertEquals(p10.compareTo(p1), 1);
        assertEquals(p1.compareTo(p10), -1);
        assertEquals(p11.compareTo(p1), 1);
        assertEquals(p1.compareTo(p11), -1);
        assertEquals(p12.compareTo(p1), 1);

    }

}
