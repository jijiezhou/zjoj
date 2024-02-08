package com.zjj.zjojbackendserviceclient.service;

import com.zjj.zjojbackendcommon.common.ErrorCode;
import com.zjj.zjojbackendcommon.exception.BusinessException;
import com.zjj.zjojbackendmodel.model.entity.User;
import com.zjj.zjojbackendmodel.model.enums.UserRoleEnum;
import com.zjj.zjojbackendmodel.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

import static com.zjj.zjojbackendcommon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * User Open Feign
 */
@FeignClient(name = "zjoj-backend-user-service", path = "/api/user/inner")
public interface UserFeignClient {
    /**
     * GetById
     *
     * @param userId
     * @return
     */
    @GetMapping("/get/id")
    User getById(@RequestParam("userId") Long userId);

    /**
     * ListUserByIds
     *
     * @param idList
     * @return
     */
    @GetMapping("/get/ids")
    List<User> listByIds(@RequestParam("idList") Collection<Long> idList);

    /**
     * Get User Login
     *
     * @param request
     * @return user info after desensitification
     */
    default User getLoginUser(HttpServletRequest request) {
        // check if login
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        // Delete query from database -> from memory(session)
        return currentUser;
    }

    /**
     * Is Admin
     *
     * @param user
     * @return
     */
    default boolean isAdmin(User user) {
        return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
    }

    /**
     * User Info after desensitification
     *
     * @param user
     * @return
     */
    default UserVO getUserVO(User user) {
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

}
