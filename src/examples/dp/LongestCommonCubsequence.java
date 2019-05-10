package examples.dp;

public class LongestCommonCubsequence {

    public static void main(String[] args) {

        s="leiliu";
        t="lqweileoui";

        longestCommonCubsequence();
        System.out.println(dp[s.length()][t.length()]);
    }

    public static String s;
    public static String t;

    public static int MAX_N = 100;
    public static int MAX_M = 100;
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 1];

    public static void longestCommonCubsequence() {
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j]+1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }

    }
}
