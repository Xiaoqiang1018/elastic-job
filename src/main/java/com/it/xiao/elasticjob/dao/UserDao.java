package com.it.xiao.elasticjob.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.xiao.elasticjob.pojo.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/7/29
 * @Version: 1.0
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<TUser> {

}
