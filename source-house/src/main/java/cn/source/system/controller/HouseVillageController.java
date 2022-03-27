package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.HouseVillage;
import cn.source.system.service.IHouseVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 房源小区Controller
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@RestController
@RequestMapping("/system/houseVillage")
public class HouseVillageController extends BaseController
{
    @Autowired
    private IHouseVillageService houseVillageService;

    /**
     * 查询房源小区列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseVillage:list')")
    @GetMapping("/list")
    public TableDataInfo list(HouseVillage houseVillage)
    {
        startPage();
        List<HouseVillage> list = houseVillageService.selectHouseVillageList(houseVillage);
        return getDataTable(list);
    }

    /**
     * 导出房源小区列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseVillage:export')")
    @Log(title = "房源小区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HouseVillage houseVillage)
    {
        List<HouseVillage> list = houseVillageService.selectHouseVillageList(houseVillage);
        ExcelUtil<HouseVillage> util = new ExcelUtil<HouseVillage>(HouseVillage.class);
        util.exportExcel(response, list, "房源小区数据");
    }

    /**
     * 获取房源小区详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseVillage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(houseVillageService.selectHouseVillageById(id));
    }

    /**
     * 新增房源小区
     */
    @PreAuthorize("@ss.hasPermi('system:houseVillage:add')")
    @Log(title = "房源小区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseVillage houseVillage)
    {
        return toAjax(houseVillageService.insertHouseVillage(houseVillage));
    }

    /**
     * 修改房源小区
     */
    @PreAuthorize("@ss.hasPermi('system:houseVillage:edit')")
    @Log(title = "房源小区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HouseVillage houseVillage)
    {
        return toAjax(houseVillageService.updateHouseVillage(houseVillage));
    }

    /**
     * 删除房源小区
     */
    @PreAuthorize("@ss.hasPermi('system:houseVillage:remove')")
    @Log(title = "房源小区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(houseVillageService.deleteHouseVillageByIds(ids));
    }
}
