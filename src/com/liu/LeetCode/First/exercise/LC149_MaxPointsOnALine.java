package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC149_MaxPointsOnALine {
    /**
     * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
     */
    /**
     * Definition for a point.
     * class Point {
     * int x;
     * int y;
     * Point() { x = 0; y = 0; }
     * Point(int a, int b) { x = a; y = b; }
     * }
     */
    public static class Point {
        public int x;
        public int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    // 这个应该算一个DP问题
    // 无法处理这样的问题:{0, 0}, {-1, -1}, {2, 2},三个点相互是一样的,导致会画出三条线,然后就会导致size++三次,最后会多一个
    public static int getMaxPointsOnALineMy1(Point[] points) {
        int length = points.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        Map<Double, Map<Double, Integer>> map = new HashMap<>(); // key: 斜率, value: 位移
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                double slope = getPointSlope(points[i], points[j]);
                double distance = points[i].y - slope * points[i].x;
                Map<Double, Integer> cache;
                if (map.containsKey(slope)) {
                    cache = map.get(slope);
                    int size = 1;
                    if (cache.containsKey(distance)) {
                        size += cache.get(distance);
                    }
                    cache.put(distance, size);
                } else {
                    cache = new HashMap<>();
                    cache.put(distance, 2);
                }
                map.put(slope, cache);
            }
        }
        int result = 0;
        for (Map.Entry<Double, Map<Double, Integer>> entry : map.entrySet()) {
            for (Map.Entry<Double, Integer> cache : entry.getValue().entrySet()) {
                result = Math.max(cache.getValue(), result);
            }
        }
        return result;
    }

    private static double getPointSlope(Point a, Point b) {
        int divisor = a.y - b.y;
        int dividend = a.x - b.x;
        if (divisor != 0) {
            return (double) dividend / (double) divisor;
        } else {
            return 0;
        }
    }

    // 这个应该算一个DP问题 但是本方法无法处理相同点的情况,即输入{0,0},{1,1},{0,0}
    public static int getMaxPointsOnALineMy2(Point[] points) {
        int length = points.length;
        if (length <= 2) { // 当小于等于两个点的时候,没有必要处理
            return points.length;
        }
        Map<Double, Map<Double, Integer>> map = new HashMap<>(); // key: 斜率, value: 位移
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                double slope = getPointSlope(points[i], points[j]);
                double distance = points[i].y - slope * points[i].x;
                Map<Double, Integer> cache;
                if (map.containsKey(slope)) {
                    cache = map.get(slope);
                    int size = 1;
                    if (cache.containsKey(distance)) {
                        size += cache.get(distance);
                    }
                    cache.put(distance, size);
                } else {
                    cache = new HashMap<>();
                    cache.put(distance, 1);
                }
                map.put(slope, cache);
            }
        }
        int result = 2; // 此时最小两个点
        for (Map.Entry<Double, Map<Double, Integer>> entry : map.entrySet()) {
            for (Map.Entry<Double, Integer> cache : entry.getValue().entrySet()) {
                result = Math.max(cache.getValue(), result);
            }
        }
        return result;
    }

    /**
     * A line is determined by two factors,say y=ax+b
     * If two points(x1,y1) (x2,y2) are on the same line(Of course).
     * <p>
     * Consider the gap between two points.
     * <p>
     * We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant
     * If a third point (x3,y3) are on the same line. So we must have y3=ax3+b
     * Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
     * Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
     * So we can use y0&x0 to track a line;
     */
    public static int getMaxPointsOnALineAnswer1(Point[] points) {
        if (points == null) return 0;
        int length = points.length;
        if (length <= 2) {
            return length;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < length; i++) {
            map.clear();
            int overlap = 0; // 相同点
            int max = 0;
            for (int j = i + 1; j < length; j++) {
                int x = points[j].x - points[i].x; // 三角形的直角边(竖)
                int y = points[j].y - points[i].y; // 三角形的直角边(横)
                if (x == 0 && y == 0) {
                    // 同一个点
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y); // 最大公约数
                if (gcd != 0) {
                    // 规约,即尝试获取正切
                    x /= gcd;
                    y /= gcd;
                }
                Map<Integer, Integer> cache;
                int size = 1;
                if (map.containsKey(x)) {
                    cache = map.get(x);
                    if (cache.containsKey(y)) {
                        size += cache.get(y);
                    }
                } else {
                    cache = new HashMap<>();
                }
                cache.put(y, size);
                map.put(x, cache);
                max = Math.max(max, cache.get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private static int generateGCD(int a, int b) {
        // 最大公约数
        if (b == 0) {
            return a;
        } else {
            return generateGCD(b, a % b);
        }
    }
}
