package Assignment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Log {
    private List<String> logs;
    private static Log instance;

    private Log()
    {
        logs = new ArrayList<>();
    }

    public void addLog(String message)
    {
        String local  = LocalDateTime.now() + " -> " + message;
        logs.add(local);
        System.out.println(local);
    }

    public static Log getInstance(){
        if(instance == null)
        {
            instance = new Log();
        }
    return instance;
    }
}
