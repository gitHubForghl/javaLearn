package cn.ghl.othertest.halo;


import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest(classes = TestApp.class)
public class InterfaceTest {
    @Test
    public void interfaceTest(){
        B b=new B();
        System.out.println(b.test("abc", "bcd", "efg"));
//        System.out.println(A.getA());
//        System.out.println("A.initA() = " + A.initA());
//        System.out.println("b.def() = " + b.def());

    }

    @Test
    public void enumTest(){
        System.out.println("meiju");
        D[] values = D.values();
        System.out.println("Arrays.asList(values).toString() = " + Arrays.asList(values).toString());
        D[] enumConstants = D.class.getEnumConstants();
        System.out.println("Arrays.asList(enumConstants).toString() = " + Arrays.asList(enumConstants).toString());
//        Enum
//        System.out.println("MFAType.NONE = " + MFAType.NONE);//NONE
//        System.out.println("MFAType.useMFA(MFAType.NONE) = " + MFAType.useMFA(MFAType.TFA_TOTP));
//        System.out.println(MFAType.values()[0].getValue());
    }
}
interface A{
    void set();

    static String getA() {
        return "你好牛蛙!";
    }
    static String initA(){
        return "初始化";
    }
    default String def(){
        return "666";
    }
}
class B implements A{

    @Override
    public void set() {
        this.def();
        def();
        A.initA();
    }

    String  test(String... str){
        return Arrays.asList(str).toString();
    }
}
enum D{
    E,
    F,
    G
}
enum MFAType {

    /**
     * Disable MFA auth.
     */
    NONE(0),//这里调用枚举构造方法,在使用枚举的时候，有几个枚举实例就执行几次构造方法

    /**
     * Time-based One-time Password (rfc6238).
     * see: https://tools.ietf.org/html/rfc6238
     */
    TFA_TOTP(1);


    private final Integer value;


    MFAType(Integer value) {
        this.value = value;
        System.out.println("枚举构造方法");
    }


    public static boolean useMFA(MFAType mfaType) {
        return mfaType != null && MFAType.NONE != mfaType;
    }

    public Integer getValue() {
        return value;
    }
}
interface MyInterface<DtoT,U>{

    default  <T extends DtoT> T test(U domain){
        return (T) this;
    }
}
