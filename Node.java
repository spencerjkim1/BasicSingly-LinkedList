/**
 * @author spencerkim
 * @version 1.1
 * @param <T> data for the node
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Constructor for node.
     * @param data information in node
     * @param next the next node in list
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Makes node with data and it's next null.
     * @param data in the node
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Getter for the data.
     * @return data of the node
     */
    public T getData() {
        return data;
    }

    /**
     * Return the next pointer of the node.
     * @return next pointer
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter for next.
     * @param next next item in list
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Setter for data
     *
     */
    public void setData(T data) {
        this.data = data;
    }

}
