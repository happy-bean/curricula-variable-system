package edu.controller;

import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.model.Course;
import edu.model.CourseParam;
import edu.model.User;
import edu.model.UserParam;
import edu.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private AdminService adminService;

    /**
     * 新增用户
     *
     * @param userParam 用户参数模型
     * @return 用户id
     */
    @RequestMapping(value = "/add_user", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> addUser(UserParam userParam,HttpServletResponse httpServletResponse) throws IOException {

        User user = new User();
        try {
            String key = userParam.getuNum() + userParam.getuPasswd();
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

        Result<Integer> result = adminService.addUser(user);

        httpServletResponse.sendRedirect("/admin/admin_index.html");

        return result;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 用户id
     */
    @RequestMapping(value = "/delete_user", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> deleteUser(int id) {

        Integer id1 = id == 0 ? null : id;

        Result<Integer> result = adminService.deleteUserById(id1);

        return result;
    }


    /**
     * 查看用户
     *
     * @param id 用户id
     * @return 用户对象
     */
    @RequestMapping(value = "/query_user", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<User> queryUser(int id) {

        Integer id1 = id == 0 ? null : id;

        Result<User> result = adminService.queryUserById(id1);

        return result;
    }
    /**
     * 修改用户
     *
     * @param userParam 用户参数模型
     * @return 用户id
     */
    @RequestMapping(value = "/update_user", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> updateUser(UserParam userParam,HttpServletResponse httpServletResponse) throws IOException {

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

        Result<Integer> result = adminService.updateUserById(user);

        httpServletResponse.sendRedirect("/admin/admin_index.html");

        return result;
    }

    /**
     * 新增课程
     *
     * @param courseParam 课程参数模型
     * @return 课程id
     */
    @RequestMapping(value = "/add_course", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> addCourse(CourseParam courseParam,HttpServletResponse httpServletResponse) throws IOException {

        Course course = new Course();
        try {
            course.setcAddress(courseParam.getcAddress());
            course.setcCredit(Integer.valueOf(courseParam.getcCredit()));
            course.setcDesc(courseParam.getcDesc());
            course.setcGrade(courseParam.getcGrade());
            course.setcName(courseParam.getcName());
            course.setcNo(courseParam.getcNo());
            course.setcPerid(Integer.valueOf(courseParam.getcPerid()));
            course.setcWeekTime(courseParam.getcWeekTime());
            course.settNo(Integer.valueOf(courseParam.gettNo()));
            course.setcNumber(Integer.valueOf(courseParam.getcNumber()));
        } catch (Exception e) {
            logger.error("参数错误", e);
        }

        Result<Integer> result = adminService.addCourse(course);

        httpServletResponse.sendRedirect("/admin/admin_course.html");

        return result;
    }

    /**
     * 删除课程
     *
     * @param id 课程id
     * @return 课程id
     */
    @RequestMapping(value = "/delete_course", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> deleteCourse(int id) {

        Integer id1 = id == 0 ? null : id;

        Result<Integer> result = adminService.deleteCourseById(id1);

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

        Result<Course> result = adminService.queryCourseById(id1);

        return result;
    }

    /**
     * 修改课程
     *
     * @param courseParam 课程参数模型
     * @return 课程id
     */
    @RequestMapping(value = "/update_course", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> updateCourse(CourseParam courseParam, HttpServletResponse httpServletResponse) throws IOException {

        Course course = new Course();
        try {
            course.setId(Integer.valueOf(courseParam.getId()));
            course.setcAddress(courseParam.getcAddress());
            course.setcCredit(Integer.valueOf(courseParam.getcCredit()));
            course.setcDesc(courseParam.getcDesc());
            course.setcGrade(courseParam.getcGrade());
            course.setcName(courseParam.getcName());
            course.setcNo(courseParam.getcNo());
            course.setcPerid(Integer.valueOf(courseParam.getcPerid()));
            course.setcWeekTime(courseParam.getcWeekTime());
            course.settNo(Integer.valueOf(courseParam.gettNo()));
            course.setcNumber(Integer.valueOf(courseParam.getcNumber()));
        } catch (Exception e) {
            logger.error("参数错误", e);
        }

        Result<Integer> result = adminService.updateCourseById(course);

        httpServletResponse.sendRedirect("/admin/admin_course.html");

        return result;
    }

    /**
     * 查询学生列表
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 学生列表
     */
    @RequestMapping(value = "/query_students", method = {RequestMethod.GET, RequestMethod.POST})
    public PageInfo<User> queryStudents(Integer pageNo, Integer pageSize) {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        Result<PageInfo<User>> result = adminService.queryStudentsByPage(pageNo, pageSize);

        return result.getData();
    }

    @RequestMapping(value = "/query_teachers", method = {RequestMethod.GET, RequestMethod.POST})
    public PageInfo<User> queryTeachers(Integer pageNo, Integer pageSize) {

        System.out.println(pageNo);

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        Result<PageInfo<User>> result = adminService.queryTeachersByPage(pageNo, pageSize);

        return result.getData();
    }

    @RequestMapping(value = "/query_courses", method = {RequestMethod.GET, RequestMethod.POST})
    public PageInfo<Course> queryCourses(int pageNo, int pageSize) {

        Integer pageNo1 = pageNo == 0 ? null : pageNo;
        Integer pageSize1 = pageSize == 0 ? null : pageSize;

        Result<PageInfo<Course>> result = adminService.queryCoursesByPage(pageNo1, pageSize1);

        return result.getData();
    }

}
