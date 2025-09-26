import java.io.*;

public class Task2 {
    private static final String PATH = new File(Task2.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent();
    public static void main(String[] args) throws FileNotFoundException, EmptyFileException {
        File file = new File(PATH + File.separator + "data.txt");
        //处理两个自定义Exception
        if (!file.exists()) {
            throw new FileNotFoundException("文件未找到!");
        } else if (file.length() == 0) {
            throw new EmptyFileException("文件为空!");
        }
        //读取文件并计数
        BufferedReader reader = null;
        int sum = 0, counter = 0;
        try {
            //我先做的Task9，并在里面使用了try-with-resources，所以这里我就用传统的try-catch-finally
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                sum += Integer.parseInt(line);
                counter++;
            }
            System.out.printf("平均值: %f\n", ((double) sum / counter));
        } catch (java.io.FileNotFoundException e) {
            //按道理说上面已经处理了文件是否存在的问题,此处不再处理
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("读取到的内容格式错误!出问题的位置:行" + ++counter);
        } finally {
            if  (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //所有代码执行结束，按道理不会再使用reader的其他方法了
                }
            }
        }
    }

    //两个自定义的Exception
    public static class FileNotFoundException extends Exception {
        public FileNotFoundException(String message) {
            super(message);
        }
    }
    public static class EmptyFileException extends Exception {
        public EmptyFileException(String message) {
            super(message);
        }
    }
}