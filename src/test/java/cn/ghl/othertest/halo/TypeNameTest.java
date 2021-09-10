package cn.ghl.othertest.halo;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@SpringBootTest(classes = TestApp.class)
public class TypeNameTest {

    @Test
    public void typeNameTest() throws NoSuchFieldException {
        Field f = TypeNameC.class.getDeclaredField("map");
        Type type = f.getGenericType();//getGenericType泛型
        ParameterizedType p= (ParameterizedType) type;
        String typeName = p.getRawType().getTypeName();
        System.out.println(typeName);//java.util.Map
        System.out.println("p.getRawType() = " + p.getRawType());//interface java.util.Map
        System.out.println("p.getActualTypeArguments() = " + Arrays.asList(p.getActualTypeArguments()));//[class java.lang.String, class java.lang.Object]
        System.out.println("p.getOwnerType() = " + p.getOwnerType());
//        Collection
        System.out.println("TypeNameC.class.getGenericInterfaces() = " + Arrays.asList(TypeNameC.class.getGenericInterfaces()).toString());
        System.out.println("BaseA.class.getGenericInterfaces() = " + BaseA.class.getGenericInterfaces()[0]);//返回直接实现的接口（包含泛型参数）
    }
}
class TypeNameC implements BaseData<String>,BaseA{
    Map<String,Object> map;

    @Override
    public String get() {
        return null;
    }
}
interface BaseData<BASE>{
    BASE get();
}
interface BaseA extends BaseB<Integer>{

}
interface BaseB<B>{

}