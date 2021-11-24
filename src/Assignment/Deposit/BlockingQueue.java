package Assignment.Deposit;

import Assignment.Mine.Resources.Resource;

public interface BlockingQueue {
    void enqueue(Resource resource) throws InterruptedException;
    Resource dequeue() throws InterruptedException;
    boolean isFull();
}
