package Assignment.Mine.Resources;

import java.util.Random;

public class Saphire implements Resource{
    @Override
    public int getValue() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public String getResourceName() {
        return "Saphire";
    }
}

