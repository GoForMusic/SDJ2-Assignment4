package Assignment.Mine;

import Assignment.Mine.Resources.Resource;


import java.util.HashMap;


public class Mine {

    private Resource resource;
    private static HashMap<Object, Mine> valuables = new HashMap<>();

    private Mine(Object resource)
    {
        this.resource= (Resource) resource;
    }

    public String getName() {
        return resource.getResourceName();
    }

    public int getValue() {
        return resource.getValue();
    }

    public Resource getResource(){
        return resource;
    }

    public static Object getInstance(Object key)
    {
        Mine instance = valuables.get(key);
        if(instance == null)
        {
            synchronized (valuables)
            {
                instance = valuables.get(key);
                if(instance == null)
                {
                    instance = new Mine(key);
                    valuables.put(key, instance);
                }
            }
        }
        return instance;
    }

}
