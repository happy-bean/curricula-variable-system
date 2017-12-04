package edu.service.impl;

import edu.common.Result;
import edu.common.ResultMess;
import edu.dao.UserMapper;
import edu.model.User;
import edu.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登陆层
 *
 * @author wgt
 * @date 17-12-3
 */
@Service
public class SignServiceImpl implements SignService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    /**
     * 登陆
     *
     * @param signKey 登陆key
     * @return
     */
    @Override
    public Result<User> signIn(String signKey) {

        Result<User> result = new Result<>();

        try {
            User user = userMapper.selectByKey(signKey);
            if (user != null) {
                result.setCode(ResultMess.SUCCESS.getCode());
                result.setMess(ResultMess.SUCCESS.getMess());
                result.setData(user);
                logger.info("该用户查找成功 " + signKey);
            } else {
                result.setCode(ResultMess.ERROR.getCode());
                result.setMess(ResultMess.ERROR.getMess());
                logger.info("该用户查找失败 " + signKey);
            }
        } catch (Exception e) {
            logger.error("该用户查找失败 " + signKey, e);
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
        }
        return result;
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
    public Result<?> signUp(User user) {

        Result<?> result = new Result<>();

        try {
            int id = userMapper.insert(user);
            if (id > 0) {
                result.setCode(ResultMess.SUCCESS.getCode());
                result.setMess(ResultMess.SUCCESS.getMess());
                logger.info("该用户插入成功 " + user.getuNum());
            } else {
                result.setCode(ResultMess.ERROR.getCode());
                result.setMess(ResultMess.ERROR.getMess());
                logger.info("该用户插入失败 " + user.getuNum());
            }
        } catch (Exception e) {
            logger.error("该用户插入失败 " + user.getuNum(), e);
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
        }
        return result;
    }

    @Override
    public Result<?> update(User user) {
        Result<?> result = new Result<>();

        try {
            int id = userMapper.updateByPrimaryKey(user);
            if (id > 0) {
                result.setCode(ResultMess.SUCCESS.getCode());
                result.setMess(ResultMess.SUCCESS.getMess());
                logger.info("该用户更新成功 " + user.getuNum());
            } else {
                result.setCode(ResultMess.ERROR.getCode());
                result.setMess(ResultMess.ERROR.getMess());
                logger.info("该用户更新失败 " + user.getuNum());
            }
        } catch (Exception e) {
            logger.error("该用户更新失败 " + user.getuNum(), e);
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
        }
        return result;
    }
}
