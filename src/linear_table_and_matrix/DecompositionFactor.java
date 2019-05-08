package linear_table_and_matrix;

public class DecompositionFactor {

    public static void main(String[] args) {


        for (int i = 1; i < 10000; i++) {
            int res1 = factorSum(i);
            int res2 = test(i);
            if (res1 != res2) {
                System.out.println("fuck");
                System.out.println(res1 + " " + res2 + " " + i);
            }
        }
    }

    public static int test(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                sum+=i;
        }
        return sum;
    }

    public static int factorNum(int n) {
        if (n <= 0)
            return -1;
        int tot = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int x = 0;
                while (n % i == 0) {
                    n /= i;
                    x++;
                }
                tot *= (x + 1);
            }
        }
        if (n > 1) tot *= 2;
        return tot;
    }

    public static int factorSum(int n) {
        if (n <= 0)
            return -1;
        int tot = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int mul = 1;
                while (n % i == 0) {
                    n /= i;
                    mul *= i;
                }
                tot *= (mul * i - 1) / (i - 1);
            }
        }
        if (n > 1) tot *= (n + 1);
        return tot;
    }
}
