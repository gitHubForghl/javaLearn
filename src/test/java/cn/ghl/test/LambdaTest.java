package cn.ghl.test;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestApp.class)
public class LambdaTest {

    @Test
    public void lambdaTest(){
        C c=A::b;
//        C c2=A::a;
        System.out.println("A::b = " + c.c());
    }
}
@FunctionalInterface
interface C{
    String c();
}
class A{
    public String a(){
        return "nb";
    }

    public static String b(){
        return "nha";
    }
}


class Test1 {
    public void a(Integer param1,int param2){
    }
    public static void main(String[] args) {
        MyInter m = (j,k,l)->j.a(k, l);
        MyInter m2=Test1::a;
        //第一个参数为方法目标，其余参数为参数,...
    }
}
@FunctionalInterface
interface MyInter {
    public void d(Test1 d,int param1,int param2);
}
