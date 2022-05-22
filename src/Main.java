import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

        Chime chimeObj = new Chime();
        CurrentTime ct = new CurrentTime();

        String audioFileName = "./Clock.wav";
        String timeFormat = ":00:";

        while(true){
            String returnedTime = ct.GetTime();

            if(returnedTime.contains(timeFormat)) {
                chimeObj.playSound(audioFileName, returnedTime);
                Thread.sleep(60500);
            }
            Thread.sleep(5500);
        }

    }
}
