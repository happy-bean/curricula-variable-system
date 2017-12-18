package edu.controller;

import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.model.*;
import edu.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 学生控制层
 *
 * @author wgt
 * @date 17-12-14
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentService studentService;

    /**
     * 查看学生信息
     *
     * @return 学生对象
     */
    @RequestMapping(value = "/query_student", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<User> queryStudentById(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();

        Integer id = Integer.valueOf(((String) session.getAttribute("userType")).split("&")[1]);

        id = id == 0 ? null : id;

        Result<User> result = studentService.queryStudentById(id);

        return result;
    }

    /**
     * 更新学生信息
     *
     * @param userParam 　学生参数模型
     * @return 学生id
     */
    @RequestMapping(value = "/update_student", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> updateStudentById(UserParam userParam) {

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

        Result<Integer> result = studentService.updateStudentById(user);

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

        Result<Course> result = studentService.queryCourseById(id1);

        return result;
    }

    /**
     * 分页查询所有适合该学生年级的课程
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 课程列表
     */
    @RequestMapping(value = "/query_courses", method = {RequestMethod.GET, RequestMethod.POST})
    public PageInfo<Course> queryCoursesByPage(int pageNo, int pageSize,HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();

        Integer id = Integer.valueOf(((String) session.getAttribute("userType")).split("&")[1]);

        Integer pageNo1 = pageNo == 0 ? null : pageNo;
        Integer pageSize1 = pageSize == 0 ? null : pageSize;

        Result<PageInfo<Course>> result = studentService.queryCoursesByPage(id, pageNo1, pageSize1);

        return result.getData();
    }

    /**
     * 选课
     *
     * @param cId                         课程id
     * @return 选课信息id
     */
    @RequestMapping(value = "/add_curriculaVariableInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> addCurriculaVariableInfo(int cId,HttpServletRequest httpServletRequest) {


        HttpSession session = httpServletRequest.getSession();

        Integer sId = Integer.valueOf(((String) session.getAttribute("userType")).split("&")[1]);

        Integer cId1 = cId == 0 ? null : cId;

        CurriculaVariableInfo curriculaVariableInfo = new CurriculaVariableInfo();

        Result<Integer> result = studentService.addCurriculaVariableInfo(cId1,sId);

        return result;
    }

    /**
     * 查看已选课程信息
     *
     * @return 选课信息列表
     */
    @RequestMapping(value = "/query_curriculaVariableInfos", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<List<CurriculaVariableInfo>> queryCurriculaVariableInfos(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();

        Integer id = Integer.valueOf(((String) session.getAttribute("userType")).split("&")[1]);

        Result<List<CurriculaVariableInfo>> result = studentService.queryCurriculaVariableInfos(id);

        return result;
    }

    /**
     * 取消选课
     *
     * @param id 选课信息id
     * @return 选课信息id
     */
    @RequestMapping(value = "/delete_curriculaVariableInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Integer> deleteCurriculaVariableInfo(int id) {

        Integer id1 = id == 0 ? null : id;

        Result<Integer> result = studentService.deleteCurriculaVariableInfo(id1);

        return result;
    }

}
