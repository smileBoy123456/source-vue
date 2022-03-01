package cn.source.system.service.impl;

import java.util.List;
import cn.source.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.CmsFeedbackMapper;
import cn.source.system.domain.CmsFeedback;
import cn.source.system.service.ICmsFeedbackService;

/**
 * 意见反馈Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-01
 */
@Service
public class CmsFeedbackServiceImpl implements ICmsFeedbackService 
{
    @Autowired
    private CmsFeedbackMapper cmsFeedbackMapper;

    /**
     * 查询意见反馈
     * 
     * @param id 意见反馈主键
     * @return 意见反馈
     */
    @Override
    public CmsFeedback selectCmsFeedbackById(Long id)
    {
        return cmsFeedbackMapper.selectCmsFeedbackById(id);
    }

    /**
     * 查询意见反馈列表
     * 
     * @param cmsFeedback 意见反馈
     * @return 意见反馈
     */
    @Override
    public List<CmsFeedback> selectCmsFeedbackList(CmsFeedback cmsFeedback)
    {
        return cmsFeedbackMapper.selectCmsFeedbackList(cmsFeedback);
    }

    /**
     * 新增意见反馈
     * 
     * @param cmsFeedback 意见反馈
     * @return 结果
     */
    @Override
    public int insertCmsFeedback(CmsFeedback cmsFeedback)
    {
        cmsFeedback.setCreateTime(DateUtils.getNowDate());
        return cmsFeedbackMapper.insertCmsFeedback(cmsFeedback);
    }

    /**
     * 修改意见反馈
     * 
     * @param cmsFeedback 意见反馈
     * @return 结果
     */
    @Override
    public int updateCmsFeedback(CmsFeedback cmsFeedback)
    {
        cmsFeedback.setUpdateTime(DateUtils.getNowDate());
        return cmsFeedbackMapper.updateCmsFeedback(cmsFeedback);
    }

    /**
     * 批量删除意见反馈
     * 
     * @param ids 需要删除的意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteCmsFeedbackByIds(Long[] ids)
    {
        return cmsFeedbackMapper.deleteCmsFeedbackByIds(ids);
    }

    /**
     * 删除意见反馈信息
     * 
     * @param id 意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteCmsFeedbackById(Long id)
    {
        return cmsFeedbackMapper.deleteCmsFeedbackById(id);
    }
}
