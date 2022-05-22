import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
    public String GetTime(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Object time = dtf.format(now);
        String stringTime = time.toString();
        System.out.println(stringTime);

        return stringTime;
    }
}
