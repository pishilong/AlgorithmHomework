package nearestPoint;

import util.DecimalHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by pishilong on 15/9/28.
 */
public class Point {
    private double x;
    private double y;
    private boolean selected;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
        this.selected = false;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public boolean getSelected() {return this.selected; }

    public void select() {
        this.selected = true;
    }

    public void unselect() {
        this.selected = false;
    }

    public static Point[] generateRandomPoints(int num){

        Set<Point> points = new HashSet<Point>();
        while (points.size() < num) {
            points.add(new Point(DecimalHandler.getFormattedRandomDouble(num, 2),
                    DecimalHandler.getFormattedRandomDouble(num, 2)));
        }
        return points.toArray(new Point[0]);
    }

    public double getDistance(Point other){
        double distance = Math.pow(this.x - other.getX(), 2.0) +
                Math.pow(this.y - other.getY(), 2.0);
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
        result = prime*result + Double.hashCode(x);
        result = prime*result + Double.hashCode(y);
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
