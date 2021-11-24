package Assignment.Mine;

import Assignment.Deposit.Deposit;
import Assignment.Log;
import Assignment.Mine.Resources.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Miner implements Runnable{

    private List<Resource> resources;
    private Mine mine;
    private Deposit deposit;

    public Miner(Deposit deposit){
        resources = new ArrayList<>();
        resources.add(new Copper());
        resources.add(new Diamond());
        resources.add(new Gold());
        resources.add(new Iron());
        resources.add(new Nothing());
        resources.add(new Saphire());

        this.deposit=deposit;
    }


    @Override
    public void run() {
        while (true){
            try{
                Random random = new Random();
                int randInt = random.nextInt(resources.size());
                Mine mine = (Mine) Mine.getInstance(resources.get(randInt));
                Log.getInstance().addLog(Thread.currentThread().getName() + " : Find " + mine.getName() + "("+mine.getValue()+")");
                deposit.enqueue(mine.getResource());

                waitFor();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    private void waitFor() throws InterruptedException
    {
        sleep(1000);
        System.out.println("Resting");
    }

}
