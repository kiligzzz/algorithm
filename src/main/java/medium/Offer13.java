package medium;

import support.Kiligz;
import type.DFS;
import type.Recursive;

/**
 * 机器人的运动范围
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * @author Ivan
 * @since 2023/5/30
 */
public class Offer13 implements DFS, Recursive {
    public static void main(String[] args) {
        Kiligz.print(new Offer13().movingCount(2, 3, 1));
    }

    boolean[][] used;
    int m;
    int n;
    int k;

    public int movingCount(int m, int n, int k) {
        this.used = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n
                || used[i][j]
                || sum(i, j) > k)
            return 0;

        used[i][j] = true;

        return dfs(i - 1, j)
                + dfs(i + 1, j)
                + dfs(i, j - 1)
                + dfs(i, j + 1)
                + 1;
    }

    private int sum(int i, int j) {
        int kc = 0;
        while (i != 0 || j != 0) {
            kc += i % 10 + j % 10;
            i /= 10;
            j /= 10;
        }
        return kc;
    }
}
