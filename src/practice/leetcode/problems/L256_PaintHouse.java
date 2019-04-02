package practice.leetcode.problems;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1
 * with color green, and so on... Find the minimum cost to paint all houses.
 */
public class L256_PaintHouse {
    public static void main(String[] args) {
        int[][] costs = {
                {17, 2, 17},
                {16, 14, 5},
                {14, 3, 19}
        };

        // solution is 2+5+3=10
        System.out.println(new Solution().minCost(costs));
    }
}

class Solution {
    int minCost(int costs[][]) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        int m = costs.length - 1;
        return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
    }
}
