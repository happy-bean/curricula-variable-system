package edu.controller;

import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.model.User;
import edu.model.UserModel;
import edu.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员控制层
 *
 * @author wgt
 * @date 17-12-13
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SignService signService;

    @RequestMapping(value = "/add_user", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<?> addUser(UserModel userModel, HttpServletResponse response) throws IOException {

        User user=new User();
        String key = userModel.getuNum() + userModel.getuPasswd();
        user.setuKey(key);
        user.setuGender(Integer.valueOf(userModel.getuGender()));
        user.setuGrade(Integer.valueOf(userModel.getuGrade()));
        user.setuMajor(userModel.getuMajor());
        user.setuPasswd(userModel.getuPasswd());
        user.setuName(userModel.getuName());
        user.setuNum(Integer.valueOf(userModel.getuNum()));
        user.setuType(Integer.valueOf(userModel.getuType()));
        signService.signUp(user);
        return null;

    }

    @RequestMapping(value = "/page_query_all",method = {RequestMethod.GET,RequestMethod.POST})
    public Result<PageInfo<User>> queryAllByPage(){

    }
}
