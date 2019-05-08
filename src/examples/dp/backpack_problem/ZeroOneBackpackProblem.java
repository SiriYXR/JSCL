package examples.dp.backpack_problem;

public class ZeroOneBackpackProblem {

    public static void main(String[] agrs) {


        n = 4;
        W = 5;
        w[0] = 2;
        v[0] = 3;
        w[1] = 1;
        v[1] = 2;
        w[2] = 3;
        v[2] = 4;
        w[3] = 2;
        v[3] = 2;

        init(-1);//记忆搜索初始化为-1
        System.out.println(zeroOne(0, W));

        init(0);//dp初始化为0
        zeroOne2();
        System.out.println(dp[0][W]);
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
    //Arrays.fill函数本质也是循环，并不能加速初始化且只能初始化一维数组
    public static void init(int v) {
        for (int i = 0; i <= MAX_N; i++)
            for (int j = 0; j <= MAX_W; j++)
                dp[i][j] = v;
    }

    //递归记忆搜索方法O(nW)
    public static int zeroOne(int i, int j) {
        if (dp[i][j] >= 0) {
            //已经经过计算的话直接使用之前的结果
            return dp[i][j];
        }
        int res;
        if (i == n) {
            //已经没有剩余物品了
            res = 0;
        } else if (j < w[i]) {
            //无法挑选这个物品
            res = zeroOne(i + 1, j);
        } else {
            //挑选和不挑选两种情况都尝试一下
            res = Math.max(zeroOne(i + 1, j), zeroOne(i + 1, j - w[i]) + v[i]);
        }
        return res;
    }

    //dp方法O(nW)
    public static void zeroOne2() {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
    }
}
