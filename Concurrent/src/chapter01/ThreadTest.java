package chapter01;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/11/30 17:26
 */
public class ThreadTest {

    public static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("I am a  child thread");
        }
    }

    public static void main(String[] args) {
        // 创建线程
        MyThread thread = new MyThread();
        //启动线程
        thread.start();
    }
}
