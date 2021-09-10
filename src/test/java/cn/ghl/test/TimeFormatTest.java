package cn.ghl.test;

import cn.ghl.run.TestApp;
import cn.ghl.run.base.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest(classes = TestApp.class)
public class TimeFormatTest {

    @Test
    public void formatTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = "{\"date\":\"2022-08-11\"}";
        User user = objectMapper.readValue(str, User.class);
        System.out.println("user = " + user);
    }

    @Test
    public void strTest() {
        String str = "";
        System.out.println("str==null = " + str == null);//false
    }
}
