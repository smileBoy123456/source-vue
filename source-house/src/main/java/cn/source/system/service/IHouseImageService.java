package cn.source.system.service;

import cn.source.system.domain.HouseImage;

import java.util.List;

/**
 * 房源图片Service接口
 *
 * @author ruoyi
 * @date 2022-03-27
 */
public interface IHouseImageService
{
    /**
     * 查询房源图片
     *
     * @param id 房源图片主键
     * @return 房源图片
     */
    public HouseImage selectHouseImageById(Long id);

    /**
     * 查询房源图片列表
     *
     * @param houseImage 房源图片
     * @return 房源图片集合
     */
    public List<HouseImage> selectHouseImageList(HouseImage houseImage);

    /**
     * 新增房源图片
     *
     * @param houseImage 房源图片
     * @return 结果
     */
    public int insertHouseImage(HouseImage houseImage);

    /**
     * 修改房源图片
     *
     * @param houseImage 房源图片
     * @return 结果
     */
    public int updateHouseImage(HouseImage houseImage);

    /**
     * 批量删除房源图片
     *
     * @param ids 需要删除的房源图片主键集合
     * @return 结果
     */
    public int deleteHouseImageByIds(Long[] ids);

    /**
     * 删除房源图片信息
     *
     * @param id 房源图片主键
     * @return 结果
     */
    public int deleteHouseImageById(Long id);
}
