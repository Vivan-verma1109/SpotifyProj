package dailymixes;

// -------------------------------------------------------------------------
/**
 * Playlist class dope
 * 
 * @author vivanverma
 * @version Nov 5, 2023
 */
public class Playlist
    implements Comparable<Playlist>
{
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * 
     * @param playlistName
     *            name
     * @param minPop
     *            pop
     * @param minRock
     *            rock
     * @param minCountry
     *            country
     * @param maxPop
     *            pop max
     * @param maxRock
     *            rock max
     * @param maxCountry
     *            country max
     * @param playlistCap
     *            cap
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)
    {
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        numberOfSongs = 0;
        capacity = playlistCap;
        songs = new Song[capacity];
        name = playlistName;
    }


    // ----------------------------------------------------------
    /**
     * getSpacesLeft *
     * 
     * @return getSpacesLeft
     */
    public int getSpacesLeft()
    {
        return capacity - numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * getSongs
     * 
     * @return getSongs
     */
    public Song[] getSongs()
    {
        return songs;
    }


    // ----------------------------------------------------------
    /**
     * setName
     * 
     * @param name
     *            song
     */
    public void setName(String name)
    {
        this.name = name;
    }


    // ----------------------------------------------------------
    /**
     * isFull
     * 
     * @return isFull
     */
    public boolean isFull()
    {
        return numberOfSongs == capacity;
    }


    // ----------------------------------------------------------
    /**
     * Padd song
     * 
     * @param newSong song
     * @return true or false
     */
    public boolean addSong(Song newSong)
    {
        if (!isFull() && isQualified(newSong))
        {

            songs[numberOfSongs] = newSong;
            numberOfSongs++;
            return true;

        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * string
     * 
     * @return string of answer
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ");
        sb.append(
            name + ", # of songs: " + numberOfSongs + " (cap: " + capacity
                + "), Requires: Pop:" + minGenreSet.getPop() + "%-"
                + maxGenreSet.getPop() + "%, " + "Rock:" + minGenreSet.getRock()
                + "%-" + maxGenreSet.getRock() + "%, " + "Country:"
                + minGenreSet.getCountry() + "%-" + maxGenreSet.getCountry()
                + "%");
        return sb.toString();
    }


    // ----------------------------------------------------------
    /**
     * equals
     * 
     * @param obj
     *            passed in
     * @return true or false
     */
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof Song))
        {
            return false;
        }
        Playlist other = (Playlist)obj;
        if (other.numberOfSongs == this.numberOfSongs)
        {
            for (int i = 0; i < numberOfSongs; i++)
            {
                if (!this.songs[i].equals(other.songs[i]))
                {
                    return false;
                }
            }
        }
        return this.minGenreSet == other.minGenreSet
            && this.maxGenreSet == other.maxGenreSet
            && this.capacity == other.capacity && this.name == other.name;
    }


    // ----------------------------------------------------------
    /**
     * isQualified
     * 
     * @param possibleSong
     *            to Qualify
     * @return if isQualified
     */
    public boolean isQualified(Song possibleSong)
    {
        GenreSet g = possibleSong.getGenreSet();

        return g.isWithinRange(this.minGenreSet, this.maxGenreSet);
    }


    @Override
    public int compareTo(Playlist other)
    {
        if (this == other)
        {
            return 0;
        }
        int capacityComparison = Integer.compare(this.capacity, other.capacity);
        if (capacityComparison != 0)
        {
            return capacityComparison;
        }
        int spacesLeftComparison =
            Integer.compare(this.getSpacesLeft(), other.getSpacesLeft());
        if (spacesLeftComparison != 0)
        {
            return spacesLeftComparison;
        }
        int minGenreSetComparison =
            this.minGenreSet.compareTo(other.minGenreSet);
        if (minGenreSetComparison != 0)
        {
            return minGenreSetComparison;
        }
        int maxGenreSetComparison =
            this.maxGenreSet.compareTo(other.maxGenreSet);
        if (maxGenreSetComparison != 0)
        {
            return maxGenreSetComparison;
        }
        return this.name.compareTo(other.name);
    }


    // ----------------------------------------------------------
    /**
     * minGenreSet
     * 
     * @return minGenreSet
     */
    public GenreSet getMinGenreSet()
    {
        return minGenreSet;
    }


    // ----------------------------------------------------------
    /**
     * getname
     * 
     * @return name
     */
    public String getName()
    {
        return name;

    }


    // ----------------------------------------------------------
    /**
     * numberOfSongs
     * 
     * @return numberOfSongs
     */
    public int getNumberOfSongs()
    {
        return numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * maxGenreSet
     * 
     * @return maxGenreSet
     */
    public GenreSet getMaxGenreSet()
    {
        return maxGenreSet;
    }


    // ----------------------------------------------------------
    /**
     * getCapacity
     * 
     * @return capacity
     */
    public int getCapacity()
    {
        return capacity;
    }

}
