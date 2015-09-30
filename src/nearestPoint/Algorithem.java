package nearestPoint;

import java.util.ArrayList;

/**
 * Created by pishilong on 15/9/30.
 */
public abstract class Algorithem {
    static ArrayList<Point> nearestPoint = new ArrayList<>();
    static double nearestDistance = Double.MAX_VALUE;
    static long timecost;

    public static void performace(Point[] points){}

    public void reset() {
        nearestDistance = Double.MAX_VALUE;
        nearestPoint.clear();
    }
}
