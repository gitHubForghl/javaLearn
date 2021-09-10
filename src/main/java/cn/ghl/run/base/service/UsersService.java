package cn.ghl.run.base.service;

import cn.ghl.run.base.pojo.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UsersService extends IService<Users> {


    /**
     * @param start
     * @param end
     * @return
     */
    List<Users> findByCreatedTimeRange(String start, String end);
}
