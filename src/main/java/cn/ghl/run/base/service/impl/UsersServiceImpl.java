package cn.ghl.run.base.service.impl;

import cn.ghl.run.base.mapper.UsersMapper;
import cn.ghl.run.base.pojo.Users;
import cn.ghl.run.base.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {


    @Override
    public List<Users> findByCreatedTimeRange(String start, String end) {
        return baseMapper.selectUsersByCreatedTimeRange(start, end);
    }

}
