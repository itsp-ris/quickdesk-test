import java.util.Arrays;

public class Queueable {

    public static void main(String[] args) {
        Stack testStack = new Stack(3);
        testStack.enqueue("a");
        testStack.enqueue("b");
        testStack.enqueue("c");
        System.out.println(Arrays.toString(testStack.getQueue()));
        System.out.println(testStack.dequeue());
        System.out.println(Arrays.toString(testStack.getQueue()));
    }
}
