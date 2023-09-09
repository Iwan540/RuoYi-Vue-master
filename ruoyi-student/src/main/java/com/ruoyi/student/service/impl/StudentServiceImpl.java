package com.ruoyi.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.student.mapper.StudentMapper;
import com.ruoyi.student.domain.Student;
import com.ruoyi.student.service.IStudentService;

/**
 * 学生表单上传Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-09
 */
@Service
public class StudentServiceImpl implements IStudentService 
{
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询学生表单上传
     * 
     * @param stuId 学生表单上传主键
     * @return 学生表单上传
     */
    @Override
    public Student selectStudentByStuId(Long stuId)
    {
        return studentMapper.selectStudentByStuId(stuId);
    }

    /**
     * 查询学生表单上传列表
     * 
     * @param student 学生表单上传
     * @return 学生表单上传
     */
    @Override
    public List<Student> selectStudentList(Student student)
    {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增学生表单上传
     * 
     * @param student 学生表单上传
     * @return 结果
     */
    @Override
    public int insertStudent(Student student)
    {
        return studentMapper.insertStudent(student);
    }

    /**
     * 修改学生表单上传
     * 
     * @param student 学生表单上传
     * @return 结果
     */
    @Override
    public int updateStudent(Student student)
    {
        return studentMapper.updateStudent(student);
    }

    /**
     * 批量删除学生表单上传
     * 
     * @param stuIds 需要删除的学生表单上传主键
     * @return 结果
     */
    @Override
    public int deleteStudentByStuIds(Long[] stuIds)
    {
        return studentMapper.deleteStudentByStuIds(stuIds);
    }

    /**
     * 删除学生表单上传信息
     * 
     * @param stuId 学生表单上传主键
     * @return 结果
     */
    @Override
    public int deleteStudentByStuId(Long stuId)
    {
        return studentMapper.deleteStudentByStuId(stuId);
    }
}
