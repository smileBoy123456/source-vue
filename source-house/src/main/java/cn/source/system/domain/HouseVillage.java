package cn.source.system.domain;

import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 房源小区对象 house_village
 *
 * @author ruoyi
 * @date 2022-03-27
 */
public class HouseVillage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String area;

    private String areaCode;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 代号 */
    @Excel(name = "代号")
    private String code;

    /** 年份 */
    @Excel(name = "年份")
    private Integer year;

    /** 建筑类型 */
    @Excel(name = "建筑类型")
    private String type;

    /** 绿化率 */
    @Excel(name = "绿化率")
    private BigDecimal green;

    /** 介绍 */
    @Excel(name = "介绍")
    private String introduce;

    /** 靠近地铁 */
    @Excel(name = "靠近地铁")
    private Integer wayState;

    /** 地铁线路 */
    @Excel(name = "地铁线路")
    private String wayCode;

    /** 地铁距离 */
    @Excel(name = "地铁距离")
    private Integer waySpace;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal lon;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal lat;

    /** 状态 */
    @Excel(name = "状态")
    private Integer state;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea()
    {
        return area;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setYear(Integer year)
    {
        this.year = year;
    }

    public Integer getYear()
    {
        return year;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setGreen(BigDecimal green)
    {
        this.green = green;
    }

    public BigDecimal getGreen()
    {
        return green;
    }
    public void setIntroduce(String introduce)
    {
        this.introduce = introduce;
    }

    public String getIntroduce()
    {
        return introduce;
    }
    public void setWayState(Integer wayState)
    {
        this.wayState = wayState;
    }

    public Integer getWayState()
    {
        return wayState;
    }
    public void setWayCode(String wayCode)
    {
        this.wayCode = wayCode;
    }

    public String getWayCode()
    {
        return wayCode;
    }
    public void setWaySpace(Integer waySpace)
    {
        this.waySpace = waySpace;
    }

    public Integer getWaySpace()
    {
        return waySpace;
    }
    public void setLon(BigDecimal lon)
    {
        this.lon = lon;
    }

    public BigDecimal getLon()
    {
        return lon;
    }
    public void setLat(BigDecimal lat)
    {
        this.lat = lat;
    }

    public BigDecimal getLat()
    {
        return lat;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("province", getProvince())
            .append("city", getCity())
            .append("area", getArea())
            .append("name", getName())
            .append("code", getCode())
            .append("year", getYear())
            .append("type", getType())
            .append("green", getGreen())
            .append("introduce", getIntroduce())
            .append("wayState", getWayState())
            .append("wayCode", getWayCode())
            .append("waySpace", getWaySpace())
            .append("lon", getLon())
            .append("lat", getLat())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
