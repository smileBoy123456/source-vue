package cn.source.system.service.impl;

import cn.source.common.utils.DateUtils;
import cn.source.system.domain.CmsMsg;
import cn.source.system.mapper.CmsMsgMapper;
import cn.source.system.service.ICmsMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息管理Service业务层处理
 *
 * @author 詹Sir
 * @date 2022-04-03
 */
@Service
public class CmsMsgServiceImpl implements ICmsMsgService
{
    @Autowired
    private CmsMsgMapper cmsMsgMapper;

    /**
     * 查询消息管理
     *
     * @param id 消息管理主键
     * @return 消息管理
     */
    @Override
    public CmsMsg selectCmsMsgById(Long id)
    {
        return cmsMsgMapper.selectCmsMsgById(id);
    }

    /**
     * 查询消息管理列表
     *
     * @param cmsMsg 消息管理
     * @return 消息管理
     */
    @Override
    public List<CmsMsg> selectCmsMsgList(CmsMsg cmsMsg)
    {
        return cmsMsgMapper.selectCmsMsgList(cmsMsg);
    }

    /**
     * 新增消息管理
     *
     * @param cmsMsg 消息管理
     * @return 结果
     */
    @Override
    public int insertCmsMsg(CmsMsg cmsMsg)
    {
        cmsMsg.setCreateTime(DateUtils.getNowDate());
        return cmsMsgMapper.insertCmsMsg(cmsMsg);
    }

    /**
     * 修改消息管理
     *
     * @param cmsMsg 消息管理
     * @return 结果
     */
    @Override
    public int updateCmsMsg(CmsMsg cmsMsg)
    {
        cmsMsg.setUpdateTime(DateUtils.getNowDate());
        return cmsMsgMapper.updateCmsMsg(cmsMsg);
    }

    /**
     * 批量删除消息管理
     *
     * @param ids 需要删除的消息管理主键
     * @return 结果
     */
    @Override
    public int deleteCmsMsgByIds(Long[] ids)
    {
        return cmsMsgMapper.deleteCmsMsgByIds(ids);
    }

    /**
     * 删除消息管理信息
     *
     * @param id 消息管理主键
     * @return 结果
     */
    @Override
    public int deleteCmsMsgById(Long id)
    {
        return cmsMsgMapper.deleteCmsMsgById(id);
    }
}
