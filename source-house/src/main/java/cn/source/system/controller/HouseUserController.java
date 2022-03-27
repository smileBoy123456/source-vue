package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.HouseUser;
import cn.source.system.service.IHouseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 出租信息Controller
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@RestController
@RequestMapping("/system/houseUser")
public class HouseUserController extends BaseController
{
    @Autowired
    private IHouseUserService houseUserService;

    /**
     * 查询出租信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(HouseUser houseUser)
    {
        startPage();
        List<HouseUser> list = houseUserService.selectHouseUserList(houseUser);
        return getDataTable(list);
    }

    /**
     * 导出出租信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseUser:export')")
    @Log(title = "出租信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HouseUser houseUser)
    {
        List<HouseUser> list = houseUserService.selectHouseUserList(houseUser);
        ExcelUtil<HouseUser> util = new ExcelUtil<HouseUser>(HouseUser.class);
        util.exportExcel(response, list, "出租信息数据");
    }

    /**
     * 获取出租信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(houseUserService.selectHouseUserById(id));
    }

    /**
     * 新增出租信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseUser:add')")
    @Log(title = "出租信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseUser houseUser)
    {
        return toAjax(houseUserService.insertHouseUser(houseUser));
    }

    /**
     * 修改出租信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseUser:edit')")
    @Log(title = "出租信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HouseUser houseUser)
    {
        return toAjax(houseUserService.updateHouseUser(houseUser));
    }

    /**
     * 删除出租信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseUser:remove')")
    @Log(title = "出租信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(houseUserService.deleteHouseUserByIds(ids));
    }
}
