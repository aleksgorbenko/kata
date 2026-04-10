// https://leetcode.com/problems/fibonacci-number/description/
class P509_FibonacciNumberRecursive {
    public int fib(int n) {
        if (n <= 1) {
            return n; // BASE CASE
        }

        return fib(n - 1) + fib(n - 2);
    }
}