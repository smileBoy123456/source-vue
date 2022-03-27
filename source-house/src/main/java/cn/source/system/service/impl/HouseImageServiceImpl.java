package cn.source.system.service.impl;

import cn.source.system.domain.HouseImage;
import cn.source.system.mapper.HouseImageMapper;
import cn.source.system.service.IHouseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 房源图片Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@Service
public class HouseImageServiceImpl implements IHouseImageService
{
    @Autowired
    private HouseImageMapper houseImageMapper;

    /**
     * 查询房源图片
     *
     * @param id 房源图片主键
     * @return 房源图片
     */
    @Override
    public HouseImage selectHouseImageById(Long id)
    {
        return houseImageMapper.selectHouseImageById(id);
    }

    /**
     * 查询房源图片列表
     *
     * @param houseImage 房源图片
     * @return 房源图片
     */
    @Override
    public List<HouseImage> selectHouseImageList(HouseImage houseImage)
    {
        return houseImageMapper.selectHouseImageList(houseImage);
    }

    /**
     * 新增房源图片
     *
     * @param houseImage 房源图片
     * @return 结果
     */
    @Override
    public int insertHouseImage(HouseImage houseImage)
    {
        return houseImageMapper.insertHouseImage(houseImage);
    }

    /**
     * 修改房源图片
     *
     * @param houseImage 房源图片
     * @return 结果
     */
    @Override
    public int updateHouseImage(HouseImage houseImage)
    {
        return houseImageMapper.updateHouseImage(houseImage);
    }

    /**
     * 批量删除房源图片
     *
     * @param ids 需要删除的房源图片主键
     * @return 结果
     */
    @Override
    public int deleteHouseImageByIds(Long[] ids)
    {
        return houseImageMapper.deleteHouseImageByIds(ids);
    }

    /**
     * 删除房源图片信息
     *
     * @param id 房源图片主键
     * @return 结果
     */
    @Override
    public int deleteHouseImageById(Long id)
    {
        return houseImageMapper.deleteHouseImageById(id);
    }
}
