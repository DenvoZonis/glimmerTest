import java.util.HashMap;
import java.util.function.Consumer;

public class Task3 {
    public static void main(String[] args) {
        //存放三种对象的仓库
        Repository<String> strRepo = new MyRepository<>();
        Repository<User> usrRepo = new MyRepository<>();
        Repository<Integer> intRepo = new MyRepository<>();
        //随便来点数据
        User[] users = {new User("安艺伦也", 17),
                new User("加藤惠", 17),
                new User("泽村·斯宾塞·英梨梨", 16),
                new User("霞之丘诗羽", 16)};
        strRepo.save(users[0].name);
        strRepo.save(users[1].name);
        strRepo.save(users[2].name);
        strRepo.save(users[3].name);
        usrRepo.save(users[0]);
        usrRepo.save(users[1]);
        usrRepo.save(users[2]);
        usrRepo.save(users[3]);
        intRepo.save(users[0].age);
        intRepo.save(users[1].age);
        intRepo.save(users[2].age);
        intRepo.save(users[3].age);
        //遍历(使用方法引用)
        strRepo.forEach(System.out::println);
        usrRepo.forEach(System.out::println);
        intRepo.forEach(System.out::println);
    }

    /**
     * 创建的泛型接口
     * @param <T> 仓库存储的对象的类别
     */
    private interface Repository<T> {
        void save(T data);
        T getById(int id);
        void forEach(Consumer<? super T> consumer);
    }

    /**
     * 泛型接口的实现类
     * @param <T> 仓库存储的对象的类别
     */
    private static class MyRepository<T> implements Repository<T> {
        private final HashMap<Integer, T> map = new HashMap<>();
        int id = 0;

        @Override
        public void save(T data) {
            map.put(id, data);
            id++;
        }

        @Override
        public T getById(int id) {
            return map.getOrDefault(id, null);
        }

        @Override
        public void forEach(Consumer<? super T> consumer) {
            map.forEach((k, v) -> consumer.accept(v));
        }
    }

    /**
     * User类
     */
    private static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{name='" + name + "', age=" + age + "}";
        }
    }
}