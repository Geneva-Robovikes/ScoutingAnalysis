import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.*;

public class Match {
    ArrayList<RobotMatch> robotsArray = new ArrayList<>();
    int number;
    public Match(int number, String fileName){
        this.number = number;
        int indexShiftLeft = 3; //the index shift is 3 when line ends with ,\n and 1 when line ends with ,
        int indexShiftRight = 0;
        try{
            Scanner scanner = new Scanner(new File(fileName));
            String text = scanner.useDelimiter("\\A").next();
            while (text.indexOf("Match #," + number + ",") != -1){
                int startingIndex = text.lastIndexOf("Team Name,",text.indexOf("Match #,"+number+",")-indexShiftLeft);
                RobotMatch newRobot = new RobotMatch();
                text = text.substring(startingIndex);

                String teamName = text.substring(text.indexOf("Team Name,")+"Team Name,".length()+indexShiftRight,text.indexOf("Match #,")-indexShiftLeft);
                newRobot.teamName = teamName;

                String teamColor = text.substring(text.indexOf("Team,")+"Team,".length()+indexShiftRight,text.indexOf("Robot Height,")-indexShiftLeft);
                newRobot.teamColor = teamColor;
    
                String autoAmpsScored = text.substring(text.indexOf("Auto: Notes in Amp Scored,")+"Auto: Notes in Amp Scored,".length()+indexShiftRight,text.indexOf("Auto: Notes in Speaker Scored,")-indexShiftLeft);
                newRobot.autoAmpsScored = autoAmpsScored;

                String autoSpeaker = text.substring(text.indexOf("Auto: Notes in Speaker Scored,")+"Auto: Notes in Speaker Scored,".length()+indexShiftRight,text.indexOf("Auto: Left Starting Area,")-indexShiftLeft);
                newRobot.autoSpeaker = autoSpeaker;

                String autoLeftStartingArea = text.substring(text.indexOf("Auto: Left Starting Area,")+"Auto: Left Starting Area,".length()+indexShiftRight,text.indexOf("Teleop: Notes in Amp Scored,")-indexShiftLeft);
                newRobot.autoLeftStartingArea = autoLeftStartingArea;

                String teleopAmpsScored = text.substring(text.indexOf("Teleop: Notes in Amp Scored,")+"Teleop: Notes in Amp Scored,".length()+indexShiftRight,text.indexOf("Teleop: Notes in Speaker Scored,")-indexShiftLeft);
                newRobot.teleopAmpsScored = teleopAmpsScored;

                String teleopSpeakerScored = text.substring(text.indexOf("Teleop: Notes in Speaker Scored,")+"Teleop: Notes in Speaker Scored,".length()+indexShiftRight,text.indexOf("Teleop: Shots Missed,")-indexShiftLeft);
                newRobot.teleopSpeakerScored = teleopSpeakerScored;

                String teleopShotsMissed = text.substring(text.indexOf("Teleop: Shots Missed,")+"Teleop: Shots Missed,".length()+indexShiftRight,text.indexOf("Teleop: Completed Climb,")-indexShiftLeft);
                newRobot.teleopShotsMissed = teleopShotsMissed;

                String teleopClimb = text.substring(text.indexOf("Teleop: Completed Climb,")+"Teleop: Completed Climb,".length()+indexShiftRight,text.indexOf("Teleop: Completed Trap")-indexShiftLeft);
                newRobot.teleopClimb = teleopClimb;

                String teleopTrap = text.substring(text.indexOf("Teleop: Completed Trap,")+"Teleop: Completed Trap,".length()+indexShiftRight,text.indexOf("Teleop: Broke Down but Restarted,")-indexShiftLeft);
                newRobot.teleopTrap = teleopTrap;

                String teleopBrokeDown = text.substring(text.indexOf("Teleop: Broke Down but Restarted,")+"Teleop: Broke Down but Restarted,".length()+indexShiftRight,text.indexOf("Teleop: Broke Down not restarted,")-indexShiftLeft);
                newRobot.teleopBrokeDown = teleopTrap;
                
                String teleopBrokeDownRestarted = text.substring(text.indexOf("Teleop: Broke Down not restarted,")+"Teleop: Broke Down not restarted,".length()+indexShiftRight,text.indexOf("Mid 1,")-indexShiftLeft);
                newRobot.teleopBrokeDownRestarted = teleopBrokeDownRestarted;
                
                robotsArray.add(newRobot);

                text = text.substring(text.indexOf("Match #,")+"Match #,".length());
                this.sort();
            }
        } catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public void sort(){
        ArrayList<RobotMatch> teamBlue = new ArrayList<>();
        ArrayList<RobotMatch> teamRed = new ArrayList<>();
        for (int i = 0; i < robotsArray.size();i++){
            if (robotsArray.get(i).teamColor.equals("Blue")) teamBlue.add(robotsArray.get(i));
            else teamRed.add(robotsArray.get(i));
        }
        robotsArray.clear();
        robotsArray.addAll(teamBlue);
        robotsArray.addAll(teamRed);
    }
}
