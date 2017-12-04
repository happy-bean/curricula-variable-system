package edu.controller;

import edu.common.Result;
import edu.common.ResultMess;
import edu.model.User;
import edu.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆控制层
 *
 * @author wgt
 * @date 17-12-3
 */
@RestController
@RequestMapping("/user")
public class SignController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SignService signService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    private Result<?> signIn(HttpServletRequest request) {
        String num = request.getParameter("num");
        String pass = request.getParameter("pass");
        String key = num + pass;
        Result<User> result = result = signService.signIn(key);
        if (result.getCode() == ResultMess.SUCCESS.getCode()) {
            request.getSession().setAttribute(num, result.getData().getuType());
        }
        return result;
    }
}
