package edu.controller;

import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.model.Course;
import edu.model.CurriculaVariableInfo;
import edu.model.User;
import edu.model.UserParam;
import edu.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 教师控制层
 *
 * @author wgt
 * @date 17-12-14
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TeacherService teacherService;

    /**
     * 查看教师个人信息
     *
     * @return 教师对象
     */
    @RequestMapping(value = "/query_teacher", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<User> queryTeacherById(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();

        Integer id = Integer.valueOf(((String) session.getAttribute("userType")).split("&")[1]);

        id = id == 0 ? null : id;

        Result<User> result = teacherService.queryTeacherById(id);

        return result;
    }

    /**
     * 修改教师个人信息
     *
     * @param userParam 教师参数模型
     * @return 教师id
     */
    @RequestMapping(value = "/update_teacher", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> updateUser(UserParam userParam) {

        User user = new User();
        try {
            String key = userParam.getuNum() + userParam.getuPasswd();
            user.setId(Integer.valueOf(userParam.getId()));
            user.setuKey(key);
            user.setuGender(userParam.getuGender());
            user.setuGrade(userParam.getuGrade());
            user.setuMajor(userParam.getuMajor());
            user.setuPasswd(userParam.getuPasswd());
            user.setuName(userParam.getuName());
            user.setuNum(Integer.valueOf(userParam.getuNum()));
            user.setuType(Integer.valueOf(userParam.getuType()));
        } catch (Exception e) {
            logger.error("参数错误", e);
        }

        Result<Integer> result = teacherService.updateTeacherById(user);

        return result;
    }

    /**
     * 查看课程
     *
     * @param id 课程id
     * @return 课程对象
     */
    @RequestMapping(value = "/query_course", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Course> queryCourseById(int id) {

        Integer id1 = id == 0 ? null : id;

        Result<Course> result = teacherService.queryCourseById(id1);

        return result;
    }

    /**
     * 分页查询所有该教师的课程
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 课程列表
     */
    @RequestMapping(value = "/query_courses", method = {RequestMethod.GET, RequestMethod.POST})
    public PageInfo<Course> queryCoursesByPage( int pageNo, int pageSize,HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();

        Integer id = Integer.valueOf(((String) session.getAttribute("userType")).split("&")[1]);
        Integer pageNo1 = pageNo == 0 ? null : pageNo;
        Integer pageSize1 = pageSize == 0 ? null : pageSize;

        Result<PageInfo<Course>> result = teacherService.queryCoursesByPage(id, pageNo1, pageSize1);

        return result.getData();
    }

    /**
     * 查看已选该教师课程的信息
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 选课信息列表
     */
    @RequestMapping(value = "/query_curriculaVariableInfos", method = {RequestMethod.GET, RequestMethod.POST})
    public PageInfo<CurriculaVariableInfo> queryCurriculaVariableInfos( int pageNo, int pageSize,HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();

        Integer id = Integer.valueOf(((String) session.getAttribute("userType")).split("&")[1]);
        Integer pageNo1 = pageNo == 0 ? null : pageNo;
        Integer pageSize1 = pageSize == 0 ? null : pageSize;

        Result<PageInfo<CurriculaVariableInfo>> result = teacherService.queryCurriculaVariableInfos(id, pageNo1, pageSize1);

        return result.getData();
    }

    /**
     * 审核课程
     *
     * @param id     选课信息id
     * @param status 选课状态
     * @return 选课信息id
     * .
     */
    @RequestMapping(value = "/update_curriculaVariableInfo_status", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> updateCurriculaVariableInfoById(int id, String status) {

        Integer id1 = id == 0 ? null : id;
        status = status == null ? null : status;

        CurriculaVariableInfo curriculaVariableInfo=new CurriculaVariableInfo();
        curriculaVariableInfo.setId(id1);
        curriculaVariableInfo.setcStatus(status);

        Result<Integer> result=teacherService.updateCurriculaVariableInfoById(curriculaVariableInfo);

        return result;
    }

}
