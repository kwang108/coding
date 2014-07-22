/**
 * Created by kkwang on 7/20/2014.
 *
 * Problem Definition:
 *
 * There are n coins in a line. (Assume n is even). Two players take turns to take a coin from one of the ends of the
 * line until there are no more coins left. The player with the larger amount of money wins.
 *
 * Would you rather go first or second? Does it matter?
 * Assume that you go first, describe an algorithm to compute the maximum amount of money you can win.
 */
public class CoinsMaxSum {
    /**
     * Solution:
     *
     * If you take Ai, and the remaining coins become { Ai+1 … Aj }. Considere the two coins the opponent will possibly take,
     * Ai+1 and Aj. If the opponent takes Ai+1, the remaining coins are { Ai+2 … Aj }, which our maximum is denoted by P(i+2, j).
     * On the other hand, if the opponent takes Aj, our maximum is P(i+1, j-1). Since the opponent is as smart as you,
     * he would have chosen the choice that yields the minimum amount to you.
     *
     * Therefore, the maximum amount you can get when you choose Ai is:
     * P1 = Ai + min { P(i+2, j), P(i+1, j-1) }
     * Similarly, the maximum amount you can get when you choose Aj is:
     * P2 = Aj + min { P(i+1, j-1), P(i, j-2) }
     *
     * P(i, j) = max {P1, P2}
     */

    private static int maxMoney(int[] coins) {
        int[][] P = new int[coins.length][coins.length];
        //We need to look at different ranges, 1 coin, 2 coins, 3, coins,... then n coins.
        //
        for(int end = 0; end < coins.length; end++) {
            for(int i = 0, j = end; j < coins.length; i++, j++) {
                int a = i+2 < coins.length ? P[i+2][j] : 0;
                int b = i+1 < coins.length && j-1 >= 0 ? P[i+1][j-1] : 0;
                int c = j-2 >= 0 ? P[i][j-2] : 0;
                int p1 = coins[i] + Math.min(a, b);
                int p2 = coins[j] + Math.min(b, c);
                P[i][j] = Math.max(p1, p2);
            }
        }
        return P[0][coins.length-1];
    }
}
