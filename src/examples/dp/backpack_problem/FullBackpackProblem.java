package examples.dp.backpack_problem;

import java.util.Arrays;

public class FullBackpackProblem {

    public static void main(String[] agrs) {

        n = 3;
        W = 7;
        w[0] = 3;
        v[0] = 4;
        w[1] = 4;
        v[1] = 5;
        w[2] = 2;
        v[2] = 3;

        init(0);
        full();
        System.out.println(dp[n][W]);

        Arrays.fill(dp2,0);
        full2();
        System.out.println(dp2[W]);
    }

    public static int MAX_N = 100;//物品个数
    public static int MAX_W = 1000;//背包重量
    public static int n;//物品个数
    public static int W;//背包容量
    public static int[] w = new int[MAX_N];//物品重量
    public static int[] v = new int[MAX_N];//物品价值

    //还未初始化，用之前一定要记得使用初始化
    public static int[][] dp = new int[MAX_N + 1][MAX_W + 1];

    //初始化dp矩阵
    public static void init(int v) {
        for (int i = 0; i <= MAX_N; i++)
            for (int j = 0; j <= MAX_W; j++)
                dp[i][j] = v;
    }

    public static void full() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
    }

    //只用一维数组
    public static int[] dp2 = new int[MAX_N + 1];
    public static void full2() {
        for (int i = 0; i < n; i++)
            for (int j = w[i]; j <= W; j++) {
                dp2[j] = Math.max(dp2[j], dp2[j - w[i]] + v[i]);
            }
    }
}
