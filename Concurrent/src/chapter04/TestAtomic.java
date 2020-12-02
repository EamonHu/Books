package chapter04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Eamon
 * @Description: 双线程统计0的个数
 * @Date: 2020/12/1 15:22
 */
public class TestAtomic {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private static Integer[] arrayOne = new Integer[]{0,1,2,3,0,5,6,0,45,0};
    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,45,0};

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for (int i = 0; i < size; i++) {
                    if(arrayOne[i]==0){
                        atomicInteger.incrementAndGet();
                    }
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for (Integer integer : arrayTwo) {
                    if (integer == 0) {
                        atomicInteger.incrementAndGet();
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("0的数量是：" + atomicInteger.get());
    }
}
