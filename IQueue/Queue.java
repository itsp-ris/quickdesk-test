// author: Priscilla Tham
// Date: 28/8/2022

public class Queue implements IQueueable {

    private int queueSize;
    private int pointer;
    private int itemCount;

    private String[] queue;

    public Queue(int queueSize) {
        this.queueSize = queueSize;
        queue = new String[queueSize];
        itemCount = 0;
        pointer = 0;
    }

    @Override
    public String[] enqueue(String value) {
        // break the system and throw exception when queue is full
        if (itemCount == queueSize) {
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        }
        queue[pointer] = value;
        pointer += 1;
        itemCount += 1;
        return queue;
    }

    @Override
    public String dequeue() {
        // break the system and throw exception when queue is empty
        if (itemCount == 0) {
            throw new NullPointerException("Queue is empty");
        }

        String item = queue[0];

        String[] otherQueue = new String[queueSize];
        int i = 0;
        // copy the items from the original queue to the new queue leaving out the dequeued item
        // instead of setting null to the item(s) in front so that, for e.g., queue = [b, c, null] and != [null, b, c]
        for (int j = i+1; j < itemCount; j++) {
            otherQueue[i] = queue[j];
            i += 1;
        }

        queue = otherQueue;
        pointer -= 1;
        return item;
    }

    @Override
    public String[] getQueue() {
        return queue;
    }

    @Override
    public int size() {
        return itemCount;
    }
}
