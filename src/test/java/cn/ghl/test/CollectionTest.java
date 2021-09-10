package cn.ghl.test;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author tui
 */
public class CollectionTest {

    @Test
    public void steamTest() {
        ArrayList<Object> list = new ArrayList<>();
//        IntStream.range(0, 10).forEach(System.out::println);

        IntStream.of(1, 2, 3, 4, 5)
                .filter(e -> e >= 3)
                .peek(value -> System.out.printf("filter element: %d\n", value))
                .mapToObj(String::valueOf)
                .forEach(System.out::println);

        String statu = "PM-支付信息维护审核?UP-核赔?BP-预赔?RO-重开?RC-报案注销?CC-立案注销?CR-立案拒赔?RU-退票审核?CI-理赔影像资料补传?CF-理赔费用审核";
        List<String> list2 = Convert.convert(new TypeReference<List<String>>() {
        }, statu);
        System.out.println("list2 = " + list2);
        String[] split = statu.split("\\?");
        System.out.println("split = " + Arrays.toString(split));
    }
}
