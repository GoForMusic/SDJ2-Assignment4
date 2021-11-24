package Assignment.castle;

import Assignment.Log;
import Assignment.Treasure.TreasureDoor;

public class Accountant implements Runnable{

    private TreasureDoor treasureDoor;

    public Accountant(TreasureDoor treasureDoor)
    {
        this.treasureDoor = treasureDoor;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                treasureDoor.acquireRead();
                Thread.sleep(2000);
                Log.getInstance().addLog(Thread.currentThread().getName() + " is waiting for counting");
                treasureDoor.releaseRead();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
