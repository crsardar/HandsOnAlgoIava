public class Fibonacchi {

    // 0, 1, 1, 2, 3, 5, 8

    public static void main (String args[])
    {
        System.out.println(fib(1));
    }

    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }
}
