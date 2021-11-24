package Assignment.Mine;

import Assignment.Deposit.Deposit;
import Assignment.Log;
import Assignment.Mine.Resources.Resource;
import Assignment.Treasure.TreasureRoom;

import java.util.List;

import static java.lang.Thread.sleep;

public class ResourceTransporter implements Runnable{
    private Deposit deposit;
    private TreasureRoom treasureRoom;

    public ResourceTransporter(Deposit deposit, TreasureRoom treasureRoom){
        this.deposit = deposit;
        this.treasureRoom = treasureRoom;
    }


    @Override
    public void run() {
        while (true){
            List<Resource> resources = null;

            try {
                resources.add(deposit.dequeue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i = 0; i < resources.size(); i++)
            {
                treasureRoom.put(resources.get(i));
            }

            try {
                spendSomeTime("Delivering resources");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void spendSomeTime(String message) throws InterruptedException {
        sleep(1000);
        Log.getInstance().addLog(message);
    }
}
