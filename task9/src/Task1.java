import java.io.*;

public class Task1 {
    public static final String PATH = new File(Task1.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent();
    public static void main(String[] args) {
        //修改源文件和目标文件的位置!
        File origin = new File(PATH + File.separator + "task9" + File.separator + "doro.jpg");
        File dest = new File(PATH + File.separator + "doro_copy.jpg");
        try (FileInputStream fis = new FileInputStream(origin); FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] temp = new byte[1024];
            int len;
            while ((len = fis.read(temp)) != -1) {
                fos.write(temp, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
