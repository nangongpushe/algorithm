package cn.itcast06;

public class Code_05_MaxValue {
    //暴力递归
    public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag){
        if (alreadyweight > bag){
            return Integer.MIN_VALUE;
        }
        if (i == weights.length){
            return 0;
        }
        return Math.max(process1(weights, values, i + 1, alreadyweight, bag),
                values[i] + process1(weights, values, i + 1, alreadyweight + weights[i], bag));
    }

    //动态规划
    public static int maxValue2(int[] w, int[] p, int bag){
        int[][] dp = new int[w.length + 1][bag + 1];
        for (int i = w.length - 1; i >= 0; i--){
            for (int j = bag; j >= 0; j--){
                dp[i][j] = dp[i + 1][j];
                if (j + w[i] <= bag){
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + w[i]]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] c = {3, 2, 4, 7};
        int[] p = {5, 6, 3, 19};
        int bag = 12;
        System.out.println(process1(c, p, 0, 0, 12));
        System.out.println(maxValue2(c, p, 12));
    }
}
