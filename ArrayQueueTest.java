package dailymixes;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * /** create the arrayQueuetest
 * 
 * @author vivanverma
 * @version Oct 27, 2023
 */
public class ArrayQueueTest
    extends TestCase
{

    private ArrayQueue<String> a1;
    private ArrayQueue<String> a2;
    private ArrayQueue<String> a3;

    /**
     * setup
     */
    public void setUp()
    {
        a1 = new ArrayQueue<String>();
        a2 = new ArrayQueue<String>(10);
        a3 = new ArrayQueue<String>();
        a3.enqueue("name");
    }


    /**
     * clear
     */
    public void testClear()
    {
        a1.enqueue("A");
        a1.clear();
        assertEquals(a1.getSize(), 0);
        assertTrue(a1.isEmpty());
    }


    /**
     * size
     */
    public void testGetSize()
    {
        assertEquals(a1.getSize(), 0);
        assertEquals(a3.getSize(), 1);
    }


    /**
     * to string
     */
    public void testToString()
    {
        Song s1 = new Song("hey", 0, 0, 0, "him");
        Song s2 = new Song("himmmy", 0, 0, 0, "");

        ArrayQueue<Song> a5 = new ArrayQueue<Song>();
        a5.enqueue(s1);
        a5.enqueue(s2);
        a1.enqueue("B");
        a1.enqueue("C");
        assertEquals(a2.toString(), "[]");
        System.out.println(a5.toString());
        assertEquals(
            a5.toString(),
            "[hey Pop:0 Rock:0 Country:0 Suggested: him,"
                + " No-Playlist himmmy Pop:0 Rock:0 Country:0]");
    }


    /**
     * testGetLengthOfUnderlyingArray
     */
    public void testGetLengthOfUnderlyingArray()
    {
        assertEquals(a1.getLengthOfUnderlyingArray(), 21);
        assertEquals(a2.getLengthOfUnderlyingArray(), 11);

        for (int i = 0; i < 20; i++)
        {
            a1.enqueue(".");
        }
        a1.enqueue(".");
        assertEquals(a1.getLengthOfUnderlyingArray(), 41);

    }


    /**
     * testGetLengthOfUnderlyingArray
     */
    public void testToArray()
    {
        Exception exception = null;
        try
        {
            a1.toArray();
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
        a1.enqueue("A");
        Object[] a = new Object[a1.getSize()];
        a[0] = "A";
        Object[] b = a1.toArray();
        assertEquals(a[0], b[0]);
    }


    /**
     * testGetFront
     */
    public void testGetFront()
    {
        Exception exception = null;
        try
        {
            a1.getFront();
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
        a1.enqueue("A");
        assertEquals(a1.getFront(), "A");
    }


    /**
     * testIsEmpty
     */
    public void testIsEmpty()
    {
        assertTrue(a1.isEmpty());
        a1.enqueue("A");
        assertFalse(a1.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * testDequeue
     */
    public void testDequeue()
    {
        Exception exception = null;
        try
        {
            a1.dequeue();
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
        a1.enqueue("A");
        assertEquals(a1.dequeue(), "A");
        a1.enqueue("B");
        assertEquals(a1.dequeue(), "B");
    }


    // ----------------------------------------------------------
    /**
     * testEnsureCapacity
     */
    public void testEnsureCapacity()
    {
        a1.enqueue("1");
        a1.enqueue("2");
        a1.enqueue("3");
        a1.enqueue("4");
        a1.enqueue("5");
        a1.enqueue("6");
        a1.enqueue("7");
        a1.enqueue("8");
        a1.enqueue("9");
        a1.enqueue("10");
        a1.enqueue("11");
        a1.enqueue("12");
        a1.enqueue("13");
        a1.enqueue("14");
        a1.enqueue("15");
        a1.enqueue("16");
        a1.enqueue("17");
        a1.enqueue("18");
        a1.enqueue("19");
        a1.enqueue("20");
        a1.enqueue("21");
        a1.enqueue("22");
        a1.enqueue("23");
        System.out.println(a1.toString());
        assertEquals(
            a1.toString(),
            "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, "
                + "14, 15, 16, 17, 18, 19, 20, 21, 22, 23]");

    }


    // ----------------------------------------------------------
    /**
     * test enqueue
     */
    public void testEnqueue()
    {
        a1.enqueue("AEIFHE");
        assertEquals(a1.getSize(), 1);
        assertEquals(a1.getFront(), "AEIFHE");
        a1.dequeue();
        for (int i = 0; i < 20; i++)
        {
            a1.enqueue(".");
        }
        a1.enqueue(".");

    }


    // ----------------------------------------------------------
    /**
     * test equals
     */
    public void testEquals()
    {
        a3.dequeue();
        assertTrue(a1.equals(a3));
        assertTrue(a1.equals(a2));
        assertTrue(a1.equals(a1));
        assertFalse(a1.equals("90"));
        a3.enqueue("A");
        assertFalse(a1.equals(a3));
        a1.enqueue("A");
        assertTrue(a1.equals(a3));

    }

}
