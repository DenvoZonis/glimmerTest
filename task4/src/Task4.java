public class Task4 {
    public static void main(String[] args) {
        new Task4().hanoi(5);
    }

    /**
     * 打印n层汉诺塔的解题步骤，此处不检查n的有效性！
     * @param n 汉诺塔层数，应为一个正整数
     */
    void hanoi(int n) {
        hanoi0(n, 'A', 'B', 'C');
    }

    /**
     * 用于递归计算汉诺塔的内部函数，计算汉诺塔应使用hanoi()函数而不应该使用此函数！
     * @param n 汉诺塔层数
     * @param primaryStake 初始柱编号
     * @param temporaryStake 协助柱编号
     * @param targetStake 目标柱编号
     */
    void hanoi0(int n, char primaryStake, char temporaryStake, char targetStake) {
        if (n == 1) {
            System.out.println(primaryStake + "->" + targetStake);
        } else {
            hanoi0(n - 1, primaryStake, targetStake, temporaryStake);
            System.out.println(primaryStake + "->" + targetStake);
            hanoi0(n - 1, temporaryStake, primaryStake, targetStake);
        }
    }
}
