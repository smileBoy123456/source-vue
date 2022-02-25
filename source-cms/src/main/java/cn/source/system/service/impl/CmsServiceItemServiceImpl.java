package cn.source.system.service.impl;

import cn.source.common.utils.DateUtils;
import cn.source.system.domain.CmsServiceItem;
import cn.source.system.mapper.CmsServiceItemMapper;
import cn.source.system.service.ICmsServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务条目Service业务层处理
 *
 * @author 詹Sir
 * @date 2022-02-25
 */
@Service
public class CmsServiceItemServiceImpl implements ICmsServiceItemService
{
    @Autowired
    private CmsServiceItemMapper cmsServiceItemMapper;

    /**
     * 查询服务条目
     *
     * @param id 服务条目主键
     * @return 服务条目
     */
    @Override
    public CmsServiceItem selectCmsServiceItemById(Long id)
    {
        return cmsServiceItemMapper.selectCmsServiceItemById(id);
    }

    /**
     * 查询服务条目列表
     *
     * @param cmsServiceItem 服务条目
     * @return 服务条目
     */
    @Override
    public List<CmsServiceItem> selectCmsServiceItemList(CmsServiceItem cmsServiceItem)
    {
        return cmsServiceItemMapper.selectCmsServiceItemList(cmsServiceItem);
    }

    /**
     * 新增服务条目
     *
     * @param cmsServiceItem 服务条目
     * @return 结果
     */
    @Override
    public int insertCmsServiceItem(CmsServiceItem cmsServiceItem)
    {
        cmsServiceItem.setCreateTime(DateUtils.getNowDate());
        return cmsServiceItemMapper.insertCmsServiceItem(cmsServiceItem);
    }

    /**
     * 修改服务条目
     *
     * @param cmsServiceItem 服务条目
     * @return 结果
     */
    @Override
    public int updateCmsServiceItem(CmsServiceItem cmsServiceItem)
    {
        cmsServiceItem.setUpdateTime(DateUtils.getNowDate());
        return cmsServiceItemMapper.updateCmsServiceItem(cmsServiceItem);
    }

    /**
     * 批量删除服务条目
     *
     * @param ids 需要删除的服务条目主键
     * @return 结果
     */
    @Override
    public int deleteCmsServiceItemByIds(Long[] ids)
    {
        return cmsServiceItemMapper.deleteCmsServiceItemByIds(ids);
    }

    /**
     * 删除服务条目信息
     *
     * @param id 服务条目主键
     * @return 结果
     */
    @Override
    public int deleteCmsServiceItemById(Long id)
    {
        return cmsServiceItemMapper.deleteCmsServiceItemById(id);
    }
}
