package com.will.demo.start.controller;

import com.will.demo.api.dto.UserDTO;
import com.will.demo.api.service.UserService;
import com.will.demo.api.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Will.WT
 * @date 2022/10/21 00:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/get")
    public Result<UserDTO> getUser(@RequestParam Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/list")
    public Result<List<UserDTO>> queryUser(@RequestParam int offset, @RequestParam int pageSize){
        return userService.listUser(offset, pageSize);
    }

}
