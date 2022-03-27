package cn.source.system.service.impl;

import cn.source.common.utils.DateUtils;
import cn.source.system.domain.HouseRoom;
import cn.source.system.mapper.HouseRoomMapper;
import cn.source.system.service.IHouseRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
