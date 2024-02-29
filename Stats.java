import java.util.ArrayList;

public class Stats {
    private Stats() {
        // this might be unnecessary
    }

    public static double calculateMean(ArrayList<Integer> array) {
        int total = 0;
        for (int i = 0; i < array.size(); i++) {
            total += array.get(i);
        }
        return (total / array.size());
    }

    public static double calculateSTD(ArrayList<Integer> array, double mean) {
        // calculate standard deviation of sample data

        double total = 0;
        for (int i = 0; i < array.size(); i++) {
            total += Math.sqrt(Math.pow(array.get(i) - mean, 2) / (array.size()));
        }
        return total;
    }
}
