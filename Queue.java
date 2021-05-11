/**
 * Represents the Queue Abstract Data type.
 * @author Spencer
 * @version 1.0
 * @param <T> The type of elements in this list
 */
public interface Queue<T> {
    /**
     * Checks to see this Queue is empty.
     * @return true if Queue is empty, false if not
     */
    boolean isEmpty();
    /**
     * Adds data to the Queue. Think about what kind of object
     * this data should reside in and where it should go to satisfy
     * the FIFO (first in first out) characteristic of a Queue.
     * If data is null, throw an NullPointerException with a message
     * "Data passed in is null."
     * @param data the data to add to the queue.
     */
    void enqueue(T data);
    /**
     * Removes an object from the Queue and returns the data that
     * object holds. Remember the FIFO characteristic of a Queue.
     * If the Queue is empty, throw a NullPointerExceptionwith a message “Empty queue.”
     * @return the dequeued item
     */
    T dequeue();
}