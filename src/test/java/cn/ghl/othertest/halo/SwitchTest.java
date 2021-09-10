package cn.ghl.othertest.halo;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestApp.class)
public class SwitchTest {

    @Test
    public void switchTest(){
        String value = String.valueOf("dev1");
        switch (value){
            case "dev":
                System.out.println("dev");
                break;
            case "uat":
                System.out.println("uat");
                break;
            default:
                System.out.println("not");
        }
        switch (value){
            case "dev1","dev" -> System.out.println("dev");//一个break
            case "uat"-> System.out.println("uat");
            default -> System.out.println("not too");
        }
    }
}
