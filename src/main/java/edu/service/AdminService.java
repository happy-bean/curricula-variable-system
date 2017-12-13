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
     * @param user 用户对象
     * @return 用户id
     */
    Result<Integer> addUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 用户id
     */
    Result<Integer> deleteUserById(Integer id);

    /**
     * 更新用户
     *
     * @param user 用户对象
     * @return 用户id
     */
    Result<Integer> updateUserById(User user);

    /**
     * 查询用户详情
     *
     * @param id 用户id
     * @return 用户对象
     */
    Result<User> queryUserById(Integer id);

    /**
     * 分页查询所有学生用户
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 学生用户列表
     */
    Result<PageInfo<User>> queryStudentsByPage(Integer pageNo, Integer pageSize);

    /**
     * 分页查询所有教师用户
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 教师用户列表
     */
    Result<PageInfo<User>> queryTeachersByPage(Integer pageNo, Integer pageSize);

    /**
     * 增加课程
     *
     * @param course 课程对象
     * @return 课程id
     */
    Result<Integer> addCourse(Course course);

    /**
     * 删除课程
     *
     * @param id 课程id
     * @return 课程id
     */
    Result<Integer> deleteCourseById(Integer id);

    /**
     * 更新课程
     *
     * @param course 课程对象
     * @return 课程id
     */
    Result<Integer> updateCourseById(Course course);

    /**
     * 查找课程
     *
     * @param id 课程id
     * @return 课程对象
     */
    Result<Course> queryCourseById(Integer id);

    /**
     * 分页查询所有课程
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 课程列表
     */
    Result<PageInfo<Course>> queryCoursesByPage(Integer pageNo, Integer pageSize);
}
