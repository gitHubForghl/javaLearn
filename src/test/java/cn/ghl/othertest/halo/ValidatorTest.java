package cn.ghl.othertest.halo;

import cn.ghl.run.TestApp;
import cn.ghl.run.base.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SpringBootTest(classes = TestApp.class)
public class ValidatorTest {

    @Test
    public void validatorTest(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        User user=new User();
        validator.validate(user).forEach(e->{
            Path path = e.getPropertyPath();
            System.out.println("e.getPropertyPath() = " + path);
        });
    }
}
