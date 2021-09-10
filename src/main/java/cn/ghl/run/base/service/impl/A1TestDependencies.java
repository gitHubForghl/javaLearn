package cn.ghl.run.base.service.impl;

import cn.ghl.run.base.service.A1Test;
import org.springframework.stereotype.Component;

/**
 * @author tui
 */
@Component
public class A1TestDependencies {

    private A1Test a1Test;

    public A1TestDependencies(A1Test a1Test) {
        this.a1Test = a1Test;
    }

//    public A1TestDependencies(){}不能加无参构造方法

//    public A1Test getA1Test() {
//        return a1Test;
//    }
//
//    public void setA1Test(A1Test a1Test) {
//        this.a1Test = a1Test;
//    }

    public String a1TDMethod(){
        a1Test.a1Test();
        return "我是A1TestDependencies";
    }
}
