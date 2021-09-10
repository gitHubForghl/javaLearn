package cn.ghl.othertest.halo;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.NonNull;

@SpringBootTest(classes = TestApp.class)
public class NonNullTest {

    @Test
    public void nonNullTest(){
        System.out.println(test(null));
        System.out.println("test(\"ghl\") = " + test("ghl"));
    }
    @NonNull
    public String test(@NonNull String name){
        return name+"666";
    }
}