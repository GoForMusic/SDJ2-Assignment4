package Assignment.Mine.Resources;



public class Nothing implements Resource {
    @Override
    public int getValue() {

        return 0;
    }

    @Override
    public String getResourceName() {
        return "Nothing";
    }
}

