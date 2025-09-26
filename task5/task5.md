## Task1

Q: 请你先创建一个java项目，该项目有一个主类（名字任意，里面有一个main函数作为程序入口），一个Person类，Person类的内容在下面已经给出。请你为这个Person类添加构造方法实现复制对象，并在题解附上你的Person类代码。你的构造方法用到this关键字了吗？请说说它的作用。

```java
public class Person {
    private String name;
    private int age;
    private int sex;

    private void eat() {
    	System.out.println(name+"正在吃东西");
    }

    private void sleep() {
    
    }

    private void dadoudou() {
    	
    }
}
```

A: 用到了。this就是指向当前对象的意思，通过this就能访问当前对象本身的变量等内容。

```java
public class Person {
    private String name;
    private int age, sex;

    private void eat() {
    	System.out.println(name+"正在吃东西");
    }
    private void sleep() {}

    private void dadoudou() {}

    //name,age,sex的getter省略

    /**
     * 一个默认的构造函数
     */
    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * 从一个同类对象复制一个新的对象的构造函数
     */
    public Person(Person sb) {
        this.name = sb.getName();
        this.age = sb.getAge();
        this.sex = sb.getSex();
    }
}
```

Q: 在主类的main方法中创建Person类的一个对象，并给它的字段赋值（可以用构造函数，也可以用引用变量）。说说对象和类的关系。

A: 对象就是通过各种方式（比如new，通过反射等）把类实例化的结果。类就是对象的定义，对象根据类而创建出来。

```java
public class Server {
    public static void main(String[] args) {
        Person student1 = new Person("学生A", 18, 0);
    }
}
```

Q: 为你的Person类的字段和方法添加你认为合适的访问修饰符。尝试在不同的位置（当前类，相同包的其它类，包的外部等）访问这些字段和方法，并总结出各种访问修饰符的限制范围。

A: 三种修饰符的用法:

| 修饰符       | 限制访问范围        |
|-----------|---------------|
| public    | 随便访问，无限制      |
| protected | 只有继承当前类等才能访问到 |
| private   | 只有自己才能访问      |

当然，这些在Java的反射机制面前其实都不是事。

```java
public class Person {
    private String name;
    private int age, sex;

    public void eat() {
    	System.out.println(name+"正在吃东西");
    }
    public void sleep() {}

    public void dadoudou() {}

    //name,age,sex的getter省略,且这些getter方法都为public非静态方法

    /**
     * 一个默认的构造函数
     */
    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * 从一个同类对象复制一个新的对象的构造函数
     */
    public Person(Person sb) {
        this.name = sb.getName();
        this.age = sb.getAge();
        this.sex = sb.getSex();
    }
}
```

## Task3

对象里面的变量和方法可以使用`static`修饰符修饰。被修饰的变量和方法可以在访问修饰符所规定的范围内直接访问，这些变量和方法分别叫静态变量和静态方法。一般而言，对象中的全局变量和工具类方法就是static的。

如果没有这个修饰符修饰，那么这个变量和方法只有在所在类被实例化之后才能被使用。对于这些方法而言，称之为实例方法，需要所在的类被实例化才能使用。