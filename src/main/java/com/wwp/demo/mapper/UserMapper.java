package com.wwp.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wwp.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author wwp
 * @Date 2019-10-31
 * @Version V1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
