package cn.ghl.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tui
 */
@SpringBootTest
public class GenericTest {

    @Test
    public void listGenericTest(){


        //List ：完全没有类型限制和赋值限定
        List list1=new ArrayList();
        list1.add(1);
        list1.add("1");


        //List<Object> list=new ArrayList<>();
        List<Object> list=list1;
        list.add("1");
        list.add(1);


        List<?> list2=new ArrayList<>();
//        list2.add("1");
//        list2.add(1);
    }
}
