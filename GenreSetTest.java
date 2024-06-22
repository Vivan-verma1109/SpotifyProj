package dailymixes;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * test
 * 
 * @author vivanverma
 * @version Oct 25, 2023
 */
public class GenreSetTest
    extends TestCase
{
    private GenreSet g1;
    private GenreSet g2;
    private GenreSet g3;
    private GenreSet g4;
    private GenreSet g5;

    // ----------------------------------------------------------
    /**
     * setup
     */
    public void setUp()
    {
        g1 = new GenreSet(2, 3, 4);
        g2 = new GenreSet(-3, 3, 4);
        g5 = new GenreSet(2, 3, 4);
        g3 = new GenreSet(22, 33, 44);
        g4 = new GenreSet(0, 0, 0);

    }


    // ----------------------------------------------------------
    /**
     * get pop
     */
    public void testGetPop()
    {
        assertEquals(2, g1.getPop());
        assertEquals(3, g1.getRock());
    }
    // ----------------------------------------------------------


    /**
     * get testGetRock
     */
    public void testGetRock()
    {
        assertEquals(3, g1.getRock());
        assertNotSame(22, g1.getRock());
    }
    // ----------------------------------------------------------


    /**
     * get testGetCountry
     */
    public void testGetCountry()
    {
        assertEquals(4, g1.getCountry());
        assertNotSame(34, g1.getCountry());
    }


    /**
     * testIsWithinRange
     */
    public void testIsWithinRange()
    {
        GenreSet g8 = new GenreSet(32, 4, 4);
        GenreSet g9 = new GenreSet(0, 3, 5);
        assertTrue(g1.isWithinRange(g4, g3));
        assertFalse(g2.isWithinRange(g4, g3));
        assertFalse(g1.isWithinRange(g8, g9));
        assertFalse(g1.isWithinRange(g8, g9));

    }


    // ----------------------------------------------------------
    /**
     * test to String
     */
    public void testToString()
    {
        // Pop:20 Rock:51 Country:43
        assertEquals(g1.toString(), "Pop:2 Rock:3 Country:4");
        assertEquals(g2.toString(), "Pop:-3 Rock:3 Country:4");

    }


    // ----------------------------------------------------------
    /**
     * testCompareTo
     */
    public void testCompareTo()
    {
        assertEquals(g1.compareTo(g2), 1);
        assertEquals(g1.compareTo(g3), -1);

    }


    // ----------------------------------------------------------
    /**
     * testIsWithingRange
     */
    public void testIsWithingRange()
    {
        // g4 = new GenreSet(0, 0, 0);

        GenreSet g6 = new GenreSet(-3, 3, 4);
        GenreSet g8 = new GenreSet(30, 3, 4);
        GenreSet g9 = new GenreSet(-1, 3, 4);
        GenreSet g10 = new GenreSet(-1, -1, 4);

        GenreSet g7 = new GenreSet(3, 3, 4);
        assertFalse(g4.isWithinRange(g6, g7));
        assertFalse(g4.isWithinRange(g6, g7));
        assertFalse(g4.isWithinRange(g10, g7));

    }


    // ----------------------------------------------------------
    /**
     * Ptest =
     */
    public void testEquals()
    {
        GenreSet g6 = new GenreSet(2, 4, 4);
        GenreSet g7 = new GenreSet(2, 3, 5);

        assertTrue(g1.equals(g5));
        assertFalse(g1.equals(g2));
        assertTrue(g1.equals(g1));
        assertFalse(g1.equals("90"));
        assertFalse(g6.equals(g1));
        assertFalse(g7.equals(g1));

    }

}
