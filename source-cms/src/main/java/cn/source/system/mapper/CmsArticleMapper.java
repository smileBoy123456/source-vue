package cn.source.system.mapper;

import cn.source.system.domain.CmsArticle;

import java.util.List;

/**
 * 文章管理Mapper接口
 *
 * @author 詹Sir
 * @date 2022-03-01
 */
public interface CmsArticleMapper
{
    /**
     * 查询文章管理
     *
     * @param id 文章管理主键
     * @return 文章管理
     */
    public CmsArticle selectCmsArticleById(Long id);

    /**
     * 查询文章管理列表
     *
     * @param cmsArticle 文章管理
     * @return 文章管理集合
     */
    public List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle);

    /**
     * 新增文章管理
     *
     * @param cmsArticle 文章管理
     * @return 结果
     */
    public int insertCmsArticle(CmsArticle cmsArticle);

    /**
     * 修改文章管理
     *
     * @param cmsArticle 文章管理
     * @return 结果
     */
    public int updateCmsArticle(CmsArticle cmsArticle);

    /**
     * 删除文章管理
     *
     * @param id 文章管理主键
     * @return 结果
     */
    public int deleteCmsArticleById(Long id);

    /**
     * 批量删除文章管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCmsArticleByIds(Long[] ids);

    /**
     * 点赞文章
     *
     * @param cmsArticle 文章管理
     * @return 结果
     */
    public int starCmsArticle(CmsArticle cmsArticle);
}
