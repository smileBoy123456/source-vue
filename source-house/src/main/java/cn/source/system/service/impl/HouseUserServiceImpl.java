package cn.source.system.service.impl;

import cn.source.common.utils.DateUtils;
import cn.source.system.domain.HouseUser;
import cn.source.system.mapper.HouseUserMapper;
import cn.source.system.service.IHouseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出租信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@Service
public class HouseUserServiceImpl implements IHouseUserService
{
    @Autowired
    private HouseUserMapper houseUserMapper;

    /**
     * 查询出租信息
     *
     * @param id 出租信息主键
     * @return 出租信息
     */
    @Override
    public HouseUser selectHouseUserById(Long id)
    {
        return houseUserMapper.selectHouseUserById(id);
    }

    /**
     * 查询出租信息列表
     *
     * @param houseUser 出租信息
     * @return 出租信息
     */
    @Override
    public List<HouseUser> selectHouseUserList(HouseUser houseUser)
    {
        return houseUserMapper.selectHouseUserList(houseUser);
    }

    /**
     * 新增出租信息
     *
     * @param houseUser 出租信息
     * @return 结果
     */
    @Override
    public int insertHouseUser(HouseUser houseUser)
    {
        houseUser.setCreateTime(DateUtils.getNowDate());
        return houseUserMapper.insertHouseUser(houseUser);
    }

    /**
     * 修改出租信息
     *
     * @param houseUser 出租信息
     * @return 结果
     */
    @Override
    public int updateHouseUser(HouseUser houseUser)
    {
        houseUser.setUpdateTime(DateUtils.getNowDate());
        return houseUserMapper.updateHouseUser(houseUser);
    }

    /**
     * 批量删除出租信息
     *
     * @param ids 需要删除的出租信息主键
     * @return 结果
     */
    @Override
    public int deleteHouseUserByIds(Long[] ids)
    {
        return houseUserMapper.deleteHouseUserByIds(ids);
    }

    /**
     * 删除出租信息信息
     *
     * @param id 出租信息主键
     * @return 结果
     */
    @Override
    public int deleteHouseUserById(Long id)
    {
        return houseUserMapper.deleteHouseUserById(id);
    }
}
