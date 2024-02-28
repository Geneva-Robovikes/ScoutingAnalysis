public class Runner{
    public static void main(String[] args) {
        Robot robot = new Robot("fluffy","data.txt");
        System.out.println(robot.autoAmps);
        System.out.println(robot.autoSpeaker);
        System.out.println(robot.amps);
        System.out.println(robot.speaker);
    }
}