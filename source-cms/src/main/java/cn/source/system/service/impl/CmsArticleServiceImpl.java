package cn.source.system.service.impl;

import cn.source.common.utils.DateUtils;
import cn.source.system.domain.CmsArticle;
import cn.source.system.mapper.CmsArticleMapper;
import cn.source.system.service.ICmsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容管理Service业务层处理
 *
 * @author 詹Sir
 * @date 2022-03-01
 */
@Service
public class CmsArticleServiceImpl implements ICmsArticleService
{
    @Autowired
    private CmsArticleMapper cmsArticleMapper;

    /**
     * 查询内容管理
     *
     * @param id 内容管理主键
     * @return 内容管理
     */
    @Override
    public CmsArticle selectCmsArticleById(Long id)
    {
        return cmsArticleMapper.selectCmsArticleById(id);
    }

    /**
     * 查询内容管理列表
     *
     * @param cmsArticle 内容管理
     * @return 内容管理
     */
    @Override
    public List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle)
    {
        return cmsArticleMapper.selectCmsArticleList(cmsArticle);
    }

    /**
     * 新增内容管理
     *
     * @param cmsArticle 内容管理
     * @return 结果
     */
    @Override
    public int insertCmsArticle(CmsArticle cmsArticle)
    {
        cmsArticle.setCreateTime(DateUtils.getNowDate());
        return cmsArticleMapper.insertCmsArticle(cmsArticle);
    }

    /**
     * 修改内容管理
     *
     * @param cmsArticle 内容管理
     * @return 结果
     */
    @Override
    public int updateCmsArticle(CmsArticle cmsArticle)
    {
        cmsArticle.setUpdateTime(DateUtils.getNowDate());
        return cmsArticleMapper.updateCmsArticle(cmsArticle);
    }

    /**
     * 批量删除内容管理
     *
     * @param ids 需要删除的内容管理主键
     * @return 结果
     */
    @Override
    public int deleteCmsArticleByIds(Long[] ids)
    {
        return cmsArticleMapper.deleteCmsArticleByIds(ids);
    }

    /**
     * 删除内容管理信息
     *
     * @param id 内容管理主键
     * @return 结果
     */
    @Override
    public int deleteCmsArticleById(Long id)
    {
        return cmsArticleMapper.deleteCmsArticleById(id);
    }

    /**
    * @author: zy
    * @date: 点赞
    */
    @Override
    public int starCmsArticle(CmsArticle cmsArticle) {
        cmsArticle.setUpdateTime(DateUtils.getNowDate());
        return cmsArticleMapper.starCmsArticle(cmsArticle);
    }
}
