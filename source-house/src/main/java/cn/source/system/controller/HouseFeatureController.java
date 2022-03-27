package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.HouseFeature;
import cn.source.system.service.IHouseFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 房源特色Controller
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@RestController
@RequestMapping("/system/houseFeature")
public class HouseFeatureController extends BaseController
{
    @Autowired
    private IHouseFeatureService houseFeatureService;

    /**
     * 查询房源特色列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseFeature:list')")
    @GetMapping("/list")
    public TableDataInfo list(HouseFeature houseFeature)
    {
        startPage();
        List<HouseFeature> list = houseFeatureService.selectHouseFeatureList(houseFeature);
        return getDataTable(list);
    }

    /**
     * 导出房源特色列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseFeature:export')")
    @Log(title = "房源特色", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HouseFeature houseFeature)
    {
        List<HouseFeature> list = houseFeatureService.selectHouseFeatureList(houseFeature);
        ExcelUtil<HouseFeature> util = new ExcelUtil<HouseFeature>(HouseFeature.class);
        util.exportExcel(response, list, "房源特色数据");
    }

    /**
     * 获取房源特色详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseFeature:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(houseFeatureService.selectHouseFeatureById(id));
    }

    /**
     * 新增房源特色
     */
    @PreAuthorize("@ss.hasPermi('system:houseFeature:add')")
    @Log(title = "房源特色", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseFeature houseFeature)
    {
        return toAjax(houseFeatureService.insertHouseFeature(houseFeature));
    }

    /**
     * 修改房源特色
     */
    @PreAuthorize("@ss.hasPermi('system:houseFeature:edit')")
    @Log(title = "房源特色", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HouseFeature houseFeature)
    {
        return toAjax(houseFeatureService.updateHouseFeature(houseFeature));
    }

    /**
     * 删除房源特色
     */
    @PreAuthorize("@ss.hasPermi('system:houseFeature:remove')")
    @Log(title = "房源特色", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(houseFeatureService.deleteHouseFeatureByIds(ids));
    }
}
