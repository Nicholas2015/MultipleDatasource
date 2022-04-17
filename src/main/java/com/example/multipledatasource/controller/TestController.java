package com.example.multipledatasource.controller;

import com.example.multipledatasource.mapper.first.UserMapper;
import com.example.multipledatasource.mapper.second.MemberVehicleMapper;
import com.example.multipledatasource.model.MemberVehicle;
import com.example.multipledatasource.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MemberVehicleMapper memberVehicleMapper;

    @GetMapping("/user")
    public List<User> getUserList(){
        return userMapper.selectUserList();
    }

    @GetMapping("/member")
    public List<MemberVehicle> getMembers() {
        return memberVehicleMapper.selectMemberVehicleList();
    }

}
