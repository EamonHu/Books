package chapter01;

/**
 * @Author: Eamon
 * @Description: 测试使用ThreadLocal
 * @Date: 2020/11/30 17:52
 */
public class ThreadLocalTest {
    /**
     * 创建ThreadLocal变量
     */
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str){
        // 1.打印当前线程本地内存中的变量
        System.out.println(str + ":" + localVariable.get());
        // 2.清除当前线程本地内存中的变量
        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable(){
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print("threadOne");
                System.out.println("threadOne remove after" + ":" + localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable(){
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("threadTwo remove after" + ":" + localVariable.get());
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}
