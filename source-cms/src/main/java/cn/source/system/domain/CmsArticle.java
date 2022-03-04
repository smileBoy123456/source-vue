package cn.source.system.domain;

import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 内容管理对象 cms_article
 *
 * @author 詹Sir
 * @date 2022-03-01
 */
public class CmsArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private String articleType;

    /** 简短标题 */
    @Excel(name = "简短标题")
    private String smallTitle;

    /** 完整标题 */
    @Excel(name = "完整标题")
    private String bigTitle;

    /** 封面图 */
    @Excel(name = "封面图")
    private String faceUrl;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String faceThum;

    /** 内容 */
    @Excel(name = "内容")
    private String articleContent;

    /** 来源 */
    @Excel(name = "来源")
    private String articleSource;

    /** 排序号 */
    private Integer sortNo;

    /** 点赞量 */
    private Integer starNum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setArticleType(String articleType)
    {
        this.articleType = articleType;
    }

    public String getArticleType()
    {
        return articleType;
    }
    public void setSmallTitle(String smallTitle)
    {
        this.smallTitle = smallTitle;
    }

    public String getSmallTitle()
    {
        return smallTitle;
    }
    public void setBigTitle(String bigTitle)
    {
        this.bigTitle = bigTitle;
    }

    public String getBigTitle()
    {
        return bigTitle;
    }
    public void setFaceUrl(String faceUrl)
    {
        this.faceUrl = faceUrl;
    }

    public String getFaceUrl()
    {
        return faceUrl;
    }
    public void setFaceThum(String faceThum)
    {
        this.faceThum = faceThum;
    }

    public String getFaceThum()
    {
        return faceThum;
    }
    public void setArticleContent(String articleContent)
    {
        this.articleContent = articleContent;
    }

    public String getArticleContent()
    {
        return articleContent;
    }
    public void setArticleSource(String articleSource)
    {
        this.articleSource = articleSource;
    }

    public String getArticleSource()
    {
        return articleSource;
    }
    public void setSortNo(Integer sortNo)
    {
        this.sortNo = sortNo;
    }

    public Integer getSortNo()
    {
        return sortNo;
    }

    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("articleType", getArticleType())
            .append("smallTitle", getSmallTitle())
            .append("bigTitle", getBigTitle())
            .append("faceUrl", getFaceUrl())
            .append("faceThum", getFaceThum())
            .append("articleContent", getArticleContent())
            .append("articleSource", getArticleSource())
            .append("sortNo", getSortNo())
            .append("starNum", getStarNum())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
