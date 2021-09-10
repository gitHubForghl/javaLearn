package cn.ghl.run.base.service.impl;

import cn.ghl.run.base.pojo.User;
import cn.ghl.run.base.service.A1Test;
import org.springframework.stereotype.Service;

@Service
public class A1TestImpl implements A1Test {

//    private User user;
//
//    public A1TestImpl(User user) {spring容器内必须要有被注入对象的bean
//        this.user = user;
//    }

    @Override
    public void a1Test() {
        System.out.println("hello word!!");
    }
}
