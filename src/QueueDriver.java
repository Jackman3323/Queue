/**
 * QueueDriver.java
 * This program is a test driver for my Queue (and by extent, QueueNode) class.
 * It will test all normal and all edge cases, print results and prove the smooth
 * functioning of my class.
 * 11-12-20
 * JBH
 */
public class QueueDriver {
    public static void main(String[] args) {
        Queue<String> myQueue = new Queue<String>();
        System.out.println("This should say true: " + myQueue.isEmpty());
        System.out.println("This should say null: " + myQueue.peek());
        System.out.println("This should say null: " + myQueue.dequeue());
        String firstItem = "I'm the first in line!";
        myQueue.enqueue(firstItem);
        String secondItem = "I'm second in line!";
        myQueue.enqueue(secondItem);
        String thirdItem = "I'm third in line!";
        myQueue.enqueue(thirdItem);
        System.out.println("This should say 3: " + myQueue.size());
        System.out.println("This should say false: " + myQueue.isEmpty());
        System.out.println("This should say I'm the first in line!: " + myQueue.dequeue());
        System.out.println("This should say I'm second in line!: " + myQueue.dequeue());
        System.out.println("This should say 1: " + myQueue.size());
        System.out.println("This should say I'm third in line!: " + myQueue.peek());
        System.out.println("If there were no contradictions, the Queue and QueueNode classes work properly.");
    }
}
