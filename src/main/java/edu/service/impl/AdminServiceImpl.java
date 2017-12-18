package edu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.common.ResultMess;
import edu.dao.CourseMapper;
import edu.dao.UserMapper;
import edu.model.Course;
import edu.model.User;
import edu.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员层
 *
 * @author wgt
 * @date 17-12-13
 */
@Service
public class AdminServiceImpl implements AdminService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    @Autowired
    CourseMapper courseMapper;

    /**
     * 增加用户
     *
     * @param user 用户对象
     * @return 用户id
     */
    @Override
    public Result<Integer> addUser(User user) {

        Result<Integer> result = new Result<>();

        int id=0;

        try {
             id = userMapper.insert(user);
        }catch (Exception e){

        }

        if (id <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("用户插入失败 用户num=" + user.getuNum());
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("用户插入成功 用户num=" + user.getuNum());
        }
        return result;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 用户id
     */
    @Override
    public Result<Integer> deleteUserById(Integer id) {

        Result<Integer> result = new Result<>();

        int idd = userMapper.deleteByPrimaryKey(id);


        if (idd <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("用户删除失败 用户id=" + id);
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("用户删除成功 用户id=" + id);
        }
        return result;
    }

    /**
     * 更新用户
     *
     * @param user 用户对象
     * @return 用户id
     */
    @Override
    public Result<Integer> updateUserById(User user) {

        Result<Integer> result = new Result<>();

        int id = userMapper.updateByPrimaryKeySelective(user);

        if (id <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("用户信息更新失败 用户id=" + user.getId());
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("用户信息更新成功 用户id=" + user.getId());
        }
        return result;
    }

    /**
     * 查询用户详情
     *
     * @param id 用户id
     * @return 用户对象
     */
    @Override
    public Result<User> queryUserById(Integer id) {

        Result<User> result = new Result<>();

        User user = userMapper.selectByPrimaryKey(id);

        if (user != null) {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(user);
            logger.info("用户信息查找成功 用户id=" + id);
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("用户信息查找失败 用户id=" + id);
        }

        return result;
    }

    /**
     * 分页查询所有学生用户
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 学生用户列表
     */
    @Override
    public Result<PageInfo<User>> queryStudentsByPage(Integer pageNo, Integer pageSize) {

        Result<PageInfo<User>> result = new Result<>();

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);

        List<User> list = userMapper.selectStudents();
        if (list != null) {
            PageInfo<User> page = new PageInfo<User>(list);
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(page);
            logger.info("学生列表查找成功");
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("学生列表查找失败");
        }

        return result;
    }

    /**
     * 分页查询所有教师用户
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 教师用户列表
     */
    @Override
    public Result<PageInfo<User>> queryTeachersByPage(Integer pageNo, Integer pageSize) {

        Result<PageInfo<User>> result = new Result<>();

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);

        List<User> list = userMapper.selectTeachers();
        if (list != null) {
            PageInfo<User> page = new PageInfo<User>(list);
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(page);
            logger.info("教师列表查找成功");
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("教师列表查找失败");
        }

        return result;
    }

    /**
     * 增加课程
     *
     * @param course 课程对象
     * @return 课程id
     */
    @Override
    public Result<Integer> addCourse(Course course) {

        Result<Integer> result = new Result<>();

        int id = courseMapper.insert(course);

        if (id <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("课程插入失败 课程no=" + course.getcNo());
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("课程插入成功 课程no=" + course.getcNo());
        }
        return result;
    }

    /**
     * 删除课程
     *
     * @param id 课程id
     * @return 课程id
     */
    @Override
    public Result<Integer> deleteCourseById(Integer id) {

        Result<Integer> result = new Result<>();

        int idd = courseMapper.deleteByPrimaryKey(id);


        if (idd <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("课程删除失败 课程id=" + id);
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("课程删除成功 课程id=" + id);
        }
        return result;
    }

    /**
     * 更新课程
     *
     * @param course 课程对象
     * @return 课程id
     */
    @Override
    public Result<Integer> updateCourseById(Course course) {

        Result<Integer> result = new Result<>();

        int id = courseMapper.updateByPrimaryKey(course);

        if (id <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("课程信息更新失败 课程id=" + id);
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("课程信息更新成功 课程id=" + id);
        }
        return result;
    }

    /**
     * 查找课程
     *
     * @param id 课程id
     * @return 课程对象
     */
    @Override
    public Result<Course> queryCourseById(Integer id) {

        Result<Course> result = new Result<>();

        Course course = courseMapper.selectByPrimaryKey(id);

        if (course != null) {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(course);
            logger.info("课程查信息查找成功 课程id=" + id);
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("课程查信息查找失败 课程id=" + id);
        }

        return result;
    }

    /**
     * 分页查询所有课程
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 课程列表
     */
    @Override
    public Result<PageInfo<Course>> queryCoursesByPage(Integer pageNo, Integer pageSize) {

        Result<PageInfo<Course>> result = new Result<>();

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);

        List<Course> list = courseMapper.selectCourses();
        if (list != null) {
            PageInfo<Course> page = new PageInfo<Course>(list);
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(page);
            logger.info("课程列表查找成功");
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("课程列表查找失败");
        }

        return result;
    }
}
