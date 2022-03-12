package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.CmsLink;
import cn.source.system.service.ICmsLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 友情链接Controller
 *
 * @author 詹Sir
 * @date 2022-03-12
 */
@RestController
@RequestMapping("/system/link")
public class CmsLinkController extends BaseController
{
    @Autowired
    private ICmsLinkService cmsLinkService;

    /**
     * 查询友情链接列表
     */
    @PreAuthorize("@ss.hasPermi('system:link:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsLink cmsLink)
    {
        startPage();
        List<CmsLink> list = cmsLinkService.selectCmsLinkList(cmsLink);
        return getDataTable(list);
    }

    /**
     * 导出友情链接列表
     */
    @PreAuthorize("@ss.hasPermi('system:link:export')")
    @Log(title = "友情链接", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsLink cmsLink)
    {
        List<CmsLink> list = cmsLinkService.selectCmsLinkList(cmsLink);
        ExcelUtil<CmsLink> util = new ExcelUtil<CmsLink>(CmsLink.class);
        util.exportExcel(response, list, "友情链接数据");
    }

    /**
     * 获取友情链接详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:link:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cmsLinkService.selectCmsLinkById(id));
    }

    /**
     * 新增友情链接
     */
    @PreAuthorize("@ss.hasPermi('system:link:add')")
    @Log(title = "友情链接", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsLink cmsLink)
    {
        return toAjax(cmsLinkService.insertCmsLink(cmsLink));
    }

    /**
     * 修改友情链接
     */
    @PreAuthorize("@ss.hasPermi('system:link:edit')")
    @Log(title = "友情链接", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsLink cmsLink)
    {
        return toAjax(cmsLinkService.updateCmsLink(cmsLink));
    }

    /**
     * 删除友情链接
     */
    @PreAuthorize("@ss.hasPermi('system:link:remove')")
    @Log(title = "友情链接", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cmsLinkService.deleteCmsLinkByIds(ids));
    }
}
