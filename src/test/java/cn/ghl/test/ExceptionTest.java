package cn.ghl.test;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestApp.class)
public class ExceptionTest {

    @Test
    public void exceptionTest(){
        try{
            System.out.println("开始");
            throw new RuntimeException("异常抛出！");//tryCatch后这句不会执行,执行catch,程序不会终止
//            System.out.println("再次输出！");
        }catch (Exception e){
            e.printStackTrace();
            while (true){
//                System.out.println(1);
            }
        }
    }

    @Test
    public void notDoExceptionTest(){
        System.out.println("开始");
        throw new RuntimeException("异常抛出！");//后面代码不可用，报错，程序终止
//        System.out.println("niupi");
    }
}
