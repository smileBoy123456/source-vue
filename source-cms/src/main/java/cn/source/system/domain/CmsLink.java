package cn.source.system.domain;

import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 友情链接对象 cms_link
 *
 * @author 詹Sir
 * @date 2022-03-12
 */
public class CmsLink extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 站点名称 */
    @Excel(name = "站点名称")
    private String linkName;

    /** 站点链接 */
    @Excel(name = "站点链接")
    private String linkUrl;

    /** 站点Logo */
    @Excel(name = "站点Logo")
    private String linkLogo;

    /** 展示地址 */
    @Excel(name = "展示地址")
    private String linkShow;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String linkWay;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setLinkName(String linkName)
    {
        this.linkName = linkName;
    }

    public String getLinkName()
    {
        return linkName;
    }
    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl()
    {
        return linkUrl;
    }
    public void setLinkLogo(String linkLogo)
    {
        this.linkLogo = linkLogo;
    }

    public String getLinkLogo()
    {
        return linkLogo;
    }
    public void setLinkShow(String linkShow)
    {
        this.linkShow = linkShow;
    }

    public String getLinkShow()
    {
        return linkShow;
    }
    public void setLinkWay(String linkWay)
    {
        this.linkWay = linkWay;
    }

    public String getLinkWay()
    {
        return linkWay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("linkName", getLinkName())
            .append("linkUrl", getLinkUrl())
            .append("linkLogo", getLinkLogo())
            .append("linkShow", getLinkShow())
            .append("linkWay", getLinkWay())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
