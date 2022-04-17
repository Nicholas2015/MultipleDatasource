package com.example.multipledatasource.mapper.first;

import com.example.multipledatasource.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface UserMapper {

    @Select({"SELECT u.user_id AS userId,u.dept_id AS deptId,u.user_name AS userName,u.nick_name AS nickName,u.email,u.avatar,u.phonenumber,u.password,u.sex,u.status,u.del_flag AS delFlag,u.login_ip AS loginIp,u.login_date AS loginDate,u.create_by AS createBy,u.create_time AS createTime,u.remark FROM sys_user u"})
    List<User> selectUserList();
}
