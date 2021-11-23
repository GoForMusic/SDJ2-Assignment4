# Assignment_4
Assignment_4 : A Kingdom simulation shown

## What requirements had to have: 
1. Threads to simulate the actors: King, Accountant, ValuableTransporter and ValuablesMiner
2. Singleton to log any action, e.g. when an actor waits or perform a job.
3. A class to create valuables, e.g. Diamond, GoldNugget, Jewel, Ruby, WoodenCoin, etc, for the Miner.
4. JUnit testing an ArrayList to be used in the Deposit.
5. Adapter for the ArrayList in the Deposit. The Deposit is a blocking queue, you should use the provided ArrayList as the basis for this blocking queue.
6. Producer-Consumer (For the Deposit with the Miners and Valuables Transporters, being producers and consumers, respectively)
7. Readers-Writers for the Treasure room and Guardsman
8. Proxy between the Treasure room and the Guardsman
