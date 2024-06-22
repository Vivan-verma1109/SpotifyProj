package dailymixes;

import list.AList;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * test for playlist calculator
 * 
 * @author vivanverma
 * @version Nov 4, 2023
 */
public class PlaylistCalculatorTest
    extends TestCase
{
    private PlaylistCalculator p;
    private Playlist tester;
    private Playlist tester2;
    private Playlist tester3;
    private Playlist[] playlist;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> song;
    private Song s;

    // ----------------------------------------------------------
    /**
     * setUp
     */
    public void setUp()
    {
        s = new Song("Name", 2, 5, 5, "name 2");
        song = new ArrayQueue<Song>();
        playlist = new Playlist[3];
        song.enqueue(s);
        tester = new Playlist("name 2", 1, 1, 2, 15, 15, 15, 3);
        tester2 = new Playlist("name", 0, 0, 0, 3, 3, 3, 1);
        tester3 = new Playlist("we up", 0, 0, 0, 30, 30, 30, 1);

        p = new PlaylistCalculator(song, playlist);
        playlist[0] = tester;
        rejectedTracks = new AList<Song>(playlist.length);
        Exception e = null;
        try
        {
            p = new PlaylistCalculator(null, null);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    // ----------------------------------------------------------
    /**
     * testGetQueue
     */
    public void testGetQueue()
    {
        assertEquals(p.getQueue(), song);
        assertNotNull(p.getQueue());
    }


    // ----------------------------------------------------------
    /**
     * get thing for song
     */
    public void testGetPlaylistForSong()
    {
        assertEquals(p.getPlaylistForSong(s), (playlist[0]));
        assertFalse(p.getPlaylistForSong(s).equals(playlist[1]));
    }


    // ----------------------------------------------------------
    /**
     * testGetAList
     */
    public void testGetAList()
    {
        assertEquals(p.getAList(), rejectedTracks);
        assertFalse(p.getAList().equals(s));
    }


    // ----------------------------------------------------------
    /**
     * testGetPlaylistWithMostRoom
     */
    public void testGetPlaylistWithMostRoom()
    {
        playlist[0] = tester;
        playlist[1] = tester2;
        playlist[2] = tester3;
        Song s2 = new Song("Name 40", -1, -101, -101, "name 2");
        assertEquals(p.getPlaylistWithMostRoom(s), tester3);
        assertEquals(p.getPlaylistWithMostRoom(s2), null);

    }


    // ----------------------------------------------------------
    /**
     * testaddsong
     */
    public void testAddSongToPlaylist()
    {
        Song s2 = new Song("Name 3", 29, 29, 29, "we up");
        playlist[0] = tester;
        playlist[1] = tester2;
        playlist[2] = tester3;
        song.enqueue(s2);
        assertTrue(p.addSongToPlaylist());
        assertTrue(p.addSongToPlaylist());
        assertFalse(p.addSongToPlaylist());

    }


    // ----------------------------------------------------------
    /**
     * testGetPlaylists
     */
    public void testGetPlaylists()
    {
        assertEquals(p.getPlaylists("name 2"), 0);
        playlist[0] = tester;
        playlist[1] = tester2;
        playlist[2] = tester3;
        assertEquals(p.getPlaylists("name"), 1);
        assertEquals(p.getPlaylists("n"), -1);
    }


    // ----------------------------------------------------------
    /**
     * test song reject
     */
    public void testSongRejet()
    {
        Song s3 = new Song("Name 3", 29, 29, 29, "we up");
        p.reject();
        rejectedTracks = p.getAList();
        assertEquals(rejectedTracks.getEntry(0), s);
        assertFalse(rejectedTracks.getEntry(0).equals(s3));
    }


    // ----------------------------------------------------------
    /**
     * testGetPlaylistIndex
     */
    public void testGetPlaylistIndex()
    {
        playlist[1] = tester2;
        playlist[2] = tester3;
        assertEquals(p.getPlaylistIndex("name 2"), 0);
        assertEquals(p.getPlaylistIndex("name"), 1);
        assertEquals(p.getPlaylistIndex("n"), -1);

    }

}
