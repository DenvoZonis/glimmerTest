public class Task4 {
    public static void main(String[] args) {
        new Task4().hanoi(5);
    }

    /**
     * 打印n层汉诺塔的解题步骤，此处不检查n的有效性！
     * @param n 汉诺塔层数，应为一个正整数
     */
    void hanoi(int n) {
        if (n == 1) {
            System.out.println("A->C");
        } else if (n == 2) {
            System.out.println("A->B");
            System.out.println("A->C");
            System.out.println("B->C");
        } else {
            hanoi(n - 2);
            System.out.println("A->B");
        }
    }
}
