package com.zjj.zjojcodesandbox.security;

import java.security.Permission;

/**
 * @Classname DenySecurityManager
 * @Description Deny all permissions
 * @Author zjj
 * @Date 1/30/24 4:06 PM
 */
public class DenySecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        throw new SecurityException("permission error" + perm.toString());
    }
}
