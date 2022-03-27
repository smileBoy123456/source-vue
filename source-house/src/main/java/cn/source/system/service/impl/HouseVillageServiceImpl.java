package cn.source.system.service.impl;

import cn.source.common.utils.DateUtils;
import cn.source.system.domain.HouseVillage;
import cn.source.system.mapper.HouseVillageMapper;
import cn.source.system.service.IHouseVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 房源小区Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@Service
public class HouseVillageServiceImpl implements IHouseVillageService
{
    @Autowired
    private HouseVillageMapper houseVillageMapper;

    /**
     * 查询房源小区
     *
     * @param id 房源小区主键
     * @return 房源小区
     */
    @Override
    public HouseVillage selectHouseVillageById(Long id)
    {
        return houseVillageMapper.selectHouseVillageById(id);
    }

    /**
     * 查询房源小区列表
     *
     * @param houseVillage 房源小区
     * @return 房源小区
     */
    @Override
    public List<HouseVillage> selectHouseVillageList(HouseVillage houseVillage)
    {
        return houseVillageMapper.selectHouseVillageList(houseVillage);
    }

    /**
     * 新增房源小区
     *
     * @param houseVillage 房源小区
     * @return 结果
     */
    @Override
    public int insertHouseVillage(HouseVillage houseVillage)
    {
        houseVillage.setCreateTime(DateUtils.getNowDate());
        return houseVillageMapper.insertHouseVillage(houseVillage);
    }

    /**
     * 修改房源小区
     *
     * @param houseVillage 房源小区
     * @return 结果
     */
    @Override
    public int updateHouseVillage(HouseVillage houseVillage)
    {
        houseVillage.setUpdateTime(DateUtils.getNowDate());
        return houseVillageMapper.updateHouseVillage(houseVillage);
    }

    /**
     * 批量删除房源小区
     *
     * @param ids 需要删除的房源小区主键
     * @return 结果
     */
    @Override
    public int deleteHouseVillageByIds(Long[] ids)
    {
        return houseVillageMapper.deleteHouseVillageByIds(ids);
    }

    /**
     * 删除房源小区信息
     *
     * @param id 房源小区主键
     * @return 结果
     */
    @Override
    public int deleteHouseVillageById(Long id)
    {
        return houseVillageMapper.deleteHouseVillageById(id);
    }
}
