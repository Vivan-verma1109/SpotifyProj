package dailymixes;

// -------------------------------------------------------------------------
/**
 * song class
 * 
 * @author vivanverma
 * @version Oct 25, 2023
 */
public class Song
{
    private int pop;
    private int rock;
    private int country;
    private String name;
    private String suggested;
    private GenreSet genreSet;

    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * 
     * @param name
     *            song
     * @param pop
     *            song
     * @param rock
     *            song
     * @param country
     *            song
     * @param suggested
     *            thing
     */
    public Song(String name, int pop, int rock, int country, String suggested)
    {
        this.name = name;
        this.pop = pop;
        this.rock = rock;
        this.country = country;
        this.suggested = suggested;
        genreSet = new GenreSet(pop, rock, country);
    }
    
    // ----------------------------------------------------------
    /**
     * getSuggested
     * @return getSuggested
     */
    public String getSuggested()
    {
        return suggested;
    }


    // ----------------------------------------------------------
    /**
     * Pname
     * 
     * @return suggested
     */
    public String getPlaylistName()
    {
        return this.suggested;
    }


    // ----------------------------------------------------------
    /**
     * genreset get
     * 
     * @return genreset
     */
    public GenreSet getGenreSet()
    {
        return genreSet;
    }


    // ----------------------------------------------------------
    /**
     * get name
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * string
     * 
     * @return string of obj
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        if (this.suggested != null && this.suggested.length() > 0)
        {
            s.append(this.name).append(" Pop:").append(this.pop)
                .append(" Rock:").append(this.rock).append(" Country:")
                .append(this.country);
            s.append(" Suggested: ").append(this.suggested);
        }
        else
        {
            s.append("No-Playlist ");
            s.append(this.name).append(" Pop:").append(this.pop)
                .append(" Rock:").append(this.rock).append(" Country:")
                .append(this.country);

        }

        return s.toString();
    }


    @Override
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
        Song otherSong = (Song)obj;
        return this.name.equals(otherSong.name) && this.pop == otherSong.pop
            && this.rock == otherSong.rock && this.country == otherSong.country
            && ((this.suggested == null
                && otherSong.suggested == null)
                || (this.suggested != null && this.suggested
                    .equals(otherSong.suggested)));
    }


}
