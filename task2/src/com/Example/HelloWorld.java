package com.Example;
/*------------------------------------*/
import com.Example.tool.Print;
/*------------------------------------*/
public class HelloWorld {
    public static void main(String[] args){
        Test.test();
    }
}
/*------------------------------------*/
class Test{
    public static void test(){
        Print.print("Hello World");
    }
}