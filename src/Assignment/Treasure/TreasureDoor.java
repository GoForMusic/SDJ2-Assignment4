package Assignment.Treasure;

public interface TreasureDoor {
    TreasuryRead acquireRead();
    void releaseRead();
    TreasuryWrite acquireWrite();
    void releaseWrite();
}
