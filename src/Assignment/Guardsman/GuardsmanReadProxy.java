package Assignment.Guardsman;

import Assignment.Mine.Resources.Resource;
import Assignment.Treasure.TreasureRoom;
import Assignment.Treasure.TreasuryRead;

import java.util.List;

public class GuardsmanReadProxy implements TreasuryRead {
    private TreasureRoom treasureRoom;
    private boolean hasAccess;

    public GuardsmanReadProxy(TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
        hasAccess = true;
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
