// Find the K closest points to the origin in a 2D plane, given an array containing N points.



import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;

public static class Point { 
    double x;
    double y; 
    public Point(double a, double b) {
        x = a;
        y = b;
    }
}
public class kNearestPoint {
    public Point[] Solution(Point[] array, Point origin, int k) {
        Point[] rvalue = new Point[k];  
        int index = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point> (k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                return (int) (getDistance(b, origin) - getDistance(a, origin));
            }
        });

        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            rvalue[index++] = pq.poll();
        return rvalue;
    ｝

    private double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}
