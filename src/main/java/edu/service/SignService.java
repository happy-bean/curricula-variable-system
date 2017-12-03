package edu.service;

import edu.common.Result;
import edu.model.UserDo;

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
     * @return
     */
    Result<?> signIn(String signKey);

    /**
     * 注销
     *
     * @param token
     * @return
     */
    Result<?> signOut(String token);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    Result<?> signUp(UserDo user);

}

