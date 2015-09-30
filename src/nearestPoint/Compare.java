package nearestPoint;

/**
 * Created by pishilong on 15/9/30.
 */
public class Compare {
    public static void main(String args[]){
        int numbers[] = {10, 100, 1000, 10000, 100000};
        for (int number : numbers){
            Point[] points = Point.generateRandomPoints(number);
            BruteForce.performance(points);
            Nlgn.performance(points);
        }
    }
}
