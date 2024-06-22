package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

// -------------------------------------------------------------------------
/**
 * create the arrayQueue
 * 
 * @param <T>
 * @author vivanverma
 * @version Oct 27, 2023
 */
public class ArrayQueue<T>
    implements QueueInterface<T>

{
    /**
     * public capacity
     */
    public static final int DEFAULT_CAPACITY = 20;

    private T[] queue;
    private int dequeueIndex;
    private int enqueueIndex;
    private int size;

    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     * 
     * @param capacity
     *            of array
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity)
    {
        queue = (T[])new Object[capacity + 1];
        dequeueIndex = 0;
        enqueueIndex = capacity;
        size = 0;
    }


    @SuppressWarnings("unchecked")
    private void ensureCapacity()
    {
        if ((enqueueIndex + 2) % queue.length == dequeueIndex)
        {
            T[] old = queue;
            int oldSize = old.length;
            int newSize = oldSize * 2 - 1;
            queue = (T[])new Object[newSize];

            int j = dequeueIndex;
            for (int i = 0; i < oldSize; i++)
            {
                queue[i] = old[j];
                j = (j + 1) % oldSize;

            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }

    }


    private int incrementIndex(int index)
    {
        return (index + 1) % queue.length;
    }


    /**
     * clear
     * 
     * @Override
     */

    @SuppressWarnings("unchecked")
    @Override
    public void clear()
    {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        size = 0;
        enqueueIndex = DEFAULT_CAPACITY;
    }


    // ----------------------------------------------------------
    /**
     * get size
     * 
     * @return size
     */
    public int getSize()
    {
        return size;
    }


    /**
     * getLengthOfUnderlyingArray
     * 
     * @return length
     */
    public int getLengthOfUnderlyingArray()
    {
        return queue.length;
    }


    /**
     * toArray
     * 
     * @return array
     */
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        Object[] r = new Object[getSize()];
        int j = 0;
        for (int i = dequeueIndex; i != enqueueIndex; i = incrementIndex(i))
        {
            r[j] = queue[i];
            j++;
        }
        r[j] = queue[enqueueIndex];
        return r;
    }


    /**
     * toString
     * 
     * @return string
     */
    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++)
        {
            if (queue[(dequeueIndex + i) % queue.length] != null)
            {
                sb.append(queue[(dequeueIndex + i) % queue.length].toString());
            }
            if (i != size - 1)
            {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }


    /**
     * equals
     * 
     * @param obj
     *            passed in
     * @return equal or not
     */
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof ArrayQueue))
        {
            return false;
        }
        ArrayQueue<?> other = (ArrayQueue<?>)obj;
        if (getSize() != other.getSize())
        {
            return false;
        }
        for (int i = 0; i < getSize(); i++)
        {
            if (!queue[(dequeueIndex + i) % queue.length].equals(
                other.queue[(other.dequeueIndex + i) % other.queue.length]))
            {
                return false;
            }
        }
        return true;
    }


    /**
     * @return front dequeue
     * @Override
     */
    @Override
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }

        T front = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return front;
    }


    /**
     * enqueue
     * 
     * @param newEntry
     *            to add
     */
    public void enqueue(T newEntry)
    {
        if (isFull())
        {
            ensureCapacity();
        }

        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = newEntry;
        size++;
    }


    /**
     * isempty
     * 
     * @Override
     * @return true or not
     */
    @Override
    public boolean isEmpty()
    {
        return dequeueIndex == ((enqueueIndex + 1) % queue.length);
    }


    private boolean isFull()
    {
        return dequeueIndex == ((enqueueIndex + 2) % queue.length);
    }


    /**
     * isempty
     * 
     * @return front
     */
    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }

}
