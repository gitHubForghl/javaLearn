package cn.ghl.othertest.halo;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.stream.Stream;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestApp.class)
public class AssertTest {
//    private String name;

    @Test
    public void assertTest(){
        System.out.println("AssertTest.test(\"123\") = " + AssertTest.test("123"));
        System.out.println("AssertTest.test(null) = " + AssertTest.test(null));
    }


    @NonNull
    public static String test(@NonNull String str){
//        Assert.assertNotNull("不能为空",str);
//        org.springframework.util.Assert.notNull(str,"不能是空！");
//        Stream<Integer> parallel = Stream.of(1, 1, 23, 3, 2).parallel();

        return "666"+str;
    }

    @Test
    public void optionalTest(){
//        Stream
        String name = "John";
        Optional<String> opt = Optional.ofNullable(null);
        assertEquals("John", opt.get());//java.util.NoSuchElementException: No value present
    }
}

