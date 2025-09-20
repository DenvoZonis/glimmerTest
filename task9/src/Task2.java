import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    public static void main(String[] args) {
        //直接复用Task1的PATH变量
        File source = new File(Task1.PATH + File.separator + "task9" + File.separator + "name.txt");
        File sorted = new File(Task1.PATH + File.separator + "name_sorted.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sorted), StandardCharsets.UTF_8))) {

            ArrayList<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String edited = line.trim();
                if (!edited.isEmpty()) {
                    list.add(edited);
                }
            }
            //按unicode排序
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
                if (i != list.size() - 1) {
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
