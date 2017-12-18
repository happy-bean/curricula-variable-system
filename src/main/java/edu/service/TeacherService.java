package edu.service;

import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.model.Course;
import edu.model.CurriculaVariableInfo;
import edu.model.User;

/**
 * 教师层
 *
 * @author wgt
 * @date 17-12-14
 */
public interface TeacherService {

    /**
     * 查看教师信息
     *
     * @param id 　教师id
     * @return 教师对象
     */
    Result<User> queryTeacherById(Integer id);

    /**
     * 更新教师信息
     *
     * @param user 　教师对象
     * @return 教师id
     */
    Result<Integer> updateTeacherById(User user);

    /**
     * 查看课程
     *
     * @param id 课程id
     * @return 课程对象
     */
    Result<Course> queryCourseById(Integer id);

    /**
     * 分页查询所有该教师的课程
     *
     * @param id       教师id
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 课程列表
     */
    Result<PageInfo<Course>> queryCoursesByPage(Integer id, Integer pageNo, Integer pageSize);

    /**
     * 查看已选该教师课程的信息
     *
     * @param id       　教师id
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 选课信息列表
     */
    Result<PageInfo<CurriculaVariableInfo>> queryCurriculaVariableInfos(Integer id, Integer pageNo, Integer pageSize);

    /**
     * 审核课程
     *
     * @param curriculaVariableInfo 选课信息对象
     * @return 选课信息id
     * .
     */
    Result<Integer> updateCurriculaVariableInfoById(CurriculaVariableInfo curriculaVariableInfo);
}
