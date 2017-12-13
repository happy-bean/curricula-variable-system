package edu.service;

import edu.common.Result;
import edu.model.User;

/**
 * 登陆层
 *
 * @author wgt
 * @date 17-12-3
 */
public interface SignService {

    /**
     * 登陆
     *
     * @param signKey 登陆key
     * @return 用户对象
     */
    Result<User> signIn(String signKey);

    /**
     * 注销
     *
     * @param token token
     * @return ?
     */
    Result<?> signOut(String token);

    /**
     * 注册
     *
     * @param user 用户对象
     * @return 用户id
     */
    Result<Integer> signUp(User user);

    /**
     * 更改个人信息
     *
     * @param user 用户对象
     * @return 用户id
     */
    Result<Integer> update(User user);

}

