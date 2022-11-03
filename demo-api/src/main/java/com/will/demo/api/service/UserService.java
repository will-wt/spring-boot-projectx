package com.will.demo.api.service;

import com.will.demo.api.dto.UserDTO;

/**
 * @author Will.WT
 * @date 2022/11/02 10:42
 */
public interface UserService {

    /**
     * 查询某个用户
     * @param userId
     * @return
     */
    UserDTO getUser(Long userId);


}
