package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC714_BestTimeToBuyAndSellStockWithTransactionFee {
    /**
     * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
     * <p>
     * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
     * <p>
     * Return the maximum profit you can make.
     * <p>
     * Example 1:
     * <p>
     * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * Output: 8
     * Explanation: The maximum profit can be achieved by:
     * Buying at prices[0] = 1
     * Selling at prices[3] = 8
     * Buying at prices[4] = 4
     * Selling at prices[5] = 9
     * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * <p>
     * Note:
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000.
     */

    // 判断这应该是个dp问题,第i天的收益取决于前i-1天的收益
    public static int getBestTimeToBuyAndSellStockWithTransactionFeeMy1(int[] prices, int fee) {
        int length = prices.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        return result;
    }

    // 操 Memory Limit Exceeded 存储空间放得太大了=.=MD
    public static int getBestTimeToBuyAndSellStockWithTransactionFeeMy2(int[] prices, int fee) {
        int length = prices.length;
        int result = 0;
        if (length <= 1) {
            return result;
        }
        int[][] dp = new int[length / 2 + 1][length]; // 用于保存前n天的最大收益
        for (int dealCount = 1; dealCount <= length / 2; dealCount++) {
            int cache = prices[0];
            for (int i = 1; i < length; i++) {
                dp[dealCount][i] = Math.max(dp[dealCount][i - 1], prices[i] - cache - fee);
                cache = Math.min(cache, prices[i] - dp[dealCount - 1][i - 1]);
            }
        }
        return dp[length / 2][length - 1];
    }

    /**
     * Up to this point, I believe you have finished the following series of stock problems:
     * <p>
     * 121. Best Time to Buy and Sell Stock
     * 122. Best Time to Buy and Sell Stock II
     * 123. Best Time to Buy and Sell Stock III
     * 188. Best Time to Buy and Sell Stock IV
     * 309. Best Time to Buy and Sell Stock with Cooldown
     * 714. Best Time to Buy and Sell Stock with Transaction Fee
     * <p>
     * For each problem, we've got a couple of excellent posts explaining how to approach it. However, most of the posts failed to identify the connections among these problems and made it hard to develop a consistent way of dealing with this series of problems. Here I will introduce the most generalized solution applicable to all of these problems, and its specialization to each of the six problems above.
     * <p>
     * I -- General cases
     * <p>
     * The idea begins with the following question: Given an array representing the price of stock on each day, what determines the maximum profit we can obtain?
     * <p>
     * Most of you can quickly come up with answers like "it depends on which day we are and how many transactions we are allowed to complete". Sure, those are important factors as they manifest themselves in the problem descriptions. However, there is a hidden factor that is not so obvious but vital in determining the maximum profit, which is elaborated below.
     * <p>
     * First let's spell out the notations to streamline our analyses. Let prices be the stock price array with length n, i denote the i-th day (i will go from 0 to n-1), k denote the maximum number of transactions allowed to complete, T[i][k] be the maximum profit that could be gained at the end of the i-th day with at most k transactions. Apparently we have base cases: T[-1][k] = T[i][0] = 0, that is, no stock or no transaction yield no profit (note the first day has i = 0 so i = -1 means no stock). Now if we can somehow relate T[i][k] to its subproblems like T[i-1][k], T[i][k-1], T[i-1][k-1], ..., we will have a working recurrence relation and the problem can be solved recursively. So how do we achieve that?
     * <p>
     * The most straightforward way would be looking at actions taken on the i-th day. How many options do we have? The answer is three: buy, sell, rest. Which one should we take? The answer is: we don't really know, but to find out which one is easy. We can try each option and then choose the one that maximizes our profit, provided there are no other restrictions. However, we do have an extra restriction saying no multiple transactions are allowed at the same time, meaning if we decide to buy on the i-th day, there should be 0 stock held in our hand; if we decide to sell on the i-th day, there should be exactly 1 stock held in our hand. The number of stocks held in our hand is the hidden factor mentioned above that will affect the action on the i-th day and thus affect the maximum profit.
     * <p>
     * Therefore our definition of T[i][k] should really be split into two: T[i][k][0] and T[i][k][1], where the former denotes the maximum profit at the end of the i-th day with at most k transactions and with 0 stock in our hand AFTER taking the action, while the latter denotes the maximum profit at the end of the i-th day with at most k transactions and with 1 stock in our hand AFTER taking the action. Now the base cases and the recurrence relations can be written as:
     * <p>
     * Base cases:
     * T[-1][k][0] = 0, T[-1][k][1] = -Infinity
     * T[i][0][0] = 0, T[i][0][1] = -Infinity
     * <p>
     * Recurrence relation:
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
     * T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])
     * <p>
     * For the base cases, T[-1][k][0] = T[i][0][0] = 0 has the same meaning as before while T[-1][k][1] = T[i][0][1] = -Infinity emphasizes the fact that it is impossible for us to have 1 stock in hand if there is no stock available or no transactions are allowed.
     * <p>
     * For T[i][k][0] in the recurrence relations, the actions taken on the i-th day can only be rest and sell, since we have 0 stock in our hand at the end of the day. T[i-1][k][0] is the maximum profit if action rest is taken, while T[i-1][k][1] + prices[i] is the maximum profit if action sell is taken. Note that the maximum number of allowable transactions remains the same, due to the fact that a transaction consists of two actions coming as a pair -- buy and sell. Only action buy will change the maximum number of transactions allowed (well, there is actually an alternative interpretation, see my comment below).
     * <p>
     * For T[i][k][1] in the recurrence relations, the actions taken on the i-th day can only be rest and buy, since we have 1 stock in our hand at the end of the day. T[i-1][k][1] is the maximum profit if action rest is taken, while T[i-1][k-1][0] - prices[i] is the maximum profit if action buy is taken. Note that the maximum number of allowable transactions decreases by one, since buying on the i-th day will use one transaction, as explained above.
     * <p>
     * To find the maximum profit at the end of the last day, we can simply loop through the prices array and update T[i][k][0] and T[i][k][1] according to the recurrence relations above. The final answer will be T[i][k][0] (we always have larger profit if we end up with 0 stock in hand).
     * <p>
     * II -- Applications to specific cases
     * <p>
     * The aforementioned six stock problems are classified by the value of k, which is the maximum number of allowable transactions (the last two also have additional requirements such as "cooldown" or "transaction fee"). I will apply the general solution to each of them one by one.
     * <p>
     * Case I: k = 1
     * <p>
     * For this case, we really have two unknown variables on each day: T[i][1][0] and T[i][1][1], and the recurrence relations say:
     * <p>
     * T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
     * T[i][1][1] = max(T[i-1][1][1], T[i-1][0][0] - prices[i]) = max(T[i-1][1][1], -prices[i])
     * <p>
     * where we have taken advantage of the base caseT[i][0][0] = 0 for the second equation.
     * <p>
     * It is straightforward to write the O(n) time and O(n) space solution, based on the two equations above. However, if you notice that the maximum profits on the i-th day actually only depend on those on the (i-1)-th day, the space can be cut down to O(1). Here is the space-optimized solution:
     * <p>
     * public int maxProfit(int[] prices) {
     * int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
     * <p>
     * for (int price : prices) {
     * T_i10 = Math.max(T_i10, T_i11 + price);
     * T_i11 = Math.max(T_i11, -price);
     * }
     * <p>
     * return T_i10;
     * }
     * <p>
     * Now let's try to gain some insight of the solution above. If we examine the part inside the loop more carefully, T_i11 really just represents the maximum value of the negative of all stock prices up to the i-th day, or equivalently the minimum value of all the stock prices. As for T_i10, we just need to decide which action yields a higher profit, sell or rest. And if action sell is taken, the price at which we bought the stock is T_i11, i.e., the minimum value before the i-th day. This is exactly what we would do in reality if we want to gain maximum profit. I should point out that this is not the only way of solving the problem for this case. You may find some other nice solutions here.
     * <p>
     * Case II: k = +Infinity
     * <p>
     * If k is positive infinity, then there isn't really any difference between k and k - 1 (wonder why? see my comment below), which implies T[i-1][k-1][0] = T[i-1][k][0] and T[i-1][k-1][1] = T[i-1][k][1]. Therefore, we still have two unknown variables on each day: T[i][k][0] and T[i][k][1] with k = +Infinity, and the recurrence relations say:
     * <p>
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
     * T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i]) = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
     * <p>
     * where we have taken advantage of the fact that T[i-1][k-1][0] = T[i-1][k][0] for the second equation. The O(n) time and O(1) space solution is as follows:
     * <p>
     * public int maxProfit(int[] prices) {
     * int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
     * <p>
     * for (int price : prices) {
     * int T_ik0_old = T_ik0;
     * T_ik0 = Math.max(T_ik0, T_ik1 + price);
     * T_ik1 = Math.max(T_ik1, T_ik0_old - price);
     * }
     * <p>
     * return T_ik0;
     * }
     * <p>
     * (Note: The caching of the old values of T_ik0, that is, the variable T_ik0_old, is unnecessary. Special thanks to 0x0101 and elvina for clarifying this.)
     * <p>
     * This solution suggests a greedy strategy of gaining maximum profit: as long as possible, buy stock at each local minimum and sell at the immediately followed local maximum. This is equivalent to finding increasing subarrays in prices (the stock price array), and buying at the beginning price of each subarray while selling at its end price. It's easy to show that this is the same as accumulating profits as long as it is profitable to do so, as demonstrated in this post.
     * <p>
     * Case III: k = 2
     * <p>
     * Similar to the case where k = 1, except now we have four variables instead of two on each day: T[i][1][0], T[i][1][1], T[i][2][0], T[i][2][1], and the recurrence relations are:
     * <p>
     * T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + prices[i])
     * T[i][2][1] = max(T[i-1][2][1], T[i-1][1][0] - prices[i])
     * T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
     * T[i][1][1] = max(T[i-1][1][1], -prices[i])
     * <p>
     * where again we have taken advantage of the base caseT[i][0][0] = 0 for the last equation. The O(n) time and O(1) space solution is as follows:
     * <p>
     * public int maxProfit(int[] prices) {
     * int T_i10 = 0, T_i11 = Integer.MIN_VALUE, T_i20 = 0, T_i21 = Integer.MIN_VALUE;
     * <p>
     * for (int price : prices) {
     * T_i20 = Math.max(T_i20, T_i21 + price);
     * T_i21 = Math.max(T_i21, T_i10 - price);
     * T_i10 = Math.max(T_i10, T_i11 + price);
     * T_i11 = Math.max(T_i11, -price);
     * }
     * <p>
     * return T_i20;
     * }
     * <p>
     * which is essentially the same as the one given here.
     * <p>
     * Case IV: k is arbitrary
     * <p>
     * This is the most general case so on each day we need to update all the maximum profits with different k values corresponding to 0 or 1 stocks in hand at the end of the day. However, there is a minor optimization we can do if k exceeds some critical value, beyond which the maximum profit will no long depend on the number of allowable transactions but instead will be bound by the number of available stocks (length of the prices array). Let's figure out what this critical value will be.
     * <p>
     * A profitable transaction takes at least two days (buy at one day and sell at the other, provided the buying price is less than the selling price). If the length of the prices array is n, the maximum number of profitable transactions is n/2 (integer division). After that no profitable transaction is possible, which implies the maximum profit will stay the same. Therefore the critical value of k is n/2. If the given k is no less than this value, i.e., k >= n/2, we can extend k to positive infinity and the problem is equivalent to Case II.
     * <p>
     * The following is the O(kn) time and O(k) space solution. Without the optimization, the code will be met with TLE for large k values.
     * <p>
     * public int maxProfit(int k, int[] prices) {
     * if (k >= prices.length >>> 1) {
     * int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
     * <p>
     * for (int price : prices) {
     * int T_ik0_old = T_ik0;
     * T_ik0 = Math.max(T_ik0, T_ik1 + price);
     * T_ik1 = Math.max(T_ik1, T_ik0_old - price);
     * }
     * <p>
     * return T_ik0;
     * }
     * <p>
     * int[] T_ik0 = new int[k + 1];
     * int[] T_ik1 = new int[k + 1];
     * Arrays.fill(T_ik1, Integer.MIN_VALUE);
     * <p>
     * for (int price : prices) {
     * for (int j = k; j > 0; j--) {
     * T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
     * T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
     * }
     * }
     * <p>
     * return T_ik0[k];
     * }
     * <p>
     * The solution is similar to the one found in this post. Here I used backward looping for the T array to avoid using temporary variables. It turns out that it is also possible to do forward looping without temporary variables, too.
     * <p>
     * Case V: k = +Infinity but with cooldown
     * <p>
     * This case resembles Case II very much due to the fact that they have the same k value, except now the recurrence relations have to be modified slightly to account for the "cooldown" requirement. The original recurrence relations for Case II are given by
     * <p>
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
     * T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
     * <p>
     * But with "cooldown", we cannot buy on the i-th day if a stock is sold on the (i-1)-th day. Therefore, in the second equation above, instead of T[i-1][k][0], we should actually use T[i-2][k][0] if we intend to buy on the i-th day. Everything else remains the same and the new recurrence relations are
     * <p>
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
     * T[i][k][1] = max(T[i-1][k][1], T[i-2][k][0] - prices[i])
     * <p>
     * And here is the O(n) time and O(1) space solution:
     * <p>
     * public int maxProfit(int[] prices) {
     * int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
     * <p>
     * for (int price : prices) {
     * int T_ik0_old = T_ik0;
     * T_ik0 = Math.max(T_ik0, T_ik1 + price);
     * T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
     * T_ik0_pre = T_ik0_old;
     * }
     * <p>
     * return T_ik0;
     * }
     * <p>
     * dietpepsi shared a very nice solution here with thinking process, which turns out to be the same as the one above.
     * <p>
     * Case VI: k = +Infinity but with transaction fee
     * <p>
     * Again this case resembles Case II very much as they have the same k value, except now the recurrence relations need to be modified slightly to account for the "transaction fee" requirement. The original recurrence relations for Case II are given by
     * <p>
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
     * T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
     * <p>
     * Since now we need to pay some fee (denoted as fee) for each transaction made, the profit after buying or selling the stock on the i-th day should be subtracted by this amount, therefore the new recurrence relations will be either
     * <p>
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
     * T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i] - fee)
     * <p>
     * or
     * <p>
     * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i] - fee)
     * T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
     * <p>
     * Note we have two options as for when to subtract the fee. This is because (as I mentioned above) each transaction is characterized by two actions coming as a pair -- buy and sell. The fee can be paid either when we buy the stock (corresponds to the first set of equations) or when we sell it (corresponds to the second set of equations). The following are the O(n) time and O(1) space solutions corresponding to these two options, where for the second solution we need to pay attention to possible overflows.
     * <p>
     * Solution I -- pay the fee when buying the stock:
     * <p>
     * public int maxProfit(int[] prices, int fee) {
     * int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
     * <p>
     * for (int price : prices) {
     * int T_ik0_old = T_ik0;
     * T_ik0 = Math.max(T_ik0, T_ik1 + price);
     * T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
     * }
     * <p>
     * return T_ik0;
     * }
     * <p>
     * Solution II -- pay the fee when selling the stock:
     * <p>
     * public int maxProfit(int[] prices, int fee) {
     * long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
     * <p>
     * for (int price : prices) {
     * long T_ik0_old = T_ik0;
     * T_ik0 = Math.max(T_ik0, T_ik1 + price - fee);
     * T_ik1 = Math.max(T_ik1, T_ik0_old - price);
     * }
     * <p>
     * return (int)T_ik0;
     * }
     * <p>
     * III -- Summary
     * <p>
     * In summary, the most general case of the stock problem can be characterized by three factors, the ordinal of the day i, the maximum number of allowable transactions k and the number of stocks in our hand at the end of the day. I have shown the recurrence relations for the maximum profits and their termination conditions, which leads to the O(nk) time and O(k) space solution. The results are then applied to each of the six cases, with the last two using slightly modified recurrence relations due to the additional requirements. I should mention that peterleetcode also introduced a nice solution here which generalizes to arbitrary k values. If you have a taste, take a look.
     * <p>
     * Hope this helps and happy coding!
     */

    public static int getBestTimeToBuyAndSellStockWithTransactionFeeAnswer1(int[] prices, int fee) {
        long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            long T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price - fee);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return (int) T_ik0;
    }

    /**
     * This problem is just like the other stock problems.
     * At given day, we can do 1 out of 4 things:
     * <p>
     * buy stock
     * hold stock
     * do nothing with empty portfolio
     * sell stock
     * <p>
     * We have 4 arrays with the length of # of the days, recording the max profit at given day if we do given operation.
     * <p>
     * Here is the code:
     */
    public static int getBestTimeToBuyAndSellStockWithTransactionFeeAnswer2(int[] prices, int fee) {
        int length = prices.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        int[] buy = new int[length];
        int[] hold = new int[length];
        int[] skip = new int[length];
        int[] sell = new int[length];
        // the moment we buy a stock, our balance should decrease
        buy[0] = 0 - prices[0];
        // assume if we have stock in the first day, we are still in deficit
        hold[0] = 0 - prices[0];
        for (int i = 1; i < length; i++) {
            // We can only buy on today if we sold stock
            // or skipped with empty portfolio yesterday
            buy[i] = Math.max(skip[i - 1], sell[i - 1]) - prices[i];
            // Can only hold if we bought or already holding stock yesterday
            hold[i] = Math.max(buy[i - 1], hold[i - 1]);
            // Can skip only if we skipped, or sold stock yesterday
            skip[i] = Math.max(skip[i - 1], sell[i - 1]);
            // Can sell only if we bought, or held stock yesterday
            sell[i] = Math.max(buy[i - 1], hold[i - 1]) + prices[i] - fee;
        }
        // Get the max of all the 4 actions on the last day.
        int max = Math.max(buy[length - 1], hold[length - 1]);
        max = Math.max(skip[length - 1], max);
        max = Math.max(sell[length - 1], max);
        return Math.max(max, 0);
    }
}
