package dailymixes;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * test song
 * 
 * @author vivanverma
 * @version Oct 27, 2023
 */
public class SongTest
    extends TestCase
{
    private Song s1;
    private Song s2;
    private Song s4;

    // ----------------------------------------------------------
    /**
     * setup
     */
    public void setUp()
    {
        s1 = new Song("Song 1", 50, 25, 25, "Playlist 1");
        s2 = new Song("Song 2", 40, 30, 30, "");
        s4 = new Song("Song 2", 40, 30, 30, "");

    }


    // ----------------------------------------------------------
    /**
     * testGetPlaylistName
     */
    public void testGetPlaylistName()
    {
        assertEquals("Playlist 1", s1.getPlaylistName());
        assertEquals("", s2.getPlaylistName());
        assertEquals(s1.getSuggested(), "Playlist 1");
        assertEquals(s2.getSuggested(), "");
        GenreSet g2 = new GenreSet(40, 30, 30);
        GenreSet g1 = new GenreSet(50, 25, 25);
        assertEquals(s1.getGenreSet(), g1);
        assertEquals(s2.getGenreSet(), g2);
       
    }


    // ----------------------------------------------------------
    /**
     * testGetters
     */
    public void testGetters()
    {
        assertEquals(s1.getPlaylistName(), ("Playlist 1"));
        assertEquals(s2.getPlaylistName(), (""));


        
    }


    // ----------------------------------------------------------
    /**
     * test to string
     */
    public void testToString()
    {
        //
        assertEquals(
            "Song 1 Pop:50 Rock:25 Country:25 Suggested: Playlist 1",
            s1.toString());

        assertEquals(
            "No-Playlist Song 2 Pop:40 Rock:30 Country:30",
            s2.toString());
    }


    // ----------------------------------------------------------
    /**
     * test equals
     */
    public void testEquals()
    {
        Song s5 = new Song("Song 1", 50, 25, 25, null);
        Song s8 = new Song("Song 1", 50, 25, 25, null);
        Song s7 = new Song("Song 1", 50, 25, 25, "Playlist 2");
        Song s6 = new Song("Song 3", 50, 25, 25, "Playlist 2");
        assertFalse(s2.equals(s6));
        assertFalse(s2.equals("90"));
        assertFalse(s1.equals(s2));
        assertFalse(s1.equals(s5));
        assertFalse(s5.equals(s7));
        assertTrue(s2.equals(s4));
        assertTrue(s8.equals(s5));

        assertTrue(s1.equals(s1));
    }
}
