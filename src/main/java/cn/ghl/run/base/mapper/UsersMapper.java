package cn.ghl.run.base.mapper;

import cn.ghl.run.base.pojo.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper extends BaseMapper<Users> {
    /**
     * 查询
     *
     * @param start
     * @param end
     * @return
     */
    List<Users> selectUsersByCreatedTimeRange(@Param("start") String start, @Param("end") String end);
}