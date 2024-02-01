package com.zjj.zjojcodesandbox.security;

import java.security.Permission;

/**
 * @Classname DefaultSecurityManager
 * @Description Default Security Manager
 * @Author zjj
 * @Date 1/30/24 1:59 PM
 */
public class DefaultSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        System.out.println("No check of permission right now");
        System.out.println(perm);
        super.checkPermission(perm);
    }
}
