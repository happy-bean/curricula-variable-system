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
import edu.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 学生层
 *
 * @author wgt
 * @date 17-12-14
 */
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 每人限制选课数量
     */
    private static final int LIMIT_NUM = 10;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    CurriculaVariableInfoMapper curriculaVariableInfoMapper;

    /**
     * 查看学生信息
     *
     * @param id 　学生id
     * @return 学生对象
     */
    @Override
    public Result<User> queryStudentById(Integer id) {
        Result<User> result = new Result<>();

        User user = userMapper.selectByPrimaryKey(id);

        if (user != null) {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(user);
            logger.info("学生信息查找成功 学生id" + id);
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("学生信息查找失败 学生id=" + id);
        }

        return result;
    }

    /**
     * 更新学生信息
     *
     * @param user 学生对象
     * @return 学生id
     */
    @Override
    public Result<Integer> updateStudentById(User user) {

        Result<Integer> result = new Result<>();

        int id = userMapper.updateByPrimaryKey(user);

        if (id <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("学生信息更新失败 学生id=" + user.getId());
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(id);
            logger.info("学生信息更新成功 学生id=" + user.getId());
        }
        return result;
    }

    /**
     * 查看课程详情
     *
     * @param id 课程id
     * @return 课程信息
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
     * 分页查询所有适合该学生年级的课程
     *
     * @param id       学生id
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return 课程列表
     */
    @Override
    public Result<PageInfo<Course>> queryCoursesByPage(Integer id, Integer pageNo, Integer pageSize) {

        Result<PageInfo<Course>> result = new Result<>();

        /**
         * 获取学生年级
         * */
        User student = userMapper.selectByPrimaryKey(id);

        Integer grade = student.getuGrade();

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);

        List<Course> list = courseMapper.selectCoursesByGrade(grade);
        if (list != null) {
            PageInfo<Course> page = new PageInfo<Course>(list);
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess(ResultMess.SUCCESS.getMess());
            result.setData(page);
            logger.info("课程列表查找成功 学生id=" + id);
        } else {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess(ResultMess.ERROR.getMess());
            logger.info("课程列表查找失败 学生id=" + id);
        }

        return result;
    }

    /**
     * 选课
     *
     * @param id                    学生id
     * @param curriculaVariableInfo 选课信息对象
     * @return 选课信息id
     */
    @Override
    public Result<Integer> addCurriculaVariableInfo(Integer id, CurriculaVariableInfo curriculaVariableInfo) {

        Result<Integer> result = new Result<>();

        /**
         * 学号
         * */
        User user = userMapper.selectByPrimaryKey(id);
        int sNo = user.getuNum();

        List<CurriculaVariableInfo> list = null;

        /**
         * 该学生已选课程数量(不包含审核未通过的)
         * */
        list = curriculaVariableInfoMapper.selectSuccessCurriculaVariableInfosBySno(sNo);
        int hasNum = list == null ? 0 : list.size();

        /**
         * 判断是否已经选满课程
         * */
        if (hasNum == LIMIT_NUM) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess("您的课程已选满");
            logger.info("您的课程已选满 学号=" + sNo);
            return result;
        }


        /**
         * 选课信息课程号
         * */
        int cno = curriculaVariableInfo.getcCNo();

        /**
         * 该课程信息
         * */
        Course course = courseMapper.selectCoursesByCno(cno);

        /**
         * 判断是否选过该课程/判断上课时间是否冲突
         * */
        for (CurriculaVariableInfo info : list) {
            Course courseTemp = courseMapper.selectCoursesByCno(info.getcCNo());
            if (StringUtils.equals(courseTemp.getcName(), course.getcName())) {
                result.setCode(ResultMess.ERROR.getCode());
                result.setMess("您已经选过该课程");
                logger.info("您已经选过该课程 " + course.getcName() + " 课程号=" + course.getcNo());
                return result;
            }

            if (StringUtils.equals(courseTemp.getcWeekTime(), course.getcWeekTime())) {
                result.setCode(ResultMess.ERROR.getCode());
                result.setMess("您的选择的课程与 " + courseTemp.getcName() + " 时间冲突");
                logger.info("您的选择的课程与 " + courseTemp.getcName() + " 时间冲突 课程号=" + course.getcNo());
                return result;
            }
        }


        /**
         * 该课程限定人数
         * */

        int limitNum = course.getcNumber();

        /**
         * 查看当前选择该课程的人数
         * */
        list = curriculaVariableInfoMapper.selectCurriculaVariableInfosByCno(cno);
        int nowNum = list.size();

        /**
         * 判断是否人数已满
         * */
        if (limitNum == nowNum) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess("该课程当前人数已满");
            logger.info("该课程当前人数已满 课程no=" + course.getcNo());
            return result;
        }

        int id1 = courseMapper.insert(course);

        if (id1 <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess("选课失败，请稍后再试");
            logger.info("选课插入失败 课程no=" + course.getcNo());
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess("选课成功");
            result.setData(id1);
            logger.info("课程插入成功 课程no=" + course.getcNo());
        }
        return result;
    }

    /**
     * 查看已选课程信息
     *
     * @param id 　学生id
     * @return 选课信息列表
     */
    @Override
    public Result<List<CurriculaVariableInfo>> queryCurriculaVariableInfos(Integer id) {

        Result<List<CurriculaVariableInfo>> result = new Result<>();

        /**
         * 学号
         * */
        User user = userMapper.selectByPrimaryKey(id);
        int sNo = user.getuNum();
        
        List<CurriculaVariableInfo> list = curriculaVariableInfoMapper.selectSuccessCurriculaVariableInfosBySno(sNo);

        if (list == null || list.size() == 1) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess("您当前还未选过任何课程");
            logger.info("您当前还未选过任何课程 学生id=" + id);
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess("查询成功");
            result.setData(list);
            logger.info("查询选课信息成功 学生id=" + id);
        }
        return result;
    }

    /**
     * 取消选课
     *
     * @param id 选课信息id
     * @return 选课信息id
     */
    @Override
    public Result<Integer> deleteCurriculaVariableInfo(Integer id){

        Result<Integer> result=new Result<>();

        /**
         * 判断该课程是否已经选中
         * */
        CurriculaVariableInfo curriculaVariableInfo=curriculaVariableInfoMapper.selectByPrimaryKey(id);

        if(curriculaVariableInfo.getcStatus()==1){
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess("您不能取消通过的课程");
            logger.info("您不能取消通过的课程 课程id=" + id);
            return result;
        }

        int id1=curriculaVariableInfoMapper.deleteByPrimaryKey(id);
        if (id1 <= 0) {
            result.setCode(ResultMess.ERROR.getCode());
            result.setMess("取消失败，请稍后再试");
            logger.info("取消失败 课程id=" + id);
        } else {
            result.setCode(ResultMess.SUCCESS.getCode());
            result.setMess("取消成功");
            result.setData(id1);
            logger.info("课程取消成功 课程id=" + id);
        }

        return result;
    }
}
