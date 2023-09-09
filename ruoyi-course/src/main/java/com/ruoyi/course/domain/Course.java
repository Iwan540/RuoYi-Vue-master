package com.ruoyi.course.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程信息对象 course
 * 
 * @author ruoyi
 * @date 2023-09-09
 */
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程id */
    private Long courId;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private String courCode;

    /** 预估学生人数 */
    @Excel(name = "预估学生人数")
    private Long courEsti;

    /** 目前学生人数 */
    @Excel(name = "目前学生人数")
    private Long courCurrent;

    /** 可用改分时间 */
    @Excel(name = "可用改分时间")
    private Long courAvhours;

    /** 是否需要marker */
    @Excel(name = "是否需要marker")
    private String courNeedmarker;

    /** 课程评估数量 */
    @Excel(name = "课程评估数量")
    private Long courNumass;

    /** 课程评估种类 */
    @Excel(name = "课程评估种类")
    private String courTypeass;

    /** marker时间 */
    @Excel(name = "marker时间")
    private Long courMarkerhour;

    /** tutor时间 */
    @Excel(name = "tutor时间")
    private Long courTutorhour;

    /** marker的职责 */
    @Excel(name = "marker的职责")
    private String courMarkerrespon;

    /** 希望marker数量 */
    @Excel(name = "希望marker数量")
    private Long courPrenummarker;

    public void setCourId(Long courId) 
    {
        this.courId = courId;
    }

    public Long getCourId() 
    {
        return courId;
    }
    public void setCourCode(String courCode) 
    {
        this.courCode = courCode;
    }

    public String getCourCode() 
    {
        return courCode;
    }
    public void setCourEsti(Long courEsti) 
    {
        this.courEsti = courEsti;
    }

    public Long getCourEsti() 
    {
        return courEsti;
    }
    public void setCourCurrent(Long courCurrent) 
    {
        this.courCurrent = courCurrent;
    }

    public Long getCourCurrent() 
    {
        return courCurrent;
    }
    public void setCourAvhours(Long courAvhours) 
    {
        this.courAvhours = courAvhours;
    }

    public Long getCourAvhours() 
    {
        return courAvhours;
    }
    public void setCourNeedmarker(String courNeedmarker) 
    {
        this.courNeedmarker = courNeedmarker;
    }

    public String getCourNeedmarker() 
    {
        return courNeedmarker;
    }
    public void setCourNumass(Long courNumass) 
    {
        this.courNumass = courNumass;
    }

    public Long getCourNumass() 
    {
        return courNumass;
    }
    public void setCourTypeass(String courTypeass) 
    {
        this.courTypeass = courTypeass;
    }

    public String getCourTypeass() 
    {
        return courTypeass;
    }
    public void setCourMarkerhour(Long courMarkerhour) 
    {
        this.courMarkerhour = courMarkerhour;
    }

    public Long getCourMarkerhour() 
    {
        return courMarkerhour;
    }
    public void setCourTutorhour(Long courTutorhour) 
    {
        this.courTutorhour = courTutorhour;
    }

    public Long getCourTutorhour() 
    {
        return courTutorhour;
    }
    public void setCourMarkerrespon(String courMarkerrespon) 
    {
        this.courMarkerrespon = courMarkerrespon;
    }

    public String getCourMarkerrespon() 
    {
        return courMarkerrespon;
    }
    public void setCourPrenummarker(Long courPrenummarker) 
    {
        this.courPrenummarker = courPrenummarker;
    }

    public Long getCourPrenummarker() 
    {
        return courPrenummarker;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courId", getCourId())
            .append("courCode", getCourCode())
            .append("courEsti", getCourEsti())
            .append("courCurrent", getCourCurrent())
            .append("courAvhours", getCourAvhours())
            .append("courNeedmarker", getCourNeedmarker())
            .append("courNumass", getCourNumass())
            .append("courTypeass", getCourTypeass())
            .append("courMarkerhour", getCourMarkerhour())
            .append("courTutorhour", getCourTutorhour())
            .append("courMarkerrespon", getCourMarkerrespon())
            .append("courPrenummarker", getCourPrenummarker())
            .toString();
    }
}
