package number_theory;

public class ModPow {

    public static void main(String[] args) {
        System.out.println(mod_pow(2,3,100000));
    }

    public static long mod_pow(long x, long n, long mod) {
        if (n == 0)
            return 1;
        long res = mod_pow(x * x, n / 2, mod);
        if ((n & 1) == 1)
            res = res * x % mod;
        return res;
    }
}
