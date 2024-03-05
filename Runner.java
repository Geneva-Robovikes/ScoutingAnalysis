import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<Match> matchesArray = new ArrayList<>();
        Match match7 = new Match(7,"stresstest.txt");
        matchesArray.add(match7);
        Match match54 = new Match(54,"stresstest.txt");
        matchesArray.add(match54);
        Match match2 = new Match(2,"stresstest.txt");
        matchesArray.add(match2);
        Match match11 = new Match(11,"stresstest.txt");
        matchesArray.add(match11);
        for (Match match : matchesArray){
            PrintWriter writer = new PrintWriter("output\\Match"+match.number, "UTF-8");
            writer.write("Team Name,Team Color,Auto: Notes in Amp Scored,Auto: Notes in Speaker Scored,Auto: Left Starting Area,Teleop: Notes in Amp Scored,Teleop: Notes in Speaker Scored,Teleop: Shots Missed,Teleop: Completed Climb,Teleop: Completed Trap,Teleop: Broke Down but Restarted,Teleop: Broke Down not restarted\n");
            for (RobotMatch robot : match.robotsArray){
                writer.write(
                    robot.teamName + "," +
                    robot.teamColor + "," + 
                    robot.autoAmpsScored + "," +
                    robot.autoSpeaker + "," +
                    robot.autoLeftStartingArea + "," +
                    robot.teleopAmpsScored + "," +
                    robot.teleopSpeakerScored + "," +
                    robot.teleopShotsMissed + "," +
                    robot.teleopClimb + "," +
                    robot.teleopTrap + "," +
                    robot.teleopBrokeDown + "," +
                    robot.teleopBrokeDownRestarted + ","  + "\n"
                );
            }
            writer.close();
        }
    }
}