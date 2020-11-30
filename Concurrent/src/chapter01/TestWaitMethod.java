package chapter01;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/11/30 17:37
 */
public class TestWaitMethod {
    /**
     * 创建资源A，B
     */
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA){
                        System.out.println("线程A获取资源A的锁");
                        synchronized (resourceB){
                            System.out.println("线程A获取资源B的锁");
                            System.out.println("线程A释放资源A的锁");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (resourceA){
                        System.out.println("线程B获取资源A的锁");
                        System.out.println("线程B试图获取资源B的锁");
                        synchronized (resourceB){
                            System.out.println("线程B获取资源B的锁");
                            System.out.println("线程B释放资源A的锁");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("主线程结束");
    }
}
