package cn.ghl.test;

import cn.ghl.run.base.pojo.User;

import java.util.Arrays;

/**
 * @author tui
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println("hello");
//        System.out.println("hello world");

        //包装类对应的parse方法测试（将String转换为对应包装类类型）
//        Double d=4.5d;
//        double doubleValue = d.doubleValue();
//        String str="11";
//        System.out.println("Double.parseDouble(str) = " + Double.parseDouble(str));

        //isEmpty>list.size==0
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        System.out.println(list.isEmpty());


        //split
        String str = "a.ab.abc";
        String str2 = "a:ab:abc";
//        String[] strings = str.split("\\.");
        String[] strings = str2.split("\\:");
        System.out.println(Arrays.toString(strings));
//        System.out.println(strings);
        User user=new User();
        user.setId(1);
        user.setName(null);
        System.out.println(user);
    }
}
