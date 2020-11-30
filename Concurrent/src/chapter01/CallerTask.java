package chapter01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/11/30 17:31
 */
public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("child thread do something");
        return "hello,I'm done.";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            String res = futureTask.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
