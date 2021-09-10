package cn.ghl.othertest.halo;

import cn.ghl.run.TestApp;
import cn.ghl.run.base.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestApp.class)
public class StringTest {
    private int value=60_00;//6000
    private Integer a=60_000;//60000
    @Test
    public void stringTest(){
        System.out.println(value+a);
        User user=new User();
        user.setName("ghl");
        user.setId(1001);
        System.out.println(user);
    }
}
