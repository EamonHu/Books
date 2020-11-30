import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/11/30 17:06
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
            System.out.println(current.nextInt(5));
        }
    }
}
