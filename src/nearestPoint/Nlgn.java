package nearestPoint;


import java.util.*;

/**
 * Created by pishilong on 15/9/28.
 * Find the nearest point pair
 */
public class Nlgn extends Algorithem{

    public static void performance(Point[] points){
        long startTime = System.currentTimeMillis();
        //按照x轴排序，方便divide
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() < o2.getX()) return -1;
                if (o1.getX() > o2.getX()) return 1;
                if (o1.getY() < o2.getY()) return -1;
                if (o1.getY() > o2.getY()) return 1;
                return 0;
            }
        });

        findNearestDistance(points, 0, points.length - 1);
        System.out.println("min distance: " + nearestDistance);
        System.out.println("nearest points: ");
        for (Point point : nearestPoint){
            System.out.println(point);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("点数=" + points.length + ";Nlgn算法计算时间: " + (endTime - startTime) + "ms");
    }

    public static void main(String args[]){
        int pointNumber = 1000000;
        Point[] points = Point.generateRandomPoints(pointNumber);

        performance(points);
    }

    public static void findNearestDistance(Point[] points, int start, int end){
        // 处理递归树叶子节点
        if (start == end) return;
        if (end - start == 1) {
            double distance = points[start].getDistance(points[end]);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestPoint.clear();
                nearestPoint.add(points[start]);
                nearestPoint.add(points[end]);
            }
            return;
        }
        // divide
        int mid = (start + end - 1) / 2;
        // conquer
        findNearestDistance(points, start, mid);
        findNearestDistance(points, mid + 1, end);

        //开始处理跨界点
        ArrayList<Point> candiatePoints = new ArrayList<Point>();
        //找出离中线左右距离不超过minDis的点
        Point midPoint = points[mid];
        for (int s = start; s <= end; s++ ){
            if (Math.abs(midPoint.getX() - points[s].getX()) <= nearestDistance){
                candiatePoints.add(points[s]);
            }
        }
        //让候选点按y坐标升序排列
        Collections.sort(candiatePoints, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getY() < o2.getY()) return -1;
                if (o1.getY() > o2.getY()) return 1;
                if (o1.getX() < o2.getX()) return -1;
                if (o1.getX() > o2.getX()) return 1;
                return 0;
            }
        });

        //从最低点开始，计算与其他点的距离，如果y的距离超过了minDis，则无需继续往下
        for (int i = 0; i < candiatePoints.size(); i++){
            for (int j = i + 1; j < candiatePoints.size(); j++ ){
                if (candiatePoints.get(j).getY() - candiatePoints.get(i).getY() > nearestDistance ) break;
                double dis = candiatePoints.get(i).getDistance(candiatePoints.get(j));
                if (dis < nearestDistance){
                    nearestDistance = dis;
                    nearestPoint.clear();
                    nearestPoint.add(candiatePoints.get(i));
                    nearestPoint.add(candiatePoints.get(j));
                }
            }
        }
    }
}
