package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC119_PascalsTriangleII {
    /**
     * Given an index k, return the kth row of the Pascal's triangle.
     * <p>
     * For example, given k = 3,
     * Return [1,3,3,1].
     * <p>
     * Note:
     * Could you optimize your algorithm to use only O(k) extra space?
     */

    // 哇哦,菲波那切数列2哦
    // 算法考虑错误
    public static List<Integer> getPascalsTriangleIIMy1(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            list.add(1);
        } else if (rowIndex == 1) {
            list.add(1);
            list.add(1);
        } else {
            list.add(1);
            list.add(rowIndex);
            for (int i = 2; i < (rowIndex + 2) / 2; i++) {
                int cache = 0;
                for (int j = 0; j < list.get(i - 1); j++) {
                    cache += j;
                }
                list.add(cache);
            }
            int size = list.size() - ((rowIndex + 1) % 2);
            for (int i = size - 1; i >= 0; i--) {
                list.add(list.get(i));
            }
        }
        return list;
    }

    // 每个值等于前面值的叠加
    public static List<Integer> getPascalsTriangleIIAnswer1(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            // 设置每个值
            for (int j = i; j >= 1; j--) {
                // 计算对应值:叠加前面的全部数字
                // 这里的变化是这个list里面所有数字(除了第一个和最后一个)在每次j的for循环的时候都list(j)会进行叠加,
                // 而且叠加的正好是list(j-1)对应的值
                int cache = 0;
                if (list.size() > j) {
                    cache = list.get(j);
                    cache += list.get(j - 1);
                    list.set(j, cache);
                } else {
                    cache += list.get(j - 1);
                    list.add(cache);
                }
            }
        }
        return list;
    }
}
