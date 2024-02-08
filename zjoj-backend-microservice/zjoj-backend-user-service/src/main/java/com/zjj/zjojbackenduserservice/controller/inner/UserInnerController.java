package com.zjj.zjojbackenduserservice.controller.inner;

import com.zjj.zjojbackendmodel.model.entity.User;
import com.zjj.zjojbackendserviceclient.service.UserFeignClient;
import com.zjj.zjojbackenduserservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Classname UserInnerController
 * @Description Only provide for inner services, not send to frontend
 * @Author zjj
 * @Date 2/7/24 3:30 PM
 */
@RestController
@RequestMapping("/inner")
public class UserInnerController implements UserFeignClient {
    @Resource
    private UserService userService;
    /**
     * GetById
     *
     * @param userId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public User getById(@RequestParam("userId") Long userId){
        return userService.getById(userId);
    }

    /**
     * ListUserByIds
     *
     * @param idList
     * @return
     */
    @Override
    @GetMapping("/get/ids")
    public List<User> listByIds(@RequestParam("idList") Collection<Long> idList){
        return userService.listByIds(idList);
    }
}
