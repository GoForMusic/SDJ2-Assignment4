package Assignment.Deposit;

import Assignment.Log;
import Assignment.Mine.Resources.Resource;


import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Deposit implements BlockingQueue{

    private Queue<Resource> storedResources;
    private int capacity;

    public Deposit(int capacity){
        storedResources = new ArrayBlockingQueue<>(capacity);
        this.capacity=capacity;
    }

    @Override
    public synchronized void enqueue(Resource resource) throws InterruptedException {
        while (isFull())
        {
            Log.getInstance().addLog(Thread.currentThread().getName() + ": " + resource + " added.");
            wait();
        }
        storedResources.add(resource);
        notifyAll();
    }

    @Override
    public synchronized Resource dequeue() throws InterruptedException {
        while (storedResources.isEmpty())
        {
            wait();
        }
        Resource resource = storedResources.peek();
        notifyAll();
        Log.getInstance().addLog(Thread.currentThread().getName() + ": resoueces have been taken");
        return resource;
    }

    @Override public boolean isFull()
    {
        return capacity == storedResources.size();
    }
}
