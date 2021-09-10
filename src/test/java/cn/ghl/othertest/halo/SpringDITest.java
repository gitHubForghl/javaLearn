package cn.ghl.othertest.halo;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest(classes = TestApp.class)
public class SpringDITest {

    @Test
    public void springDITest(){
//        A1Controller controller=new A1Controller()

    }
}
interface A1{
    void a1();
}
@Service
class A1Impl implements A1{

    @Override
    public void a1() {
        System.out.println("hello word");
    }
}
class A1Controller{
    private A1 a1;

    public A1Controller(A1 a1) {
        this.a1 = a1;
    }

    public void test(){
        a1.a1();
    }
}
