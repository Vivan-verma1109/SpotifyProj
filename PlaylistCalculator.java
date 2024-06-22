package dailymixes;

import java.util.Arrays;
import list.AList;

// -------------------------------------------------------------------------
/**
 * playlist calc
 * 
 * @author vivanverma
 * @version Nov 1, 2023
 */
public class PlaylistCalculator
{
    private Playlist[] playlists;
    /**
     * NUM_PLAYLISTS
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * MIN_PERCENT
     */
    public static final int MIN_PERCENT = 0;
    /**
     * MAX_PERCENT
     */
    public static final int MAX_PERCENT = 100;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;

    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     * 
     * @param playlist
     *            array
     * @param song
     *            arrayQueue
     */
    public PlaylistCalculator(ArrayQueue<Song> song, Playlist[] playlist)
    {
        if (song == null)
        {
            throw new IllegalArgumentException();
        }
        playlists = playlist;
        songQueue = song;
        rejectedTracks = new AList<Song>(playlists.length);

    }


    // ----------------------------------------------------------
    /**
     * getPlaylists *
     * 
     * @return playlists
     */
    public Playlist[] getPlaylists()
    {
        return playlists;
    }


    // ----------------------------------------------------------
    /**
     * get queue
     * 
     * @return queue
     */
    public ArrayQueue<Song> getQueue()
    {
        return songQueue;
    }


    // ----------------------------------------------------------
    /**
     * getAList
     * 
     * @return AList
     */
    public AList<Song> getAList()
    {
        return rejectedTracks;
    }


    // ----------------------------------------------------------
    /**
     * getPlaylistForSong
     * 
     * @param nextSong
     *            passed in
     * @return playlist
     */
    public Playlist getPlaylistForSong(Song nextSong)
    {
        String s = nextSong.getSuggested();
        for (int i = 0; i < 3; i++)
        {
            if (playlists[i].getName().equals(s) && !playlists[i].isFull()
                && playlists[i].isQualified(nextSong))
            {

                return playlists[i];

            }

        }
        for (int i = 3; i < 0; i++)
        {
            if (!playlists[i].isFull() && playlists[i].isQualified(nextSong))
            {
                return playlists[i];
            }
        }
        return null;

    }


    // ----------------------------------------------------------
    /**
     * get room playlist
     * 
     * @param aSong
     *            to use
     * @return room
     */
    public Playlist getPlaylistWithMostRoom(Song aSong)
    {
        Playlist[] sortedPlaylists = playlists.clone();
        Arrays.sort(sortedPlaylists, 0, 3);

        for (Playlist p : sortedPlaylists)
        {
            if (p.isQualified(aSong))
            {
                return p;
            }
        }

        return null;
    }


    // ----------------------------------------------------------
    /**
     * addSongToPlaylist
     * 
     * @return addSongToPlaylist
     */
    public boolean addSongToPlaylist()
    {
        if (!songQueue.isEmpty())
        {
            Song get = songQueue.getFront();
            Playlist p = getPlaylistForSong(get);
            if (p != null)
            {
                for (int i = 0; i < 3; i++)
                {
                    if (playlists[i].equals(p))
                    {
                        p.addSong(get);
                        songQueue.dequeue();
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * getPlaylists
     * 
     * @param playlist
     *            to get
     * @return where it is
     */
    public int getPlaylists(String playlist)
    {
        for (int i = 0; i < playlists.length; i++)
        {
            if (playlists[i].getName().equals(playlist))
            {
                return i;
            }
        }
        return -1;
    }


    // ----------------------------------------------------------
    /**
     * rejects song
     */
    public void reject()
    {
        Song add = songQueue.getFront();
        songQueue.dequeue();
        rejectedTracks.add(add);
    }


    // ----------------------------------------------------------
    /**
     * getPlaylistIndex
     * 
     * @param playlistName
     *            name
     * @return index
     */
    public int getPlaylistIndex(String playlistName)
    {
        for (int i = 0; i < 3; i++)
        {
            if (playlists[i].getName().equals(playlistName))
            {
                return i;
            }
        }
        return -1;
    }

}
