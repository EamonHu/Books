package chapter01;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/11/30 17:29
 */
public class RunnableTask implements Runnable{
    @Override
    public void run() {
        System.out.println("I am a child thread");
    }

    public static void main(String[] args) {
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
