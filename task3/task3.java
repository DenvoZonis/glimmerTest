import java.util.HashMap;
import java.util.Scanner;

/**
 * task3的task3的最后代码
 */
public class task3 {
    private static HashMap<String, HashMap<String, Integer>> totalMap = new HashMap<>(2);
    public static void main(String[] args) {
        //初始化map
        totalMap.put("Ming", new HashMap<String, Integer>());
        totalMap.put("Hong", new HashMap<String, Integer>());
        //向小明的map中添加数据并打印初始数据
        addData("math:5,English:10,Chinese:10,math:20,English:10,chemistry:30,math:10,math:20", totalMap.get("Ming"));
        print("Ming", totalMap);
        //获取小明下一次的数据(未校验输入是否合法)
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入小明的数据:");
        addData(scanner.nextLine(), totalMap.get("Ming"));
        print("Ming", totalMap);
        //获取小红的数据
        System.out.println("请输入小红的数据:");
        addData(scanner.nextLine(), totalMap.get("Hong"));
        print("Hong", totalMap);
        scanner.close();
    }

    /**
     * 用于添加数据的方法
     * @params data 数据源字符串
     * @params map 数据保存位置
     */
    private static void addData(String data, HashMap<String, Integer> map) {
        String[] splits = data.split(",");
        for (String split : splits) {
            String[] details = split.split(":");
            if (map.containsKey(details[0])) {
                map.put(details[0], map.get(details[0]) + Integer.parseInt(details[1]));
            } else {
                map.put(details[0], Integer.parseInt(details[1]));    
            } 
        }
    }

    /**
     * 用于打印用户错误最多科目的函数
     * @params name 用户名
     * @params totalMap 总的数据源
     */
    private static void print(String name, HashMap<String, HashMap<String, Integer>> totalMap) {
        final String[] subject = new String[1];
        final int[] times = {0};
        totalMap.get(name).forEach((k, v) -> {
            if (v > times[0]) {
                subject[0] = k;
                times[0] = v;
            }
        });
        System.out.printf("%s错误最多的是%s，错了%d\n", name, subject[0], times[0]);
    }
}