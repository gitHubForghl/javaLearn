package cn.ghl.run.base.controller;

import cn.ghl.run.base.service.A1Test;
import cn.ghl.run.base.service.impl.A1TestDependencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tui
 */
@RestController
public class A1TestController {

    private A1Test a1Test;
    private A1TestDependencies dependencies;
//场景：
//    最近写代码需要在构造函数中调用一个本class的函数，而这个函数中用到了本class的@Autowired的变量。
//    于是觉得可能会出错。因为@Autowired一定要等本类构造完成后，才能从外部引用设置进来。
//    所以@Autowired的注入时间一定会晚于构造函数的执行时间。
//    那，这个局怎么破？
//官方推荐理由
//单一职责: 当使用构造函数注入的时候，你会很容易发现参数是否过多，
//这个时候需要考虑你这个类的职责是否过大，考虑拆分的问题；而当使用@Autowired注入field的时候，不容易发现问题
//依赖不可变: 只有使用构造函数注入才能注入final。
//另外，在使用构造器的使用能避免注入的依赖是空的情况。
//因为在bean的生命周期里面先执行的是bean的构造器，然后才给bean里面的属性赋值。


//依赖隐藏:使用依赖注入容器意味着类不再对依赖对象负责，
//获取依赖对象的职责就从类抽离出来，IOC容器会帮你自动装备。
//这意味着它应该使用更明确清晰的公用接口方法或者构造器，
//这种方式就能很清晰的知道类需要什么和到底是使用setter还是构造器
//降低容器耦合度: 依赖注入框架的核心思想之一是托管类不应依赖于所使用的DI容器。
//换句话说，它应该只是一个普通的POJO，只要您将其传递给所有必需的依赖项，就可以独立地实例化。
//这样，您可以在单元测试中实例化它，而无需启动IOC容器并单独进行测试（使用一个可以进行集成测试的容器）。
//如果没有容器耦合，则可以将该类用作托管或非托管类，甚至可以切换到新的DI框架。




//    public A1TestController(A1Test a1Test, A1TestDependencies dependencies) {
//        this.a1Test = a1Test;
//        this.dependencies = dependencies;
//    }

    @Autowired
    public void setA1Test(A1Test a1Test) {
        this.a1Test = a1Test;
    }

    @Autowired
    public void setDependencies(A1TestDependencies dependencies) {
        this.dependencies = dependencies;
    }


    @GetMapping("/a1Test")
    public String  a1Test(){
        a1Test.a1Test();
        return "ok";
    }

    @GetMapping("/a1TestDen")
    public String  a1TestDen(){
        return "ok"+"---"+dependencies.a1TDMethod();
    }
}
