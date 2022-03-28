package cn.source.system.service.impl;

import cn.source.common.utils.DateUtils;
import cn.source.common.utils.StringUtils;
import cn.source.common.utils.uuid.CodeUtil;
import cn.source.system.domain.HouseFeature;
import cn.source.system.domain.HouseImage;
import cn.source.system.domain.HouseRoom;
import cn.source.system.domain.HouseVillage;
import cn.source.system.mapper.HouseRoomMapper;
import cn.source.system.service.IHouseRoomService;
import cn.source.system.service.IHouseVillageService;
import cn.source.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 房源详情Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@Service
public class HouseRoomServiceImpl implements IHouseRoomService
{


    @Autowired
    private ISysUserService userService;

    @Autowired
    private IHouseVillageService houseVillageService;

    @Autowired
    private HouseRoomMapper houseRoomMapper;

    /**
     * 查询房源详情
     *
     * @param id 房源详情主键
     * @return 房源详情
     */
    @Override
    public HouseRoom selectHouseRoomById(Long id)
    {
        return houseRoomMapper.selectHouseRoomById(id);
    }

    /**
     * 查询房源详情列表
     *
     * @param houseRoom 房源详情
     * @return 房源详情
     */
    @Override
    public List<HouseRoom> selectHouseRoomList(HouseRoom houseRoom)
    {
        return houseRoomMapper.selectHouseRoomList(houseRoom);
    }

    /**
     * 新增房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    @Override
    public int insertHouseRoom(HouseRoom houseRoom)
    {
        houseRoom.setCreateTime(DateUtils.getNowDate());
        return houseRoomMapper.insertHouseRoom(houseRoom);
    }

    /**
     * 修改房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    @Override
    public int updateHouseRoom(HouseRoom houseRoom)
    {
        houseRoom.setUpdateTime(DateUtils.getNowDate());
        return houseRoomMapper.updateHouseRoom(houseRoom);
    }

    /**
     * 批量删除房源详情
     *
     * @param ids 需要删除的房源详情主键
     * @return 结果
     */
    @Override
    public int deleteHouseRoomByIds(Long[] ids)
    {
        return houseRoomMapper.deleteHouseRoomByIds(ids);
    }

    /**
     * 删除房源详情信息
     *
     * @param id 房源详情主键
     * @return 结果
     */
    @Override
    public int deleteHouseRoomById(Long id)
    {
        return houseRoomMapper.deleteHouseRoomById(id);
    }

    /**
     * API新增房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    @Override
    public int apiInsertHouseRoom(HouseRoom houseRoom)
    {
        houseRoom.setCreateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(houseRoom.getVillageName())){
            HouseVillage houseVillage = houseVillageService.selectHouseVillageById(houseRoom.getVillageId());
            houseRoom.setVillageName(houseVillage.getName());
        }
        if(StringUtils.isNull(houseRoom.getVillageId())){
            HouseVillage houseVillage = new HouseVillage();
            houseVillage.setName(houseRoom.getVillageName());
            houseVillage = houseVillageService.selectHouseVillage(houseVillage);
            houseRoom.setVillageId(houseVillage.getId());
        }
        if(StringUtils.isNull(houseRoom.getStartDate())){
            houseRoom.setStartDate(new Date());
        }
        houseRoom.setCode(CodeUtil.getCodeByUUId());
        houseRoomMapper.insertHouseRoom(houseRoom);
        houseRoomMapper.insertHouseFeature(houseRoom);
        houseRoomMapper.insertHouseImage(houseRoom);
        houseRoom.setFaceUrl(houseRoom.getImageList().get(0).getImgUrl());
        return houseRoomMapper.updateHouseRoom(houseRoom);
    }

    /**
     * 查询房源相关详情信息
     *
     * @param houseRoom 房源
     * @return 房源详情
     */
    @Override
    public HouseRoom selectDetailHouseRoom(HouseRoom houseRoom) {
        List<HouseImage> houseImages = houseRoomMapper.selectHouseImage(houseRoom);
        List<HouseFeature> houseFeatures = houseRoomMapper.selectHouseFeature(houseRoom);
        houseRoom.setImageList(houseImages);
        houseRoom.setFeatureList(houseFeatures);
        houseRoom.setUser(userService.selectUserById(houseRoom.getPublishId()));
        houseRoom.setVillage(houseVillageService.selectHouseVillageById(houseRoom.getVillageId()));
        return houseRoom;
    }
}
