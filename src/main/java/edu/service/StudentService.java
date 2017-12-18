package edu.service;

import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.model.Course;
import edu.model.CurriculaVariableInfo;
import edu.model.User;

import java.util.List;

/**
 * 学生层
 *
 * @author wgt
 * @date 17-12-14
 */
public interface StudentService {

    /**
     * 查看学生信息
     *
     * @param id 　学生id
     * @return 学生对象
     */
    Result<User> queryStudentById(Integer id);

    /**
     * 更新学生信息
     *
     * @param user 　学生对象
     * @return 学生id
     */
    Result<Integer> updateStudentById(User user);

    /**
     * 查看课程
     *
     * @param id 课程id
     * @return 课程对象
     */
    Result<Course> queryCourseById(Integer id);

    /**
     * 分页查询所有适合该学生年级的课程
     *
     * @param id       学生id
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 课程列表
     */
    Result<PageInfo<Course>> queryCoursesByPage(Integer id, Integer pageNo, Integer pageSize);

    /**
     * 选课
     *
     * @param cId   课程id
     * @param sId 学生id
     * @return 选课信息id
     */
    Result<Integer> addCurriculaVariableInfo(Integer cId, Integer sId);

    /**
     * 查看已选课程信息
     *
     * @param id 　学生id
     * @return 选课信息列表
     */
    Result<List<CurriculaVariableInfo>> queryCurriculaVariableInfos(Integer id);

    /**
     * 取消选课
     *
     * @param id 选课信息id
     * @return 选课信息id
     */
    Result<Integer> deleteCurriculaVariableInfo(Integer id);

}
