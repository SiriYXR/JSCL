package number_theory;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static long factorial(long n) {
        if (n == 0)
            return 1;//0的阶乘为1
        else
            return factorial(n - 1) * n;
    }
}
