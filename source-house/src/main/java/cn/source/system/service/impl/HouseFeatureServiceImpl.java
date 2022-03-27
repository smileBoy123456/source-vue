package cn.source.system.service.impl;

import cn.source.system.domain.HouseFeature;
import cn.source.system.mapper.HouseFeatureMapper;
import cn.source.system.service.IHouseFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 房源特色Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@Service
public class HouseFeatureServiceImpl implements IHouseFeatureService
{
    @Autowired
    private HouseFeatureMapper houseFeatureMapper;

    /**
     * 查询房源特色
     *
     * @param id 房源特色主键
     * @return 房源特色
     */
    @Override
    public HouseFeature selectHouseFeatureById(Long id)
    {
        return houseFeatureMapper.selectHouseFeatureById(id);
    }

    /**
     * 查询房源特色列表
     *
     * @param houseFeature 房源特色
     * @return 房源特色
     */
    @Override
    public List<HouseFeature> selectHouseFeatureList(HouseFeature houseFeature)
    {
        return houseFeatureMapper.selectHouseFeatureList(houseFeature);
    }

    /**
     * 新增房源特色
     *
     * @param houseFeature 房源特色
     * @return 结果
     */
    @Override
    public int insertHouseFeature(HouseFeature houseFeature)
    {
        return houseFeatureMapper.insertHouseFeature(houseFeature);
    }

    /**
     * 修改房源特色
     *
     * @param houseFeature 房源特色
     * @return 结果
     */
    @Override
    public int updateHouseFeature(HouseFeature houseFeature)
    {
        return houseFeatureMapper.updateHouseFeature(houseFeature);
    }

    /**
     * 批量删除房源特色
     *
     * @param ids 需要删除的房源特色主键
     * @return 结果
     */
    @Override
    public int deleteHouseFeatureByIds(Long[] ids)
    {
        return houseFeatureMapper.deleteHouseFeatureByIds(ids);
    }

    /**
     * 删除房源特色信息
     *
     * @param id 房源特色主键
     * @return 结果
     */
    @Override
    public int deleteHouseFeatureById(Long id)
    {
        return houseFeatureMapper.deleteHouseFeatureById(id);
    }
}
