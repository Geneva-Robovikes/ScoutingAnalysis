import java.util.*;
import java.io.*;
import java.net.SocketTimeoutException;

public class Robot{
    ArrayList<Integer> autoAmps = new ArrayList<>();
    ArrayList<Integer> autoSpeaker = new ArrayList<>();
    ArrayList<Integer> amps = new ArrayList<>();
    ArrayList<Integer> speaker = new ArrayList<>();
    public Robot(String robotName, String fileName){
        HashMap<String,String[]> mappedData = new HashMap<>();
        try{
            //opening file
            
            Scanner scanner = new Scanner( new File(fileName));
            String text = scanner.useDelimiter("\\A").next();
            scanner.close();

            //sorting through
            while (text.indexOf(robotName) != -1){
                int startingIndex = text.indexOf(robotName) + robotName.length();
                text = text.substring(startingIndex);
                int index = text.indexOf("Auto: Notes in Amp Scored") + "Auto: Notes in Amp Scored".length() + 1;
                //auto amps

                String value = "";
                while (!text.substring(index,index+1).equals(",")){
                    value += text.substring(index,index+1);
                    index++;
                }
                autoAmps.add(Integer.valueOf(value));

                //auto speaker
                index = text.indexOf("Auto: Notes in Speaker Scored") + "Auto: Notes in Speaker Scored".length() + 1;
                value = "";
                while (!text.substring(index,index+1).equals(",")){
                    value += text.substring(index,index+1);
                    index++;
                }
                autoSpeaker.add(Integer.valueOf(value));
                
                //amp
                index = text.indexOf("Teleop: Notes in Amp Scored") + "Teleop: Notes in Amp Scored".length() + 1;
                value = "";
                while (!text.substring(index,index+1).equals(",")){
                    value += text.substring(index,index+1);
                    index++;
                }
                amps.add(Integer.valueOf(value));
                
                //speaker
                index = text.indexOf("Teleop: Notes in Speaker Scored") + "Teleop: Notes in Speaker Scored".length() + 1;
                value = "";
                while (!text.substring(index,index+1).equals(",")){
                    value += text.substring(index,index+1);
                    index++;
                }
                speaker.add(Integer.valueOf(value));
            }
        } catch(IOException e){
            System.out.println("ERROR" + e.getMessage());
        }
    }
}
