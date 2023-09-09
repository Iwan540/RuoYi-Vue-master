package com.ruoyi.student.service;

import java.util.List;
import com.ruoyi.student.domain.Student;

/**
 * 学生表单上传Service接口
 * 
 * @author ruoyi
 * @date 2023-09-09
 */
public interface IStudentService 
{
    /**
     * 查询学生表单上传
     * 
     * @param stuId 学生表单上传主键
     * @return 学生表单上传
     */
    public Student selectStudentByStuId(Long stuId);

    /**
     * 查询学生表单上传列表
     * 
     * @param student 学生表单上传
     * @return 学生表单上传集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 新增学生表单上传
     * 
     * @param student 学生表单上传
     * @return 结果
     */
    public int insertStudent(Student student);

    /**
     * 修改学生表单上传
     * 
     * @param student 学生表单上传
     * @return 结果
     */
    public int updateStudent(Student student);

    /**
     * 批量删除学生表单上传
     * 
     * @param stuIds 需要删除的学生表单上传主键集合
     * @return 结果
     */
    public int deleteStudentByStuIds(Long[] stuIds);

    /**
     * 删除学生表单上传信息
     * 
     * @param stuId 学生表单上传主键
     * @return 结果
     */
    public int deleteStudentByStuId(Long stuId);
}
