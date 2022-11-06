package com.will.demo.api.service;

import com.will.demo.result.Result;
import com.will.demo.api.dto.UserDTO;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    Result<UserDTO> getUser(@NotNull(message = "userId required") Long userId);

    /**
     * 分页查询用户
     * @param offset
     * @param pageSize
     * @return
     */
    Result<List<UserDTO>> listUser(@Min(value = 0, message = "offset invalid") int offset,
                                   @Range(min = 1, max = 30, message = "pageSize over range") int pageSize);

}
