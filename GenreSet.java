package dailymixes;

// -------------------------------------------------------------------------
/**
 * set the genre
 * 
 * @author vivanverma
 * @version Oct 20, 2023
 */
public class GenreSet

{

    private int pop;
    private int rock;
    private int country;

    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * 
     * @param pop
     *            music
     * @param rock
     *            music
     * @param country
     *            music
     */
    public GenreSet(int pop, int rock, int country)
    {
        this.pop = pop;
        this.country = country;
        this.rock = rock;
    }


    // ----------------------------------------------------------
    /**
     * get pop
     * 
     * @return the pop
     */
    public int getPop()
    {
        return pop;
    }


    // ----------------------------------------------------------
    /**
     * get rock
     * 
     * @return the rock
     */
    public int getRock()
    {
        return rock;
    }


    // ----------------------------------------------------------
    /**
     * get country
     * 
     * @return the country
     */
    public int getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * within range
     * 
     * @param minGenreSet
     *            min
     * @param maxGenreSet
     *            max
     * @return if it is or not
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet)
    {
        return this.pop >= minGenreSet.pop && this.pop <= maxGenreSet.pop
            && this.rock >= minGenreSet.rock && this.rock <= maxGenreSet.rock
            && this.country >= minGenreSet.country
            && this.country <= maxGenreSet.country;
    }


    // ----------------------------------------------------------
    /**
     * equals
     * 
     * @param obj
     *            of equal to min
     * @return if it is or not
     */
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof GenreSet))
        {
            return false;
        }
        GenreSet other = (GenreSet)obj;
        return this.pop == other.pop && this.rock == other.rock
            && this.country == other.country;
    }


    /**
     * tostring
     * 
     * @return string
     */
    public String toString()
    {

        return "Pop:" + pop + " Rock:" + rock + " Country:" + country;
    }


    // ----------------------------------------------------------
    /**
     * compareTo
     * 
     * @param other
     *            genre
     * @return int
     */
    public int compareTo(GenreSet other)
    {
        int sum1 = this.pop + this.rock + this.country;
        int sum2 = other.pop + other.rock + other.country;
        return Integer.compare(sum1, sum2);
    }

}
