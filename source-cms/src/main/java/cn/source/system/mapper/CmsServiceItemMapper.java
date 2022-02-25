package cn.source.system.mapper;

import cn.source.system.domain.CmsServiceItem;

import java.util.List;

/**
 * 服务条目Mapper接口
 *
 * @author 詹Sir
 * @date 2022-02-25
 */
public interface CmsServiceItemMapper
{
    /**
     * 查询服务条目
     *
     * @param id 服务条目主键
     * @return 服务条目
     */
    public CmsServiceItem selectCmsServiceItemById(Long id);

    /**
     * 查询服务条目列表
     *
     * @param cmsServiceItem 服务条目
     * @return 服务条目集合
     */
    public List<CmsServiceItem> selectCmsServiceItemList(CmsServiceItem cmsServiceItem);

    /**
     * 新增服务条目
     *
     * @param cmsServiceItem 服务条目
     * @return 结果
     */
    public int insertCmsServiceItem(CmsServiceItem cmsServiceItem);

    /**
     * 修改服务条目
     *
     * @param cmsServiceItem 服务条目
     * @return 结果
     */
    public int updateCmsServiceItem(CmsServiceItem cmsServiceItem);

    /**
     * 删除服务条目
     *
     * @param id 服务条目主键
     * @return 结果
     */
    public int deleteCmsServiceItemById(Long id);

    /**
     * 批量删除服务条目
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCmsServiceItemByIds(Long[] ids);
}
