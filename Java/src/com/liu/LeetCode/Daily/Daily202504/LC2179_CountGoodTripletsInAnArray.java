package com.liu.LeetCode.Daily.Daily202504;

public class LC2179_CountGoodTripletsInAnArray {

    // First, map each number in nums1 to its position in nums2.
    //Then loop through nums1 to:
    //Count how many smaller values appeared before it in nums2 → left[i]
    //Count how many greater values appear after it → right[i]
    //Multiply left[i] * right[i] for all i → gives number of triplets with element i in the middle.
    // Beats 69.05%
    private static long goodTripletsAnswer1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];

        // Position map – where is each element in nums2?
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }

        long[] left = new long[n];
        int[] bit = new int[n + 2]; // extra room for classic off-by-one safety

        for (int i = 0; i < n; i++) {
            left[i] = query(bit, mapped[i]);
            update(bit, mapped[i] + 1, 1);  // 1-indexed... thanks BIT 🙃
        }

        long[] right = new long[n];
        bit = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            right[i] = query(bit, n) - query(bit, mapped[i] + 1);
            update(bit, mapped[i] + 1, 1);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += left[i] * right[i]; // Middle element magic
        }
        return res;
    }

    // BIT THOUGH 方法
    private static void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i;
        }
    }

    private static int query(int[] bit, int i) {
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= i & -i;
        }
        return res;
    }

    // Beats 100.00%
    private static long goodTripletsAnswer2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n], reversedIndexMapping = new int[n];

        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            reversedIndexMapping[pos2[nums1[i]]] = i;
        }

        FenwickTree tree = new FenwickTree(n);
        long res = 0;
        for (int value = 0; value < n; value++) {
            int pos = reversedIndexMapping[value];
            int left = tree.query(pos);
            tree.update(pos, 1);
            int right = (n - 1 - pos) - (value - left);
            res += (long) left * right;
        }
        return res;
    }

    // 二叉索引树
    private static class FenwickTree {
        private int[] tree;

        public FenwickTree(int size) {
            this.tree = new int[size + 1];
        }

        public void update(int index, int delta) {
            index++;
            while (index < tree.length) {
                this.tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++;
            int res = 0;
            while (index > 0) {
                res += this.tree[index];
                index -= index & -index;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] nums1List = new int[][]{
                {2, 0, 1, 3},
                {4, 0, 1, 3, 2},
        };
        int[][] nums2List = new int[][]{
                {0, 1, 2, 3},
                {4, 1, 0, 2, 3},
        };
        long[] resultList = new long[]{
                1,
                4,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = goodTripletsAnswer1(nums1List[i], nums2List[i]);
            endTime = System.currentTimeMillis();
            System.out.println("goodTriplets Answer1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nums1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = goodTripletsAnswer2(nums1List[i], nums2List[i]);
            endTime = System.currentTimeMillis();
            System.out.println("goodTriplets Answer2 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
