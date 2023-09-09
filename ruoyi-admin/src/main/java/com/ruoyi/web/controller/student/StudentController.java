package com.ruoyi.web.controller.student;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.student.domain.Student;
import com.ruoyi.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生表单上传Controller
 * 
 * @author ruoyi
 * @date 2023-09-09
 */
@RestController
@RequestMapping("/student/student")
public class StudentController extends BaseController
{
    @Autowired
    private IStudentService studentService;

    /**
     * 查询学生表单上传列表
     */
    @PreAuthorize("@ss.hasPermi('student:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(Student student)
    {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }

    /**
     * 导出学生表单上传列表
     */
    @PreAuthorize("@ss.hasPermi('student:student:export')")
    @Log(title = "学生表单上传", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Student student)
    {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        util.exportExcel(response, list, "学生表单上传数据");
    }

    /**
     * 获取学生表单上传详细信息
     */
    @PreAuthorize("@ss.hasPermi('student:student:query')")
    @GetMapping(value = "/{stuId}")
    public AjaxResult getInfo(@PathVariable("stuId") Long stuId)
    {
        return success(studentService.selectStudentByStuId(stuId));
    }

    /**
     * 新增学生表单上传
     */
    @PreAuthorize("@ss.hasPermi('student:student:add')")
    @Log(title = "学生表单上传", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Student student)
    {
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 修改学生表单上传
     */
    @PreAuthorize("@ss.hasPermi('student:student:edit')")
    @Log(title = "学生表单上传", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Student student)
    {
        return toAjax(studentService.updateStudent(student));
    }

    /**
     * 删除学生表单上传
     */
    @PreAuthorize("@ss.hasPermi('student:student:remove')")
    @Log(title = "学生表单上传", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stuIds}")
    public AjaxResult remove(@PathVariable Long[] stuIds)
    {
        return toAjax(studentService.deleteStudentByStuIds(stuIds));
    }
}
