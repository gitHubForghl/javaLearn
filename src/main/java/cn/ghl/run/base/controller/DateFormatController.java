package cn.ghl.run.base.controller;

import cn.ghl.run.base.User;
import cn.ghl.run.base.pojo.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tui
 */
@RestController
public class DateFormatController {

    /*
    在SpringMVC中Controller中方法参数为Date类型想要限定请求传入时间格式时，
    可以通过@DateTimeFormat来指定，但请求传入参数与指定格式不符时，会返回400错误
     */
    @GetMapping("/date")
    public String ok(User user) throws JsonProcessingException {
//        return user.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        return s;
    }

    @PostMapping("/post")
    public String postTest(@RequestParam String name, @RequestParam String id){
        return name+id;
    }

    @GetMapping("/json")
    public String getJson(Person person) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        return person.toString()+"--------------"+json;
    }
    @GetMapping("/jsonString")
    public String getJson() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String json="{\"name\":\"ghl\",\"id\":\"1002\"}";
        Person person = objectMapper.readValue(json, Person.class);
        return person.toString();
    }
}
