package cn.ghl.test;


import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = TestApp.class)
public class StreamTest {

    @Test
    public void streamTest(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        numbers.parallelStream()
//                .forEach(System.out::println);

        List<Integer> list = numbers.stream().filter(e -> numbers.indexOf(e) > 3)
                .collect(Collectors.toList());
        list.forEach(System.out::print);
//        ForkJoinTask
//        int i = Integer.parseInt("11");
    }
}
