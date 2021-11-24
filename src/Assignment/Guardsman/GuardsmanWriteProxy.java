package Assignment.Guardsman;

import Assignment.Mine.Resources.Resource;
import Assignment.Treasure.TreasureRoom;
import Assignment.Treasure.TreasuryWrite;

import java.util.List;

public class GuardsmanWriteProxy implements TreasuryWrite {
    private TreasureRoom treasureRoom;
    private boolean hasAccess;

    public GuardsmanWriteProxy(TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
        hasAccess = true;
    }

    @Override
    public Resource take() {
        if(hasAccess)
        {
            return treasureRoom.take();
        }
        else throw new IllegalStateException("No access.");
    }

    @Override
    public void put(Resource valuable) {
        if(hasAccess)
        {
            treasureRoom.put(valuable);
        }
        else throw new IllegalStateException("No access.");
    }

    @Override
    public List<Resource> getInventory() {
        if(hasAccess)
        {
            return treasureRoom.getInventory();
        }
        else throw new IllegalStateException("No access.");
    }

    public void restrictAccess()
    {
        hasAccess = false;
    }
}
