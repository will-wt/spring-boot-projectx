package com.will.demo.api.service;

import com.will.demo.api.Result;
import com.will.demo.api.dto.UserDTO;

import java.util.List;

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
    Result<UserDTO> getUser(Long userId);

    /**
     * 分页查询用户
     * @param offset
     * @param pageSize
     * @return
     */
    Result<List<UserDTO>> listUser(int offset, int pageSize);

}
