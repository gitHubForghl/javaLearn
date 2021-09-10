package cn.ghl.run.base.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tui
 * @date
 */
public class AlibabaTest {
    public static void main(String[] args) {
        String[] str = new String[]{"you", "wu"};
//        List<Integer> list = Arrays.asList(new Integer[]{1, 3});
        str[0] = "abc";
        str[0] = "bcd";
        //返回的list还是数组不能操作list的add的Api
//        List<String> listAddE = Arrays.asList("a", "b");
        List<String> list = Arrays.asList(str);
//        boolean result = list.add("cd");
        String str0 = list.get(0);
        System.out.println(str0);
//        System.out.println(result);
        List<String> arrList = new ArrayList<>();
        arrList.add("2");
        arrList.add("3");
        System.out.println("list:" + list);


    }
}
