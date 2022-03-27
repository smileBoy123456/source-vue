package cn.source.system.service;

import cn.source.system.domain.HouseFeature;

import java.util.List;

/**
 * 房源特色Service接口
 *
 * @author ruoyi
 * @date 2022-03-27
 */
public interface IHouseFeatureService
{
    /**
     * 查询房源特色
     *
     * @param id 房源特色主键
     * @return 房源特色
     */
    public HouseFeature selectHouseFeatureById(Long id);

    /**
     * 查询房源特色列表
     *
     * @param houseFeature 房源特色
     * @return 房源特色集合
     */
    public List<HouseFeature> selectHouseFeatureList(HouseFeature houseFeature);

    /**
     * 新增房源特色
     *
     * @param houseFeature 房源特色
     * @return 结果
     */
    public int insertHouseFeature(HouseFeature houseFeature);

    /**
     * 修改房源特色
     *
     * @param houseFeature 房源特色
     * @return 结果
     */
    public int updateHouseFeature(HouseFeature houseFeature);

    /**
     * 批量删除房源特色
     *
     * @param ids 需要删除的房源特色主键集合
     * @return 结果
     */
    public int deleteHouseFeatureByIds(Long[] ids);

    /**
     * 删除房源特色信息
     *
     * @param id 房源特色主键
     * @return 结果
     */
    public int deleteHouseFeatureById(Long id);
}
