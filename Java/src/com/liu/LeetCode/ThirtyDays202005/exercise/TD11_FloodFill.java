package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/11.
 */
public class TD11_FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int length = image.length;
        int wight = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            fillColor(image, sr, sc, length, wight, oldColor, newColor);
        }
        return image;
    }

    private static void fillColor(int[][] image, int sr, int sc, int length, int wight, int oldColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= length || sc >= wight) {
            return;
        }
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
        } else {
            return;
        }
        fillColor(image, sr - 1, sc, length, wight, oldColor, newColor); // 上
        fillColor(image, sr + 1, sc, length, wight, oldColor, newColor); // 下
        fillColor(image, sr, sc - 1, length, wight, oldColor, newColor); // 左
        fillColor(image, sr, sc + 1, length, wight, oldColor, newColor); // 右
    }
}
