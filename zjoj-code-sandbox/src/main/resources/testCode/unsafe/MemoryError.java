import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MemoryError
 * @Description TODO
 * @Author zjj
 * @Date 1/30/24 11:53 AM
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> bytes = new ArrayList<>();
        while (true) {
            bytes.add(new byte[10000]);
        }
    }
}
