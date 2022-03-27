package cn.source.system.mapper;

import cn.source.system.domain.HouseVillage;

import java.util.List;

/**
 * 房源小区Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-27
 */
public interface HouseVillageMapper
{
    /**
     * 查询房源小区
     *
     * @param id 房源小区主键
     * @return 房源小区
     */
    public HouseVillage selectHouseVillageById(Long id);

    /**
     * 查询房源小区列表
     *
     * @param houseVillage 房源小区
     * @return 房源小区集合
     */
    public List<HouseVillage> selectHouseVillageList(HouseVillage houseVillage);

    /**
     * 新增房源小区
     *
     * @param houseVillage 房源小区
     * @return 结果
     */
    public int insertHouseVillage(HouseVillage houseVillage);

    /**
     * 修改房源小区
     *
     * @param houseVillage 房源小区
     * @return 结果
     */
    public int updateHouseVillage(HouseVillage houseVillage);

    /**
     * 删除房源小区
     *
     * @param id 房源小区主键
     * @return 结果
     */
    public int deleteHouseVillageById(Long id);

    /**
     * 批量删除房源小区
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHouseVillageByIds(Long[] ids);
}
