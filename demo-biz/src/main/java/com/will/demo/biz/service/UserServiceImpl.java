package com.will.demo.biz.service;

import com.will.demo.api.Result;
import com.will.demo.api.dto.UserDTO;
import com.will.demo.api.service.UserService;
import com.will.demo.biz.manager.UserManager;
import com.will.demo.dal.dataobject.UserDO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Will.WT
 * @date 2022/11/03 13:56
 */
@Service
@Validated
public class UserServiceImpl implements UserService {

    @Resource
    private UserManager userManager;

    @Override
    public Result<UserDTO> getUser(Long userId) {
        Result<UserDTO> result = new Result<>();

        UserDO userDO = userManager.getUser(userId);
        if (userDO != null){
            UserDTO target = new UserDTO();
            BeanUtils.copyProperties(userDO, target);
            result.setData(target);
        }

        return result;
    }

    @Override
    public Result<List<UserDTO>> listUser(int offset, int pageSize) {
        Result<List<UserDTO>> result = new Result<>();

        List<UserDO> userDOs = userManager.queryUser(offset, pageSize);
        if (CollectionUtils.isNotEmpty(userDOs)){
            result.setData(
                    userDOs.stream().map(userDO -> {
                        UserDTO target = new UserDTO();
                        BeanUtils.copyProperties(userDO, target);
                        return target;
                    }).collect(Collectors.toList())
            );
        }

        return result;
    }

}
