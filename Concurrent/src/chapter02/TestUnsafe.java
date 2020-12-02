package chapter02;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/1 11:34
 */
public class TestUnsafe {
    /**
     * 获取Unsafe实例
     */
    static  final Unsafe unsafe;

    /**
     * 记录变量state在类TestUnsafe中的偏移量
     */
    static final long stateOffset;

    private volatile long state = 0;

/*    // 操作失败，由于TestUnsafe.class是由system类加载器加载的，而Unsafe类是rt.jar包提供的，需要指定Bootstrap类加载器
    // 双亲委派机制：1.防止类的重复加载  2.避免Java的核心API被修改
    static{
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }*/
    static{
        try {
            // 通过反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            // 暴力反射
            field.setAccessible(true);

            // 获取该变量的值
            unsafe =(Unsafe) field.get(null);

            // 获取state在TestUnsafe中的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnsafe test = new TestUnsafe();
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
