package chapter01;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/11/30 17:52
 */
public class ThreadLocalTest {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str){
        System.out.println(str + ":" + localVariable.get());
    }

    public static void main(String[] args) {
        System.out.println("haha");
    }
}
