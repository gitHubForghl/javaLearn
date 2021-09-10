package cn.ghl.othertest.halo;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.*;

@SpringBootTest(classes = TestApp.class)
public class CollectionTest {
    @Test
    public void collectionTest() throws ClassNotFoundException {
        List<String> list=new ArrayList<>();
        list.toArray(new String[0]);
        list.isEmpty();


        Set<String> set=new HashSet<>();
        set.toArray(new String[0]);

        Class<?> obj = Class.forName("cn.ghl.othertest.halo.B");

        Method[] methods = obj.getMethods();
    }
}
