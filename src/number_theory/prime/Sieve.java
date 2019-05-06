package number_theory.prime;

public class Sieve {

    public static void main(String[] args) {

        System.out.println(sieve(1000000));//78498
    }

    public static int[] prime = new int[10000000];
    public static boolean[] is_prime = new boolean[1000000 + 1];

    public static int sieve(int n) {
        int p = 0;
        for (int i = 0; i <= n; i++) is_prime[i] = true;
        is_prime[0] = is_prime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (is_prime[i]) {
                prime[p++] = i;
                for (int j = 2 * i; j <= n; j += i) is_prime[j] = false;
            }
        }
        return p;
    }
}
