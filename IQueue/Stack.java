// author: Priscilla Tham
// Date: 28/8/2022

public class Stack implements IQueueable {

    private int stackSize;
    private int itemCount;
    private int pointer;

    private String[] stack;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        stack = new String[stackSize];
        itemCount = 0;
        pointer = -1;
    }

    @Override
    public String[] enqueue(String value) {
        // break the system and throw exception when stack is full
        if (itemCount == stackSize) {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        }
        pointer += 1;
        stack[pointer] = value;
        itemCount += 1;
        return stack;
    }

    @Override
    public String dequeue() {
        // break the system and throw exception when stack is empty
        if (itemCount == 0) {
            throw new NullPointerException("Stack is empty");
        }
        String item = stack[pointer];
        // setting value = null at the position of the deleted item as when array is initialised
        // mirroring unfilled position
        stack[pointer] = null;
        pointer -= 1;
        itemCount -= 1;
        return item;
    }

    @Override
    public String[] getQueue() {
        return stack;
    }

    @Override
    public int size() {
        return itemCount;
    }
}
