package com.ruoyi.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生表单上传对象 student
 * 
 * @author ruoyi
 * @date 2023-09-09
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long stuId;

    /** 学生名字 */
    @Excel(name = "学生名字")
    private String stuName;

    /** 学生UPI */
    @Excel(name = "学生UPI")
    private String stuUpi;

    /** 学生AUID */
    @Excel(name = "学生AUID")
    private Long stuAuid;

    /** 学生邮件 */
    @Excel(name = "学生邮件")
    private String stuEmail;

    /** 当前是否在海外 */
    @Excel(name = "当前是否在海外")
    private String stuCurrentOverseas;

    /** 当前在海外的情况下是否返回NZ */
    @Excel(name = "当前在海外的情况下是否返回NZ")
    private String stuCurrentOverseasBacknz;

    /** 学生是否是居民 */
    @Excel(name = "学生是否是居民")
    private String stuCitizen;

    /** 不是居民的情况下是否有签证 */
    @Excel(name = "不是居民的情况下是否有签证")
    private String stuCitizenVisa;

    /** 学生选课细节 */
    @Excel(name = "学生选课细节")
    private String stuEnrolmentDetail;

    /** 学生学历 */
    @Excel(name = "学生学历")
    private String stuEducation;

    /** 这学期是否有其他合同 */
    @Excel(name = "这学期是否有其他合同")
    private String stuTaorgta;

    /** 有其他合同情况下描述合同 */
    @Excel(name = "有其他合同情况下描述合同")
    private String stuTaortgaContracts;

    /** 学生最大工作时间 */
    @Excel(name = "学生最大工作时间")
    private Long stuMaximumWorktime;

    /** 学生学过这门课的成绩 */
    @Excel(name = "学生学过这门课的成绩")
    private Long stuGrade;

    /** 学生没学过这门课情况下解释自己为什么有资格 */
    @Excel(name = "学生没学过这门课情况下解释自己为什么有资格")
    private String stuWhyQualify;

    /** 学生的经验 */
    @Excel(name = "学生的经验")
    private String stuExperience;

    /** 学生申请状态 */
    @Excel(name = "学生申请状态")
    private String stuApplicationStatus;

    /** 学生是否学过这门课 */
    @Excel(name = "学生是否学过这门课")
    private String stuStudyed;

    /** 学生简历 */
    @Excel(name = "学生简历")
    private String stuCv;

    /** 学生学术记录 */
    @Excel(name = "学生学术记录")
    private String stuAr;

    public void setStuId(Long stuId) 
    {
        this.stuId = stuId;
    }

    public Long getStuId() 
    {
        return stuId;
    }
    public void setStuName(String stuName) 
    {
        this.stuName = stuName;
    }

    public String getStuName() 
    {
        return stuName;
    }
    public void setStuUpi(String stuUpi) 
    {
        this.stuUpi = stuUpi;
    }

    public String getStuUpi() 
    {
        return stuUpi;
    }
    public void setStuAuid(Long stuAuid) 
    {
        this.stuAuid = stuAuid;
    }

    public Long getStuAuid() 
    {
        return stuAuid;
    }
    public void setStuEmail(String stuEmail) 
    {
        this.stuEmail = stuEmail;
    }

    public String getStuEmail() 
    {
        return stuEmail;
    }
    public void setStuCurrentOverseas(String stuCurrentOverseas) 
    {
        this.stuCurrentOverseas = stuCurrentOverseas;
    }

    public String getStuCurrentOverseas() 
    {
        return stuCurrentOverseas;
    }
    public void setStuCurrentOverseasBacknz(String stuCurrentOverseasBacknz) 
    {
        this.stuCurrentOverseasBacknz = stuCurrentOverseasBacknz;
    }

    public String getStuCurrentOverseasBacknz() 
    {
        return stuCurrentOverseasBacknz;
    }
    public void setStuCitizen(String stuCitizen) 
    {
        this.stuCitizen = stuCitizen;
    }

    public String getStuCitizen() 
    {
        return stuCitizen;
    }
    public void setStuCitizenVisa(String stuCitizenVisa) 
    {
        this.stuCitizenVisa = stuCitizenVisa;
    }

    public String getStuCitizenVisa() 
    {
        return stuCitizenVisa;
    }
    public void setStuEnrolmentDetail(String stuEnrolmentDetail) 
    {
        this.stuEnrolmentDetail = stuEnrolmentDetail;
    }

    public String getStuEnrolmentDetail() 
    {
        return stuEnrolmentDetail;
    }
    public void setStuEducation(String stuEducation) 
    {
        this.stuEducation = stuEducation;
    }

    public String getStuEducation() 
    {
        return stuEducation;
    }
    public void setStuTaorgta(String stuTaorgta) 
    {
        this.stuTaorgta = stuTaorgta;
    }

    public String getStuTaorgta() 
    {
        return stuTaorgta;
    }
    public void setStuTaortgaContracts(String stuTaortgaContracts) 
    {
        this.stuTaortgaContracts = stuTaortgaContracts;
    }

    public String getStuTaortgaContracts() 
    {
        return stuTaortgaContracts;
    }
    public void setStuMaximumWorktime(Long stuMaximumWorktime) 
    {
        this.stuMaximumWorktime = stuMaximumWorktime;
    }

    public Long getStuMaximumWorktime() 
    {
        return stuMaximumWorktime;
    }
    public void setStuGrade(Long stuGrade) 
    {
        this.stuGrade = stuGrade;
    }

    public Long getStuGrade() 
    {
        return stuGrade;
    }
    public void setStuWhyQualify(String stuWhyQualify) 
    {
        this.stuWhyQualify = stuWhyQualify;
    }

    public String getStuWhyQualify() 
    {
        return stuWhyQualify;
    }
    public void setStuExperience(String stuExperience) 
    {
        this.stuExperience = stuExperience;
    }

    public String getStuExperience() 
    {
        return stuExperience;
    }
    public void setStuApplicationStatus(String stuApplicationStatus) 
    {
        this.stuApplicationStatus = stuApplicationStatus;
    }

    public String getStuApplicationStatus() 
    {
        return stuApplicationStatus;
    }
    public void setStuStudyed(String stuStudyed) 
    {
        this.stuStudyed = stuStudyed;
    }

    public String getStuStudyed() 
    {
        return stuStudyed;
    }
    public void setStuCv(String stuCv) 
    {
        this.stuCv = stuCv;
    }

    public String getStuCv() 
    {
        return stuCv;
    }
    public void setStuAr(String stuAr) 
    {
        this.stuAr = stuAr;
    }

    public String getStuAr() 
    {
        return stuAr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuId())
            .append("stuName", getStuName())
            .append("stuUpi", getStuUpi())
            .append("stuAuid", getStuAuid())
            .append("stuEmail", getStuEmail())
            .append("stuCurrentOverseas", getStuCurrentOverseas())
            .append("stuCurrentOverseasBacknz", getStuCurrentOverseasBacknz())
            .append("stuCitizen", getStuCitizen())
            .append("stuCitizenVisa", getStuCitizenVisa())
            .append("stuEnrolmentDetail", getStuEnrolmentDetail())
            .append("stuEducation", getStuEducation())
            .append("stuTaorgta", getStuTaorgta())
            .append("stuTaortgaContracts", getStuTaortgaContracts())
            .append("stuMaximumWorktime", getStuMaximumWorktime())
            .append("stuGrade", getStuGrade())
            .append("stuWhyQualify", getStuWhyQualify())
            .append("stuExperience", getStuExperience())
            .append("stuApplicationStatus", getStuApplicationStatus())
            .append("stuStudyed", getStuStudyed())
            .append("stuCv", getStuCv())
            .append("stuAr", getStuAr())
            .toString();
    }
}
