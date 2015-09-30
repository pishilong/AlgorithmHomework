package nearestPoint;

import java.util.ArrayList;

/**
 * Created by pishilong on 15/9/30.
 */
public class BruteForce extends Algorithem{
    public static void performance(Point[] points) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j ++ ){
                double distance = points[i].getDistance(points[j]);
                if (distance < nearestDistance){
                    nearestDistance = distance;
                    nearestPoint.clear();
                    nearestPoint.add(points[i]);
                    nearestPoint.add(points[j]);
                }
            }
        }
        System.out.println("min distance: " + nearestDistance);
        System.out.println("nearest points: ");
        for (Point point : nearestPoint){
            System.out.println(point);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("点数=" + points.length + ";BruteForce计算时间: " + (endTime - startTime) + "ms");
    }

    public static void main(String args[]){
        int pointNumber = 1000000;
        Point[] points = Point.generateRandomPoints(pointNumber);

        performance(points);
    }
}
