package edu.service;

import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.model.Course;
import edu.model.User;

/**
 * 管理员层
 *
 * @author wgt
 * @date 17-12-13
 */
public interface AdminService {

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    Result<Long> addUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    Result<Integer> deleteUserById(Integer id);

    /**
     * 更新用户
     *
     * @param user
     * @param
     */
    Result<Integer> updateUserById(User user);

    /**
     * 查询用户详情
     *
     * @param id
     * @return
     */
    Result<User> queryUserById(Integer id);

    /**
     * 分页查询所有学生用户
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return
     */
    Result<PageInfo<User>> queryStudentsByPage(Integer pageNo, Integer pageSize);

    /**
     * 分页查询所有教师用户
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return
     */
    Result<PageInfo<User>> queryTeachersByPage(Integer pageNo, Integer pageSize);

    /**
     * 增加课程
     *
     * @param course
     * @return
     */
    Result<Integer> addCourse(Course course);

    /**
     * 删除课程
     *
     * @param id
     * @return
     */
    Result<Integer> deleteCourse(Integer id);

    /**
     * 更新课程
     *
     * @param course
     * @return
     */
    Result<Integer> updateCourse(Course course);

    /**
     * 查找课程
     *
     * @param id
     * @return
     */
    Result<Course> queryCourseById(Integer id);

    /**
     * 分页查询所有课程
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return
     * */
    Result<PageInfo<Course>> queryCoursesByPage(Integer pageNo, Integer pageSize);
}
