package cn.ghl.othertest.hutool;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest(classes = TestApp.class)
public class ArrayTest {

    @Test
    public void arrayTest(){
        Object[] arr=new Object[]{"abc",12,new Date()};
        Class<? extends Object[]> arrClass = arr.getClass();
        System.out.println(arrClass.getComponentType());//class java.lang.Object
        System.out.println(arrClass);//class [Ljava.lang.Object;

        Class<Object[]> aClass = Object[].class;
        Class<?> componentType = aClass.getComponentType();
        System.out.println(componentType);//class java.lang.Object
    }
}
