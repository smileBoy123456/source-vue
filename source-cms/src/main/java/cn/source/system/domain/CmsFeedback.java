package cn.source.system.domain;

import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 意见反馈对象 cms_feedback
 *
 * @author ruoyi
 * @date 2022-03-01
 */
public class CmsFeedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 类别 */
    @Excel(name = "类别")
    private String feedType;

    /** 标题 */
    @Excel(name = "标题")
    private String feedTitle;

    /** 详情 */
    @Excel(name = "详情")
    private String feedContent;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFeedType(String feedType)
    {
        this.feedType = feedType;
    }

    public String getFeedType()
    {
        return feedType;
    }
    public void setFeedTitle(String feedTitle)
    {
        this.feedTitle = feedTitle;
    }

    public String getFeedTitle()
    {
        return feedTitle;
    }
    public void setFeedContent(String feedContent)
    {
        this.feedContent = feedContent;
    }

    public String getFeedContent()
    {
        return feedContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("feedType", getFeedType())
            .append("feedTitle", getFeedTitle())
            .append("feedContent", getFeedContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
