import com.study_demo.ZStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Description
 * @Author Zhang hao yu
 * @Date 2025/2/14 11:13
 */
public class Tester {
    static List<String> list = new ArrayList<>();
    static {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(null);
    }

    @Test
    public void test() {
//        ZStream.of(list).foreach(System.out::println);
//        List<String> newList = ZStream.of(list).toList();
//        System.out.println(newList);
        ZStream.of(list).whereNotNull(Function.identity()).foreach(System.out::println);
    }
}
