package cn.source.system.domain;

import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;
import cn.source.common.core.domain.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 房源详情对象 house_room
 *
 * @author ruoyi
 * @date 2022-03-27
 */
public class HouseRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    /** 0整租/1合租 */
    @Excel(name = "类型")
    private Integer type;

    private String houseHall;

    /** 居室 */
    @Excel(name = "居室")
    private String houseNum;

    private String houseCode;

    /** 卫生间 */
    @Excel(name = "卫生间")
    private String toiletNum;

    /** 整套面积 */
    @Excel(name = "整套面积")
    private BigDecimal houseArea;

    /** 1主卧,1次卧 */
    @Excel(name = "1主卧,1次卧")
    private Integer roomType;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomCode;

    /** 房屋面积 */
    @Excel(name = "房屋面积")
    private Long roomArea;

    /** 朝向 */
    @Excel(name = "朝向")
    private String direction;

    /** 租金 */
    @Excel(name = "租金")
    private BigDecimal price;

    /** 楼层 */
    @Excel(name = "楼层")
    private String floor;

    /** 楼房类型 */
    @Excel(name = "楼房类型")
    private String stepType;

    /** 起租日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起租日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 房源描述 */
    @Excel(name = "房源描述")
    private String introduce;

    /** 房东姓名 */
    @Excel(name = "房东姓名")
    private String ownerName;

    /** 房东电话 */
    @Excel(name = "房东电话")
    private String owerPhone;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String villageName;

    /** 具体地址 */
    @Excel(name = "具体地址")
    private String address;

    /** 房牌号 */
    @Excel(name = "房牌号")
    private String houseNo;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payType;

    /** 发布人id */
    @Excel(name = "发布人id")
    private Long publishId;

    /** 0：待出租，1：已出租,2:下架 */
    private Integer state;

    private String createName;

    private String updateName;

    private String code;

    private String faceUrl;

    private List<HouseImage> imageList;

    private List<HouseFeature> featureList;

    private HouseVillage village;

    private SysUser user;

    public HouseVillage getVillage() {
        return village;
    }

    public void setVillage(HouseVillage village) {
        this.village = village;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<HouseFeature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<HouseFeature> featureList) {
        this.featureList = featureList;
    }

    public List<HouseImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<HouseImage> imageList) {
        this.imageList = imageList;
    }


    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }

    public Integer getType()
    {
        return type;
    }
    public void setHouseNum(String houseNum)
    {
        this.houseNum = houseNum;
    }

    public String getHouseNum()
    {
        return houseNum;
    }
    public void setToiletNum(String toiletNum)
    {
        this.toiletNum = toiletNum;
    }

    public String getToiletNum()
    {
        return toiletNum;
    }
    public void setHouseArea(BigDecimal houseArea)
    {
        this.houseArea = houseArea;
    }

    public BigDecimal getHouseArea()
    {
        return houseArea;
    }
    public void setRoomType(Integer roomType)
    {
        this.roomType = roomType;
    }

    public Integer getRoomType()
    {
        return roomType;
    }
    public void setRoomCode(String roomCode)
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode()
    {
        return roomCode;
    }
    public void setRoomArea(Long roomArea)
    {
        this.roomArea = roomArea;
    }

    public Long getRoomArea()
    {
        return roomArea;
    }
    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public String getDirection()
    {
        return direction;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setFloor(String floor)
    {
        this.floor = floor;
    }

    public String getFloor()
    {
        return floor;
    }
    public void setStepType(String stepType)
    {
        this.stepType = stepType;
    }

    public String getStepType()
    {
        return stepType;
    }
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getStartDate()
    {
        return startDate;
    }
    public void setIntroduce(String introduce)
    {
        this.introduce = introduce;
    }

    public String getIntroduce()
    {
        return introduce;
    }
    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public String getOwnerName()
    {
        return ownerName;
    }
    public void setOwerPhone(String owerPhone)
    {
        this.owerPhone = owerPhone;
    }

    public String getOwerPhone()
    {
        return owerPhone;
    }
    public void setVillageId(Long villageId)
    {
        this.villageId = villageId;
    }

    public Long getVillageId()
    {
        return villageId;
    }
    public void setVillageName(String villageName)
    {
        this.villageName = villageName;
    }

    public String getVillageName()
    {
        return villageName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setHouseNo(String houseNo)
    {
        this.houseNo = houseNo;
    }

    public String getHouseNo()
    {
        return houseNo;
    }
    public void setPayType(String payType)
    {
        this.payType = payType;
    }

    public String getPayType()
    {
        return payType;
    }
    public void setPublishId(Long publishId)
    {
        this.publishId = publishId;
    }

    public Long getPublishId()
    {
        return publishId;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
    }
    public void setCreateName(String createName)
    {
        this.createName = createName;
    }

    public String getCreateName()
    {
        return createName;
    }
    public void setUpdateName(String updateName)
    {
        this.updateName = updateName;
    }

    public String getUpdateName()
    {
        return updateName;
    }
    public void setHouseHall(String houseHall)
    {
        this.houseHall = houseHall;
    }

    public String getHouseHall()
    {
        return houseHall;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setFaceUrl(String faceUrl)
    {
        this.faceUrl = faceUrl;
    }

    public String getFaceUrl()
    {
        return faceUrl;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("houseNum", getHouseNum())
            .append("toiletNum", getToiletNum())
            .append("houseArea", getHouseArea())
            .append("roomType", getRoomType())
            .append("roomCode", getRoomCode())
            .append("roomArea", getRoomArea())
            .append("direction", getDirection())
            .append("price", getPrice())
            .append("floor", getFloor())
            .append("stepType", getStepType())
            .append("startDate", getStartDate())
            .append("introduce", getIntroduce())
            .append("ownerName", getOwnerName())
            .append("owerPhone", getOwerPhone())
            .append("villageId", getVillageId())
            .append("villageName", getVillageName())
            .append("address", getAddress())
            .append("houseNo", getHouseNo())
            .append("payType", getPayType())
            .append("publishId", getPublishId())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("createName", getCreateName())
            .append("updateTime", getUpdateTime())
            .append("updateName", getUpdateName())
            .append("remark", getRemark())
            .append("houseHall", getHouseHall())
            .append("code", getCode())
            .append("faceUrl", getFaceUrl())
            .toString();
    }
}
