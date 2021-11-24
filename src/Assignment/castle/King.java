package Assignment.castle;

import Assignment.Log;
import Assignment.Mine.Resources.Resource;
import Assignment.Treasure.TreasureDoor;
import Assignment.Treasure.TreasuryWrite;

import java.util.List;

public class King implements Runnable{
    private TreasureDoor treasureDoor;
    private List<Resource> resources;

    public King(TreasureDoor treasureDoor)
    {
        this.treasureDoor = treasureDoor;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            int payment = (int) (Math.random()*(150 - 50) + 50);
            TreasuryWrite treasuryWrite = treasureDoor.acquireWrite();
            resources = treasuryWrite.getInventory();
            while(payment > 0)
            {
                if(resources.size() == 0)
                {
                    for(int i = 0; i < resources.size(); i++)
                    {
                        treasuryWrite.put(resources.get(i));
                    }
                    Log.getInstance().addLog("Party can't start.Not enough money.");
                    break;
                }
                resources.add(treasuryWrite.take());
                payment -= resources.get(resources.size() - 1).getValue();

            }
            if(payment <= 0)
            {
                Log.getInstance().addLog("PARTY PARTY PARTY PARTY");
            }
            treasureDoor.releaseWrite();
        }
    }
}
