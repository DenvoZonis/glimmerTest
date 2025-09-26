public class Task2 {
    public static void main(String[] args) {
        new Task2().print(5);
    }

    void print(int n) {
        //题目保证了n为奇数，既然如此此处就不对n做合法性校验了,此处n必须大于等于3且为奇数
        String str;
        for (int i = 1; i <= (n - 1) / 2; i++) {
            if (i == 1) {
                str = "%" + (n + 1) / 2 + "c\n";
                System.out.printf(str, '*');
            } else {
                str = "%" + ((n + 1) / 2 - (i - 1)) + "c%" + (2 * i - 2) + "c\n";
                System.out.printf(str, '*', '*');
            }
        }
        //最中间的一行
        str = "*%" + (n - 1) + "c\n";
        System.out.printf(str, '*');
        //接下来就把上面的翻转过来就行
        for (int i = 1; i <= (n - 1) / 2; i++) {
            if (i == (n - 1) / 2) {
                str = "%" + (n + 1) / 2 + "c\n";
                System.out.printf(str, '*');
            } else {
                str = "%" + (i + 1) + "c%" + (n - 2 * i - 1) + "c\n";
                System.out.printf(str, '*', '*');
            }
        }
    }
}
