package nearestPoint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by pishilong on 15/9/28.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public static Point[] generateRandomPoints(int num){
        Random random = new Random();
        Set<Point> points = new HashSet<Point>();
        int bound = num;
        while (num > 0) {
            points.add(new Point(random.nextInt(bound), random.nextInt(bound)));
            num --;
        }
        return points.toArray(new Point[0]);
    }

    public double getDistance(Point other){
        double distance = Math.pow((double)(this.x - other.getX()), 2.0) +
                Math.pow((double)(this.y - other.getY()), 2.0);
        return Math.sqrt(distance);
    }

    @Override
    public String toString(){
        return ("x: " + this.x + " ;y: " + this.y);
    }

    @Override
    public boolean equals(Object obj){
        if (obj.getClass() != this.getClass()) return false;
        Point point = (Point) obj;
        return (this.x == point.getX() && this.y == point.getY());
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result + x;
        result = prime*result + y;
        return result;
    }

    public static void main(String args[]){
        //Test equals
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.getDistance(p2));
        Point[] points = Point.generateRandomPoints(100);
        for (Point point: points){
            System.out.println(point);
        }
    }
}
