// author: Priscilla Tham
// Date: 28/8/2022

public interface IQueueable {

    /**
     * adds value to queue and returns new queue
     * @param value The value
     * @return new queue
     */
    public String[] enqueue(String value);

    /**
     * removes item from queue, and returns the item removed
     * @return The item removed
     */
    public String dequeue();

    /**
     * returns list of all the items in the queue
     * @return The list of all the items in the queue
     */
    public String[] getQueue();

    /**
     * returns the number of items in the queue
     * @return The number of items in the queue
     */
    public int size();
}
