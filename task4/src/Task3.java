public class Task3 {
    public static void main(String[] args) {
        //使用递归实现的版本
        System.out.println(new Recursion().Fibonacci(10));
        //使用迭代实现的版本
        System.out.println(new Iteration().Fibonacci(10));
    }

    private interface FibonacciInterface {
        /**
         * 斐波拉契数列根据项数获取元素
         * @param n 斐波拉契数列的目标元素的位置
         * @return 数列对应位置的元素
         */
        int Fibonacci(int n);
    }

    /**
     * 使用递归实现的版本
     */
    private static class Recursion implements FibonacciInterface {
        @Override
        public int Fibonacci(int n) {
            //不检查n是否为正整数
            if (n > 2) {
                return Fibonacci(n - 1) + Fibonacci(n - 2);
            } else {
                return 1;
            }
        }
    }

    /**
     * 使用迭代实现的版本
     */
    private static class Iteration implements FibonacciInterface {
        @Override
        public int Fibonacci(int n) {
            int beforeLast = 1, last = 0, temp;
            for (int i = 1; i <= n; i++) {
                temp = last;
                last = beforeLast + last;
                beforeLast = temp;
            }
            return last;
        }
    }
}
