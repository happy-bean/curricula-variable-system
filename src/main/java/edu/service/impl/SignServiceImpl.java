package edu.service.impl;

import edu.common.Result;
import edu.model.UserDo;
import edu.service.SignService;

/**
 * 登陆层
 *
 * @author wgt
 * @date 17-12-3
 */
public class SignServiceImpl implements SignService {

    /**
     * 登陆
     *
     * @param signKey 登陆key
     * @return
     */
    @Override
    public Result<?> signIn(String signKey) {

        return null;
    }

    /**
     * 注销
     *
     * @param token
     * @return
     */
    @Override
    public Result<?> signOut(String token) {
        return null;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public Result<?> signUp(UserDo user) {
        return null;
    }
}
