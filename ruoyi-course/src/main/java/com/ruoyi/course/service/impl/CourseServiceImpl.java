package com.ruoyi.course.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.course.mapper.CourseMapper;
import com.ruoyi.course.domain.Course;
import com.ruoyi.course.service.ICourseService;

/**
 * 课程信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-09
 */
@Service
public class CourseServiceImpl implements ICourseService 
{
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询课程信息
     * 
     * @param courId 课程信息主键
     * @return 课程信息
     */
    @Override
    public Course selectCourseByCourId(Long courId)
    {
        return courseMapper.selectCourseByCourId(courId);
    }

    /**
     * 查询课程信息列表
     * 
     * @param course 课程信息
     * @return 课程信息
     */
    @Override
    public List<Course> selectCourseList(Course course)
    {
        return courseMapper.selectCourseList(course);
    }

    /**
     * 新增课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public int insertCourse(Course course)
    {
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public int updateCourse(Course course)
    {
        return courseMapper.updateCourse(course);
    }

    /**
     * 批量删除课程信息
     * 
     * @param courIds 需要删除的课程信息主键
     * @return 结果
     */
    @Override
    public int deleteCourseByCourIds(Long[] courIds)
    {
        return courseMapper.deleteCourseByCourIds(courIds);
    }

    /**
     * 删除课程信息信息
     * 
     * @param courId 课程信息主键
     * @return 结果
     */
    @Override
    public int deleteCourseByCourId(Long courId)
    {
        return courseMapper.deleteCourseByCourId(courId);
    }
}
