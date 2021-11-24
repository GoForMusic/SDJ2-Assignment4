package Assignment.Treasure;

import Assignment.Mine.Resources.Resource;

public interface TreasuryWrite extends TreasuryRead {
    Resource take();
    void put(Resource valuable);
}
