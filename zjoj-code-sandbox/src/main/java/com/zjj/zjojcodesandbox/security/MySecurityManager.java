package com.zjj.zjojcodesandbox.security;

import javax.crypto.SecretKeyFactory;
import java.security.Permission;

/**
 * @Classname MySecurityManager
 * @Description TODO
 * @Author zjj
 * @Date 1/30/24 4:10 PM
 */
public class MySecurityManager extends SecurityManager {
    /**
     * check all permissions
     *
     * @param perm the requested permission.
     */
    @Override
    public void checkPermission(Permission perm) {
        //        super.checkPermission(perm);
    }

    /**
     * check program can execute file or not
     *
     * @param cmd the specified system command.
     */
    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("checkExec permission error: " + cmd);
    }

    /**
     * check program can read files or not
     *
     * @param file the system-dependent filename.
     */
    @Override
    public void checkRead(String file) {
        //throw new SecurityException("checkRead permission error: " + file);
    }

    /**
     * check program can write files or not
     *
     * @param file the system-dependent filename.
     */
    @Override
    public void checkWrite(String file) {
        throw new SecurityException("checkWrite permission error: " + file);
    }

    /**
     * check program can delete files or not
     *
     * @param file the system-dependent filename.
     */
    @Override
    public void checkDelete(String file) {
        throw new SecurityException("checkDelete permission error: " + file);
    }

    /**
     * check files can connect to internet or not
     *
     * @param host the host name port to connect to.
     * @param port the protocol port to connect to.
     */
    @Override
    public void checkConnect(String host, int port) {
        throw new SecurityException("checkConnect permission error: " + host + ":" + port);
    }
}
