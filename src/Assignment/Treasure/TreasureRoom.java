package Assignment.Treasure;

import Assignment.Mine.Resources.Resource;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasuryWrite{
    private List<Resource> resources;

    public TreasureRoom(){
        resources = new ArrayList<>();
    }

    @Override
    public List<Resource> getInventory() {
        return resources;
    }

    @Override
    public Resource take() {
        return resources.remove(0);
    }

    @Override
    public void put(Resource valuable) {
        resources.add(valuable);
    }
}
