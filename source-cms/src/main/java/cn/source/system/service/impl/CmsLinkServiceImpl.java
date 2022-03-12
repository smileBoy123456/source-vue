package cn.source.system.service.impl;

import cn.source.common.utils.DateUtils;
import cn.source.system.domain.CmsLink;
import cn.source.system.mapper.CmsLinkMapper;
import cn.source.system.service.ICmsLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友情链接Service业务层处理
 *
 * @author 詹Sir
 * @date 2022-03-12
 */
@Service
public class CmsLinkServiceImpl implements ICmsLinkService
{
    @Autowired
    private CmsLinkMapper cmsLinkMapper;

    /**
     * 查询友情链接
     *
     * @param id 友情链接主键
     * @return 友情链接
     */
    @Override
    public CmsLink selectCmsLinkById(Long id)
    {
        return cmsLinkMapper.selectCmsLinkById(id);
    }

    /**
     * 查询友情链接列表
     *
     * @param cmsLink 友情链接
     * @return 友情链接
     */
    @Override
    public List<CmsLink> selectCmsLinkList(CmsLink cmsLink)
    {
        return cmsLinkMapper.selectCmsLinkList(cmsLink);
    }

    /**
     * 新增友情链接
     *
     * @param cmsLink 友情链接
     * @return 结果
     */
    @Override
    public int insertCmsLink(CmsLink cmsLink)
    {
        cmsLink.setCreateTime(DateUtils.getNowDate());
        return cmsLinkMapper.insertCmsLink(cmsLink);
    }

    /**
     * 修改友情链接
     *
     * @param cmsLink 友情链接
     * @return 结果
     */
    @Override
    public int updateCmsLink(CmsLink cmsLink)
    {
        cmsLink.setUpdateTime(DateUtils.getNowDate());
        return cmsLinkMapper.updateCmsLink(cmsLink);
    }

    /**
     * 批量删除友情链接
     *
     * @param ids 需要删除的友情链接主键
     * @return 结果
     */
    @Override
    public int deleteCmsLinkByIds(Long[] ids)
    {
        return cmsLinkMapper.deleteCmsLinkByIds(ids);
    }

    /**
     * 删除友情链接信息
     *
     * @param id 友情链接主键
     * @return 结果
     */
    @Override
    public int deleteCmsLinkById(Long id)
    {
        return cmsLinkMapper.deleteCmsLinkById(id);
    }
}
