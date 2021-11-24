package Assignment;

import Assignment.Deposit.Deposit;
import Assignment.Guardsman.Guardsman;
import Assignment.Mine.Mine;
import Assignment.Mine.Miner;
import Assignment.Mine.ResourceTransporter;
import Assignment.Treasure.TreasureRoom;
import Assignment.castle.Accountant;
import Assignment.castle.King;

public class RunApp {
    public static void main(String[] args)
    {
        Deposit deposit = new Deposit(200);
        TreasureRoom treasureRoom = new TreasureRoom();


        Miner miner1 = new Miner(deposit);
        Miner miner2 = new Miner(deposit);
        Miner miner3 = new Miner(deposit);

        ResourceTransporter resourceTransporter1 = new ResourceTransporter(deposit,treasureRoom);
        ResourceTransporter resourceTransporter2 = new ResourceTransporter(deposit,treasureRoom);


        Guardsman guardsman = new Guardsman(treasureRoom);

        Accountant accountant1 = new Accountant(guardsman);
        Accountant accountant2 = new Accountant(guardsman);
        Accountant accountant3 = new Accountant(guardsman);

        King king = new King(guardsman);

        new Thread(miner1, "Miner1").start();
        new Thread(miner2, "Miner2").start();
        new Thread(miner3, "Miner3").start();
        new Thread(resourceTransporter1, "Valuable Transporter1").start();
        new Thread(resourceTransporter2, "Valuable Transporter2").start();
        new Thread(accountant1,"Accountant1").start();
        new Thread(accountant2,"Accountant2").start();
        new Thread(accountant3,"Accountant3").start();
        new Thread(king,"King").start();
    }
}
