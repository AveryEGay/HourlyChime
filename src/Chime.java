import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.sound.sampled.*;
import javax.swing.*;

public class Chime {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        ArrayList<String> timeList = new ArrayList<String>();
        String audioFileName = "./Clock.wav";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Object time = dtf.format(now);
        String stringTime = time.toString();
        System.out.println(stringTime);

        // If last chars of stringTime = 00:00 then call method.
        if(stringTime.contains("00:00")) {
            System.out.println("Yes");
            playSound(audioFileName, stringTime);
        }
        else{
            System.out.println("No");
        }

    }

    public static void playSound(String fileName, String t) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(fileName);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();

        String hour = t.substring(0,2);
        System.out.println(hour);

        JOptionPane.showMessageDialog(null, "OK to stop");

    }

}
