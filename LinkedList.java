/**
 * @author spencerkim
 * Class Linked list
 * @param <T> Type of LinkedList
 * @version 1.1
 */
public class LinkedList<T> implements List<T>, Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * Constructor for Linked List.
     * Initialized it with head and tail that are null.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return String statement
     * @Override String statement to show list.
     */
    public String toString() {
        String s = "";
        if (this.head == null) {
            return s;
        } else {
            Node<T> temp = head;
            for (int i = 0; i < this.size(); i++) {
                s += '[';
                s += temp.getData();
                s += ']';
                if (i != this.size() - 1) {
                    s += "-->";
                }
                temp = temp.getNext();
            }
            return s;
        }
    }

    /**
     * Checks if the Queue or List is empty or not.
     *
     * @return boolean if it's empty or not
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Checks the enqueue.
     * @param data the data to add to the queue
     * @throws NullPointerException throws null-pe if data is null
     */
    public void enqueue(T data) throws NullPointerException {
        if (data == null) {
            System.out.println("Data passed in is null");
            throw new NullPointerException();
        }
        Node<T> node = new Node<>(data);
        if (tail != null) {
            tail.setNext(node);
            tail = node;
        } else {
            tail = node;
            head = node;
        }
    }

    /**
     * Checks dequeue.
     *
     * @return data of the node
     * @throws NullPointerException throws null pointer if head is null
     */
    public T dequeue() throws NullPointerException {
        if (head == null) {
            System.out.println("Empty queue");
            throw new NullPointerException();
        }
        Node<T> node = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        node.setNext(null);
        return node.getData();
    }

    /**
     * Returns the size of the linked list.
     *
     * @return int of size of list
     */
    public int size() {
        int count = 0;
        Node<T> node = head;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    @Override
    public void add(int index, T data) throws IllegalArgumentException, NullPointerException {
        if (index < 0 || index > this.size()) {
            System.out.println("Invalid index!");
            throw new IllegalArgumentException();
        }
        if (data == null) {
            System.out.println("Data passed in is null");
            throw new NullPointerException();
        }
        if (head == null) {
            Node<T> toAdd = new Node<>(data);
            head = toAdd;
            tail = toAdd;
            return;
        }
        Node<T> nData;
        if (index > 0) {
            Node<T> temp = head;
            int count = 0;
            while (count != (index - 1)) {
                temp = temp.getNext();
                count++;
            }
            if (index == this.size()) {
                nData = new Node<>(data);
                tail = nData;
            } else {
                nData = new Node<>(data, temp.getNext());
            }
            temp.setNext(nData);
        } else {
            nData = new Node<>(data, head);
            head = nData;
        }
        /*
        if (this.size() == 1) {
            head = nData;
            tail = nData;
            head.setNext(tail);
        }
         */
    }

    /**
     * Adds data to end of list.
     * @param data the data to add
     * @throws NullPointerException when data is null
     */
    public void addToBack(T data) throws NullPointerException {
        if (data == null) {
            System.out.println("Data passed in is null");
            throw new NullPointerException();
        } else if (head == null) {
            Node<T> node = new Node<>(data);
            head = node;
            tail = node;
            node.setNext(null);
        } else {
            Node<T> last = new Node<>(data, null);
            tail.setNext(last);
            tail = last;
        }
    }
    /**
     * Remove the index given in the linked list.
     *
     * @param index the index to remove from
     * @return the data of the removed index
     * @throws IllegalArgumentException when index is out of bounds or head is null
     */
    public T remove(int index) throws IllegalArgumentException {
        if (index < 0 || index >= this.size() || head == null) {
            System.out.println("Invalid index!");
            throw new IllegalArgumentException();
        }
        Node<T> temp = head;
        if (index == 0) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            temp.setNext(null);
            return temp.getData();
        } else if (index == (this.size() - 1)) {
            int count = 0;
            while (count != (index - 1)) {
                temp = temp.getNext();
                count++;
            }
            T rData = temp.getNext().getData();
            temp.setNext(null);
            temp = tail;
            return rData;
        } else {
            int count = 0;
            while (count != (index - 1)) {
                temp = temp.getNext();
                count++;
            }
            T rData = temp.getNext().getData();
            temp.setNext(temp.getNext().getNext());
            return rData;
        }
    }
    /**
     * Returns the data from the given index.
     *
     * @param index the index to return from
     * @return T the data from the index
     * @throws IllegalArgumentException when index is out of bounds or head is null
     */
    public T get(int index) throws IllegalArgumentException {
        if (index < 0 || index >= this.size() || head == null) {
            System.out.println("Invalid Index!");
            throw new IllegalArgumentException();
        }
        int count = 0;
        Node<T> node = head;
        while (count != index) {
            node = node.getNext();
            count++;
        }
        return node.getData();
    }

    /**
     * Sets the data at the given index of the LinkedList.
     *
     * @param index The index at which data will be added.
     * @param data  the data to add.
     * @return T returns the data of the replaced index
     * @throws IllegalArgumentException When out of bounds or when list empty
     */
    public T set(int index, T data) throws IllegalArgumentException, NullPointerException {
        if (index < 0 || index >= this.size() || head == null) {
            System.out.println("Invalid Index!");
            throw new IllegalArgumentException();
        }
        if (data == null) {
            System.out.println("Data passes in is null");
            throw new NullPointerException();
        }
        if (index == 0) {
            T oldData = head.getData();
            head.setData(data);
            return oldData;
        } else if (index == (this.size() - 1)) {
            T oldData = tail.getData();
            Node<T> node = new Node<>(data);
            tail = node;
            return oldData;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            T oldData = prev.getNext().getData();
            Node<T> nextNode = prev.getNext().getNext();
            Node<T> newNode = new Node<>(data);
            prev.setNext(newNode);
            newNode.setNext(nextNode);
            return oldData;
        }
    }

    /**
     * @param data the data to look for/.
     * @return boolean if it contains or not
     * @throws NullPointerException when data is null
     */
    public boolean contains(T data) throws NullPointerException {
        if (data == null) {
            System.out.println("Null data cannot be in list");
            throw new NullPointerException();
        }
        Node<T> test = head;
        while (test != null) {
            if (test.getData() == data) {
                return true;
            } else {
                test = test.getNext();
            }
        }
        return false;
    }

    /**
     * Clears the linked list by cutting head.
     */
    public void clear() {
        head = null;
    }

    /**
     * Returns a linked list with the odd indexed list.
     *
     * @return a new linked list
     */
    public List<T> subOddList() throws IllegalArgumentException {
        if (head == null) {
            System.out.println("List is empty");
            throw new IllegalArgumentException();
        }
        List<T> linkedlist = new LinkedList<T>();
        Node<T> test = head.getNext();
        int i = 0;
        int count = 0;
        while (i < this.size() - 1) {
            linkedlist.add(count, test.getData());
            count++;
            test = test.getNext().getNext();
            if (test == null) {
                break;
            }
            i += 2;
        }
        return linkedlist;
    }

    /**
     * Our Main Method.
     * @param args main method
     */
    public static void main(String[] args) {
        List<String> linkedlist = new LinkedList<>();
        linkedlist.add(0, "Perna");
        linkedlist.add(1, "Sumit");
        linkedlist.add(2, "Allan");
        linkedlist.add(3, "Sarang");
        linkedlist.add(4, "Stasko");
        System.out.println(linkedlist);
        System.out.println(linkedlist.remove(3));
        System.out.println(linkedlist.remove(1));
        System.out.println(linkedlist.remove(0));
        int size = linkedlist.size(); //size should equal 2
        linkedlist.add(2, "Buzz");
        linkedlist.add(2, "Ramblin’");
        linkedlist.clear();
        System.out.println(linkedlist.contains("Ramblin’")); //prints false
        Queue<String> vaccineLine = new LinkedList<>();
        vaccineLine.enqueue("Prerna");
        vaccineLine.enqueue("Stasko");
        vaccineLine.enqueue("Melanie");
        vaccineLine.enqueue("Allan");
        System.out.println(vaccineLine.isEmpty()); //prints false
        System.out.println(vaccineLine.dequeue()); //prints “Prerna”
        System.out.println(vaccineLine.dequeue());

    }
}