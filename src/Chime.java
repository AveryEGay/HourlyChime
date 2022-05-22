import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.sound.sampled.*;
import javax.swing.*;

public class Chime {

    static final HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    static {
        hm.put(13,1);
        hm.put(14,2);
        hm.put(15,3);
        hm.put(16,4);
        hm.put(17,5);
        hm.put(18,6);
        hm.put(19,7);
        hm.put(20,8);
        hm.put(21,9);
        hm.put(22,10);
        hm.put(23,11);
        hm.put(0,12);
    }

    public static void playSound(String fileName, String t) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(fileName);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();

        String hour = t.substring(0,2);
        System.out.println(hour);

        int intHour = Integer.parseInt(hour);
        int newHour = -1;
        String specifier = "";

        if (intHour < 12 && intHour > 0) {
            newHour = intHour;
            specifier = "AM";
        }
        else if (intHour == 12){
            newHour = intHour;
            specifier = "PM";
        }
        else if(intHour > 12){
            newHour = TimeConvert(intHour);
            specifier = "PM";
        }
        else if(intHour == 0){
            newHour = TimeConvert(intHour);
            specifier = "AM";
        }
        else{
            System.out.println("Time did not match 0-24 hour format");
        }

        JOptionPane.showMessageDialog(null, "Hourly Chime for " + newHour + " o'clock " + specifier);

    }

    public static int TimeConvert(int currentHour){

        int converted = hm.get(currentHour);

        return converted;
    }

}
