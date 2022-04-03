package cn.source.system.mapper;

import cn.source.system.domain.CmsMsg;

import java.util.List;

/**
 * 消息管理Mapper接口
 *
 * @author 詹Sir
 * @date 2022-04-03
 */
public interface CmsMsgMapper
{
    /**
     * 查询消息管理
     *
     * @param id 消息管理主键
     * @return 消息管理
     */
    public CmsMsg selectCmsMsgById(Long id);

    /**
     * 查询消息管理列表
     *
     * @param cmsMsg 消息管理
     * @return 消息管理集合
     */
    public List<CmsMsg> selectCmsMsgList(CmsMsg cmsMsg);

    /**
     * 新增消息管理
     *
     * @param cmsMsg 消息管理
     * @return 结果
     */
    public int insertCmsMsg(CmsMsg cmsMsg);

    /**
     * 修改消息管理
     *
     * @param cmsMsg 消息管理
     * @return 结果
     */
    public int updateCmsMsg(CmsMsg cmsMsg);

    /**
     * 删除消息管理
     *
     * @param id 消息管理主键
     * @return 结果
     */
    public int deleteCmsMsgById(Long id);

    /**
     * 批量删除消息管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCmsMsgByIds(Long[] ids);
}
