package cn.ghl.test;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

//@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApp.class)
public class AlibabaTest2 {

    //    @Test
    @org.junit.jupiter.api.Test
    public void loopToRemoveElementTest() {
        //测试在循环中删除集合元素
        List<String> removeList = new ArrayList<>();
        removeList.add("1");
        removeList.add("2");
        removeList.add("3");

//        Iterator<String> iterator = removeList.iterator();
//        while (iterator.hasNext()){
//            if ("1".equals(iterator.next())){
//                iterator.remove();
//            }
//        }


        for (String s : removeList) {
            if ("2".equals(s)) {
                //1   java.util.ConcurrentModificationException换2没问题
                removeList.remove(s);
            }
        }
        System.out.println(removeList);
    }


    @Test
    public void forEachTest() {
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");

        list.add("l1");
        list.add("l2");
        list.add("l3");

        set.add("s1");
        set.add("s2");
        set.add("s3");

        //测试map的forEach循环
        map.forEach((key, value) -> {
            System.out.println("key = " + key + ",value = " + value);
        });

        list.forEach(System.out::println);

        set.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ObjectToolImpl impl = new ObjectToolImpl();
        impl.test("A", new Object());

        System.out.println("----------------");
        ObjectTool oti = new ObjectToolImpl();
        oti.test("B", "C");

        ObjectTool<String, Object> objectTool = new ObjectToolImpl();
        objectTool.test("D", "F");
    }

    @Test
    public void compareIntegerObject() {
        //走缓存，对象相同值相同，所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较。
        Integer v60 = Integer.valueOf(60);
        Integer v60tow = Integer.valueOf(60);
        System.out.println("v60==v60tow = " + (v60 == v60tow));
        System.out.println("v60.equals(v60tow) = "+ v60.equals(v60tow));


        Integer v150 = Integer.valueOf(150);
        Integer v150tow = Integer.valueOf(150);
        System.out.println("v150==v150tow = " + (v150 == v150tow));
        System.out.println("v150.equals(v150tow) = " + v150.equals(v150tow));
    }

    @Test
    public void declareVariable() {
        String str;
        Date date;
        try {
            str = "123";
            date = new Date();
            System.out.println("date = " + date);
            System.out.println("str = " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface ObjectTool<T, U> {
    void test(T t, U u);
}

class ObjectToolImpl implements ObjectTool<String, Object>,Comparator {

    @Override
    public void test(String s, Object o) {
        System.out.println(s + "," + o);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
