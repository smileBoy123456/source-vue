package cn.source.system.service;

import cn.source.system.domain.CmsArticle;

import java.util.List;

/**
 * 内容管理Service接口
 *
 * @author 詹Sir
 * @date 2022-03-01
 */
public interface ICmsArticleService
{
    /**
     * 查询内容管理
     *
     * @param id 内容管理主键
     * @return 内容管理
     */
    public CmsArticle selectCmsArticleById(Long id);

    /**
     * 查询内容管理列表
     *
     * @param cmsArticle 内容管理
     * @return 内容管理集合
     */
    public List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle);

    /**
     * 新增内容管理
     *
     * @param cmsArticle 内容管理
     * @return 结果
     */
    public int insertCmsArticle(CmsArticle cmsArticle);

    /**
     * 修改内容管理
     *
     * @param cmsArticle 内容管理
     * @return 结果
     */
    public int updateCmsArticle(CmsArticle cmsArticle);

    /**
     * 批量删除内容管理
     *
     * @param ids 需要删除的内容管理主键集合
     * @return 结果
     */
    public int deleteCmsArticleByIds(Long[] ids);

    /**
     * 删除内容管理信息
     *
     * @param id 内容管理主键
     * @return 结果
     */
    public int deleteCmsArticleById(Long id);

    /**
     * 点赞文章
     *
     * @param cmsArticle 内容管理
     * @return 结果
     */
    public int starCmsArticle(CmsArticle cmsArticle);
}
