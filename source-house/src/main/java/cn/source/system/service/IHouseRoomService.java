package cn.source.system.service;

import cn.source.system.domain.HouseRoom;

import java.util.List;

/**
 * 房源详情Service接口
 *
 * @author ruoyi
 * @date 2022-03-27
 */
public interface IHouseRoomService
{
    /**
     * 查询房源详情
     *
     * @param id 房源详情主键
     * @return 房源详情
     */
    public HouseRoom selectHouseRoomById(Long id);

    /**
     * 查询房源详情列表
     *
     * @param houseRoom 房源详情
     * @return 房源详情集合
     */
    public List<HouseRoom> selectHouseRoomList(HouseRoom houseRoom);

    /**
     * 新增房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    public int insertHouseRoom(HouseRoom houseRoom);

    /**
     * 修改房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    public int updateHouseRoom(HouseRoom houseRoom);

    /**
     * 批量删除房源详情
     *
     * @param ids 需要删除的房源详情主键集合
     * @return 结果
     */
    public int deleteHouseRoomByIds(Long[] ids);

    /**
     * 删除房源详情信息
     *
     * @param id 房源详情主键
     * @return 结果
     */
    public int deleteHouseRoomById(Long id);

    /**
     * api新增房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    public int apiInsertHouseRoom(HouseRoom houseRoom);

    /**
     * 查询房源相关详情信息
     *
     * @param houseRoom 房源
     * @return 房源详情
     */
    public HouseRoom selectDetailHouseRoom(HouseRoom houseRoom);
}
