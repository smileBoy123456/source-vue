package cn.source.system.domain;

import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 消息管理对象 cms_msg
 *
 * @author 詹Sir
 * @date 2022-04-03
 */
public class CmsMsg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 类型  */
    @Excel(name = "类型")
    private Integer msgType;

    /** 内容 */
    @Excel(name = "内容")
    private String msgContent;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 来源会话 */
    @Excel(name = "来源会话")
    private String msgFromSession;

    /** 来源用户 */
    @Excel(name = "来源用户")
    private String msgFromUserId;

    /** 目标会话 */
    @Excel(name = "目标会话")
    private String msgToSession;

    /** 目标用户 */
    @Excel(name = "目标用户")
    private String msgToUserId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setMsgType(Integer msgType)
    {
        this.msgType = msgType;
    }

    public Integer getMsgType()
    {
        return msgType;
    }
    public void setMsgContent(String msgContent)
    {
        this.msgContent = msgContent;
    }

    public String getMsgContent()
    {
        return msgContent;
    }
    public void setMsgFromSession(String msgFromSession)
    {
        this.msgFromSession = msgFromSession;
    }

    public String getMsgFromSession()
    {
        return msgFromSession;
    }
    public void setMsgFromUserId(String msgFromUserId)
    {
        this.msgFromUserId = msgFromUserId;
    }

    public String getMsgFromUserId()
    {
        return msgFromUserId;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setMsgToSession(String msgToSession)
    {
        this.msgToSession = msgToSession;
    }

    public String getMsgToSession()
    {
        return msgToSession;
    }
    public void setMsgToUserId(String msgToUserId)
    {
        this.msgToUserId = msgToUserId;
    }

    public String getMsgToUserId()
    {
        return msgToUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("msgType", getMsgType())
            .append("msgContent", getMsgContent())
            .append("msgFromSession", getMsgFromSession())
            .append("msgFromUserId", getMsgFromUserId())
            .append("avatar", getAvatar())
            .append("msgToSession", getMsgToSession())
            .append("msgToUserId", getMsgToUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
