package edu.controller;

import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.model.Course;
import edu.model.CourseModel;
import edu.model.User;
import edu.model.UserModel;
import edu.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/add_user", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<?> addUser(UserModel userModel) {

        User user = new User();
        try {
            String key = userModel.getuNum() + userModel.getuPasswd();
            user.setuKey(key);
            user.setuGender(Integer.valueOf(userModel.getuGender()));
            user.setuGrade(Integer.valueOf(userModel.getuGrade()));
            user.setuMajor(userModel.getuMajor());
            user.setuPasswd(userModel.getuPasswd());
            user.setuName(userModel.getuName());
            user.setuNum(Integer.valueOf(userModel.getuNum()));
            user.setuType(Integer.valueOf(userModel.getuType()));
        } catch (Exception e) {
            logger.error("参数错误", e);
        }

        Result<?> result = adminService.addUser(user);
        return result;
    }

    @RequestMapping(value = "/delete_user", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<?> deleteUser(int id) {

        Integer id1 = id == 0 ? null : id;

        Result<?> result = adminService.deleteUserById(id1);

        return result;
    }

    @RequestMapping(value = "/update_user", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<?> updateUser(UserModel userModel) {

        User user = new User();
        try {
            String key = userModel.getuNum() + userModel.getuPasswd();
            user.setuKey(key);
            user.setuGender(Integer.valueOf(userModel.getuGender()));
            user.setuGrade(Integer.valueOf(userModel.getuGrade()));
            user.setuMajor(userModel.getuMajor());
            user.setuPasswd(userModel.getuPasswd());
            user.setuName(userModel.getuName());
            user.setuNum(Integer.valueOf(userModel.getuNum()));
            user.setuType(Integer.valueOf(userModel.getuType()));
        } catch (Exception e) {
            logger.error("参数错误", e);
        }

        Result<?> result = adminService.updateUserById(user);

        return result;
    }

    @RequestMapping(value = "/add_course", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<?> addCourse(CourseModel courseModel) {

        Course course = new Course();
        try {
            course.setcAddress(courseModel.getcAddress());
            course.setcCredit(courseModel.getcCredit());
            course.setcDesc(courseModel.getcDesc());
            course.setcGrade(courseModel.getcGrade());
            course.setcName(courseModel.getcName());
            course.setcNo(courseModel.getcNo());
            course.setcPerid(courseModel.getcPerid());
            course.setcWeekTime(courseModel.getcWeekTime());
            course.settNo(courseModel.gettNo());
            course.setcNumber(courseModel.getcNumber());
        } catch (Exception e) {
            logger.error("参数错误", e);
        }

        Result<?> result = adminService.addCourse(course);

        return result;
    }

    @RequestMapping(value = "/delete_course", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<?> deleteCourse(int id) {

        Integer id1 = id == 0 ? null : id;

        Result<?> result = adminService.deleteCourseById(id1);

        return result;
    }

    @RequestMapping(value = "/update_course", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<?> updateCourse(CourseModel courseModel) {

        Course course = new Course();
        try {
            course.setcAddress(courseModel.getcAddress());
            course.setcCredit(courseModel.getcCredit());
            course.setcDesc(courseModel.getcDesc());
            course.setcGrade(courseModel.getcGrade());
            course.setcName(courseModel.getcName());
            course.setcNo(courseModel.getcNo());
            course.setcPerid(courseModel.getcPerid());
            course.setcWeekTime(courseModel.getcWeekTime());
            course.settNo(courseModel.gettNo());
            course.setcNumber(courseModel.getcNumber());
        } catch (Exception e) {
            logger.error("参数错误", e);
        }

        Result<?> result = adminService.updateCourseById(course);

        return result;
    }

    @RequestMapping(value = "/query_students", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<PageInfo<User>> queryStudents(int pageNo, int pageSize) {

        Integer pageNo1 = pageNo == 0 ? null : pageNo;
        Integer pageSize1 = pageSize == 0 ? null : pageSize;

        Result<PageInfo<User>> result = adminService.queryStudentsByPage(pageNo1, pageSize1);

        return result;
    }

    @RequestMapping(value = "/query_teachers", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<PageInfo<User>> queryTeachers(int pageNo, int pageSize) {

        Integer pageNo1 = pageNo == 0 ? null : pageNo;
        Integer pageSize1 = pageSize == 0 ? null : pageSize;

        Result<PageInfo<User>> result = adminService.queryStudentsByPage(pageNo1, pageSize1);

        return result;
    }

    @RequestMapping(value = "/query_courses", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<PageInfo<Course>> queryCourses(int pageNo, int pageSize) {

        Integer pageNo1 = pageNo == 0 ? null : pageNo;
        Integer pageSize1 = pageSize == 0 ? null : pageSize;

        Result<PageInfo<Course>> result = adminService.queryCoursesByPage(pageNo1, pageSize1);

        return result;
    }

}
