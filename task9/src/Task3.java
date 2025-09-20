import java.io.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        Student student = new Student(1, "doro", 2, "114514");
        //复用Task1的PATH
        File dat = new File(Task1.PATH + File.separator + "student.dat");
        if (!dat.exists()) {
            dat.createNewFile();
        } else {
            dat.delete();
            dat.createNewFile();
        }
        //序列化对象
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dat))) {
            oos.writeObject(student);
        }
        //反序列化对象
        Student doro;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dat))) {
            doro = (Student) ois.readObject();
            System.out.println(doro);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
