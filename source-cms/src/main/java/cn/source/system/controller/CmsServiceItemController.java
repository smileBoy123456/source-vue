package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.CmsServiceItem;
import cn.source.system.service.ICmsServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 服务条目Controller
 *
 * @author 詹Sir
 * @date 2022-02-25
 */
@RestController
@RequestMapping("/system/item")
public class CmsServiceItemController extends BaseController
{
    @Autowired
    private ICmsServiceItemService cmsServiceItemService;

    /**
     * 查询服务条目列表
     */
    @PreAuthorize("@ss.hasPermi('system:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsServiceItem cmsServiceItem)
    {
        startPage();
        List<CmsServiceItem> list = cmsServiceItemService.selectCmsServiceItemList(cmsServiceItem);
        return getDataTable(list);
    }

    /**
     * 导出服务条目列表
     */
    @PreAuthorize("@ss.hasPermi('system:item:export')")
    @Log(title = "服务条目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsServiceItem cmsServiceItem)
    {
        List<CmsServiceItem> list = cmsServiceItemService.selectCmsServiceItemList(cmsServiceItem);
        ExcelUtil<CmsServiceItem> util = new ExcelUtil<CmsServiceItem>(CmsServiceItem.class);
        util.exportExcel(response, list, "服务条目数据");
    }

    /**
     * 获取服务条目详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cmsServiceItemService.selectCmsServiceItemById(id));
    }

    /**
     * 新增服务条目
     */
    @PreAuthorize("@ss.hasPermi('system:item:add')")
    @Log(title = "服务条目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsServiceItem cmsServiceItem)
    {
        return toAjax(cmsServiceItemService.insertCmsServiceItem(cmsServiceItem));
    }

    /**
     * 修改服务条目
     */
    @PreAuthorize("@ss.hasPermi('system:item:edit')")
    @Log(title = "服务条目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsServiceItem cmsServiceItem)
    {
        return toAjax(cmsServiceItemService.updateCmsServiceItem(cmsServiceItem));
    }

    /**
     * 删除服务条目
     */
    @PreAuthorize("@ss.hasPermi('system:item:remove')")
    @Log(title = "服务条目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cmsServiceItemService.deleteCmsServiceItemByIds(ids));
    }
}
