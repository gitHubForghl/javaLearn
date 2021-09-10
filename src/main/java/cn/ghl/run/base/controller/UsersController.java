package cn.ghl.run.base.controller;

import cn.ghl.run.base.pojo.Users;
import cn.ghl.run.base.service.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ghl
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public String addUsers(@RequestBody Users users) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return usersService.save(users) + "," + "users对象:" + users.toString() + "再转json：" + objectMapper.writeValueAsString(users);
    }

    @GetMapping("/get/{start}/{end}")
    public String getUsers(@PathVariable("start") String start, @PathVariable("end") String end) {
        List<Users> list = usersService.findByCreatedTimeRange(start, end);
        return list.toString();
    }
}
