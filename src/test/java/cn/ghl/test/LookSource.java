package cn.ghl.test;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ServiceLoader;

@SpringBootTest(classes = TestApp.class)
public class LookSource {

    @Test
    public void look(){
//        Iterator
        ServiceLoader.load(String.class);
//        Optional
        System.out.println("kala\nlll");
//        Objects
//        String
//        Integer
    }
}
