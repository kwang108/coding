/**
 * Created by kkwang on 9/2/2014.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum
 * of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * sum[i][j] is the minimum sum of all numbers from grid[0][0] to grid[i][j], inclusively.
 * Then the DP formular becomes
 *   sum[i][j] = grid[i][j] + min( sum[i-1][j], sum[i][j-1] )
 */
public class MinSumPath {
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }
        for(int r = 1; r < m; r++) {
            for(int c = 1; c < n; c++) {
                sum[r][c] = grid[r][c] + Math.min(sum[r][c-1], sum[r-1][c]);
            }
        }
        return sum[m-1][n-1];
    }
}
