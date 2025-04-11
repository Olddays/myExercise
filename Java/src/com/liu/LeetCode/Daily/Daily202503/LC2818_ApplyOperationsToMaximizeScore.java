package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC2818_ApplyOperationsToMaximizeScore {

    // https://leetcode.cn/problems/apply-operations-to-maximize-score/solutions/2385936/gong-xian-fa-dan-diao-zhan-pythonjavacgo-23c4/
    private static int maximumScoreAnswer1(List<Integer> nums, int k) {
        long MOD = (long) 1e9 + 7;
        int MX = (int) 1e5 + 1;
        int[] omega = new int[MX];
        for (int i = 2; i < MX; i++) {
            if (omega[i] == 0) { // i 是质数
                for (int j = i; j < MX; j += i) {
                    omega[j]++; // i 是 j 的一个质因子
                }
            }
        }
        int[] array = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            array[i] = nums.get(i);
        }
        int length = nums.size();
        int[] left = new int[length]; // 质数分数 >= omega[nums[i]] 的左侧最近元素下标
        int[] right = new int[length];// 质数分数 >  omega[nums[i]] 的右侧最近元素下标
        Arrays.fill(right, length);
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 方便赋值 left
        for (int i = 0; i < length; i++) {
            while (st.size() > 1 && omega[array[st.peek()]] < omega[array[i]]) {
                right[st.pop()] = i;
            }
            left[i] = st.peek();
            st.push(i);
        }

        Integer[] ids = new Integer[length];
        for (int i = 0; i < length; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> array[j] - array[i]);

        long ans = 1;
        for (int i : ids) {
            long tot = (long) (i - left[i]) * (right[i] - i);
            if (tot >= k) {
                ans = ans * pow(array[i], k) % MOD;
                break;
            }
            ans = ans * pow(array[i], (int) tot) % MOD;
            k -= tot; // 更新剩余操作次数
        }
        return (int) ans;
    }

    private static long pow(long x, int n) {
        long MOD = (long) 1e9 + 7;
        long res = 1L;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }

    //Compute the prime score of each integer in the array nums. For this, we can use a modified Sieve of Eratosthenes.
    //1.1. Initialize a boolean array, prime, of size upper, where upper is the maximum element in nums plus 1.
    //1.2. Initialize an integer array, primeScore, of size upper.
    //1.3. Set prime[0] and prime[1] to false.
    //1.4. For each integer i from 2 to upper-1, if prime[i] is true, increment primeScore[j] for all multiples j of i, and set prime[j] to false.
    //Use a monotonic stack to compute the next greater element with a greater prime score for each integer i in nums. We can do this both from the left and from the right for each i.
    //2.1. initialize two arrays, nextGreaterElement and prevGreaterOrEqualElement, of size n, where n is the length of nums.
    //2.2. Initialize an empty stack.
    //2.3. For each integer i in nums, repeat:
    //2.3.1. While the stack is not empty and the prime score of the integer at the top of the stack is less than or equal to the prime score of nums[i], pop the stack.
    //2.3.2. Set nextGreaterElement[j] to the index of the top of the stack if the stack is not empty, and to n otherwise, where j is the index of nums[i].
    //2.3.3. Push i onto the stack.
    //2.4. Reverse the order of nums and repeat steps 2.3.1 to 2.3.3 to compute prevGreaterOrEqualElement.
    //Sort the array tuples, which is an array of pairs of integers, where each pair (num, i) corresponds to the i-th element nums[i], in descending order of the first element in each pair.
    //Loop through the sorted array tuples.
    //4.1. Compute the number of operations, which is the minimum of (i - prevGreaterOrEqualElement[i]) * (nextGreaterElement[i] - i) and k, where i is the index of the current tuple.
    //4.2. Multiply res by the result of pow(num, operations) modulo MOD using the helper method pow.
    //4.3. Decrement k by the number of operations.
    //4.4. If k is 0, return res.
    //Return res.

    private static int maximumScoreAnswer2(List<Integer> nums, int k) {
        long MOD = (long) 1e9 + 7;
        int n = nums.size();
        int upper = Collections.max(nums) + 1;

        boolean[] prime = new boolean[upper];
        int[] primeScore = new int[upper];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i < upper; i++) {
            if (prime[i]) {
                for (int j = i; j < upper; j += i) {
                    primeScore[j]++;
                    prime[j] = false;
                }
            }
        }

        int[] nextGreaterElement = new int[n];
        Arrays.fill(nextGreaterElement, n);
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && primeScore[nums.get(i)] >= primeScore[nums.get(s.peek())]) {
                s.pop();
            }
            nextGreaterElement[i] = s.empty() ? n : s.peek();
            s.push(i);
        }

        int[] prevGreaterOrEqualElement = new int[n];
        Arrays.fill(prevGreaterOrEqualElement, -1);
        s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.empty() && primeScore[nums.get(i)] > primeScore[nums.get(s.peek())]) {
                s.pop();
            }
            prevGreaterOrEqualElement[i] = s.empty() ? -1 : s.peek();
            s.push(i);
        }

        int res = 1;
        int[][] tuples = new int[n][2];
        for (int i = 0; i < n; i++) {
            tuples[i][0] = nums.get(i);
            tuples[i][1] = i;
        }
        Arrays.sort(tuples, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        for (int i = 0; i < n; i++) {
            int num = tuples[i][0];
            int idx = tuples[i][1];
            int operations = Math.min((idx - prevGreaterOrEqualElement[idx]) * (nextGreaterElement[idx] - idx), k);
            res = (int) ((1L * res * pow(num, operations)) % MOD);
            k -= operations;
            if (k == 0) {
                return res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {8, 3, 9, 3, 8},
                {19, 12, 14, 6, 10, 18},
        };
        int[] kList = new int[]{
                2,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int num : numsList[i]) {
                nums.add(num);
            }
            startTime = System.currentTimeMillis();
            result = maximumScoreAnswer1(nums, kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumScore Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int num : numsList[i]) {
                nums.add(num);
            }
            startTime = System.currentTimeMillis();
            result = maximumScoreAnswer2(nums, kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumScore Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }

}
