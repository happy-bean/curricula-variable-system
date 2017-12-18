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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    /**
     * 登陆跳转
     *
     * @param response 响应
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<?> login(HttpServletResponse response) throws IOException {

        response.sendRedirect("/login/login.html");
        return null;
    }

    /**
     * 登陆
     *
     * @param num     账号
     * @param pass    密码
     * @param request 请求
     * @return 跳转地址
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public Result<String> signIn(String num, String pass, HttpServletRequest request) {
        Result<String> baseResult = new Result<>();

        String key = num + pass;
        Result<User> result = signService.signIn(key);
        baseResult.setCode(result.getCode());
        baseResult.setMess(result.getMess());

        User user = result.getData();
        if (result.getCode() == ResultMess.SUCCESS.getCode()) {
            request.getSession().setAttribute("userType", user.getuType()+"&"+user.getId());

            String indexUrl = "";

            switch (user.getuType()) {

                /**
                 * 管理员
                 * */
                case 1:
                    indexUrl = "/admin/admin_index.html";
                    break;

                /**
                 * 教师
                 * */
                case 2:
                    indexUrl = "/teacher/teacher_index.html";
                    break;

                /**
                 * 学生
                 * */
                case 3:
                    indexUrl = "/student/student_index.html";
                    break;

                default:
                    logger.info("登陆信息有误" + key);
                    break;

            }
            baseResult.setData(indexUrl);
        }
        return baseResult;
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * */
    @RequestMapping(value = "/signOut", method ={ RequestMethod.POST,RequestMethod.GET})
    public Result<String> signIn(HttpServletRequest request,HttpServletResponse response) throws IOException {

        Result<String> baseResult = new Result<>();

        HttpSession session = request.getSession();

        session.removeAttribute("userType");

        response.sendRedirect("/login/login.html");

        return baseResult;
    }
}
