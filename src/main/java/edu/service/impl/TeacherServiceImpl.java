package edu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.common.Result;
import edu.common.ResultMess;
import edu.dao.CourseMapper;
import edu.dao.CurriculaVariableInfoMapper;
import edu.dao.UserMapper;
import edu.model.Course;
import edu.model.CurriculaVariableInfo;
import edu.model.User;
import edu.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师层
 *
 * @author wgt
 * @date 17-12-14
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    CurriculaVariableInfoMapper curriculaVariableInfoMapper;

    /**
     * 查看教师信息
     *
     * @param id 　教师id
     * @return 教师对象
     */
    @Override
    public Result<User> queryTeacherById(Integer id) {

        Result<User> result = new Result<>();

        User user = userMapper.selectByPrimaryKey(id);

        if (user != null) {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(user);
            logger.info("教师信息查找成功 教师id" + id);
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("教师信息查找失败 教师id=" + id);
        }

        return result;
    }

    /**
     * 更新教师信息
     *
     * @param user 　教师对象
     * @return 教师id
     */
    @Override
    public Result<Integer> updateTeacherById(User user) {

        Result<Integer> result = new Result<>();

        int id = userMapper.updateByPrimaryKeySelective(user);

        if (id <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("教师信息更新失败 教师id=" + user.getId());
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("教师信息更新成功 教师id=" + user.getId());
        }
        return result;
    }

    /**
     * 查看课程
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
     * 分页查询所有该教师的课程
     *
     * @param id       教师id
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 课程列表
     */
    @Override
    public Result<PageInfo<Course>> queryCoursesByPage(Integer id, Integer pageNo, Integer pageSize) {

        Result<PageInfo<Course>> result = new Result<>();

        /**
         * 获取教师工号
         * */
        User teacher = userMapper.selectByPrimaryKey(id);

        Integer num = teacher.getuNum();

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);

        List<Course> list = courseMapper.selectCoursesByTno(num);
        if (list != null) {
            PageInfo<Course> page = new PageInfo<Course>(list);
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(page);
            logger.info("课程列表查找成功 教师id=" + id);
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("课程列表查找失败 教师id=" + id);
        }

        return result;
    }

    /**
     * 查看已选该教师课程的信息
     *
     * @param id       　教师id
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 选课信息列表
     */
    @Override
    public Result<PageInfo<CurriculaVariableInfo>> queryCurriculaVariableInfos(Integer id, Integer pageNo, Integer pageSize) {

        Result<PageInfo<CurriculaVariableInfo>> result = new Result<>();

        /**
         * 获取教师工号
         * */
        User teacher = userMapper.selectByPrimaryKey(id);

        Integer num = teacher.getuNum();

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);

        List<CurriculaVariableInfo> list = curriculaVariableInfoMapper.selectCurriculaVariableInfosByTno(num);
        if (list != null) {
            PageInfo<CurriculaVariableInfo> page = new PageInfo<CurriculaVariableInfo>(list);
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(page);
            logger.info("选课信息列表查找成功 教师id=" + id);
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("选课信息列表查找失败 教师id=" + id);
        }

        return result;
    }

    /**
     * 审核课程
     *
     * @param curriculaVariableInfo 选课信息对象
     * @return 选课信息id
     * .
     */
    @Override
    public Result<Integer> updateCurriculaVariableInfoById(CurriculaVariableInfo curriculaVariableInfo) {

        Result<Integer> result = new Result<>();

        int id = curriculaVariableInfoMapper.updateByPrimaryKeySelective(curriculaVariableInfo);

        if (id <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("选课信息更新失败 选课信息id=" + id);
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("选课信息更新成功 选课信息id=" + id);
        }
        return result;
    }
}
