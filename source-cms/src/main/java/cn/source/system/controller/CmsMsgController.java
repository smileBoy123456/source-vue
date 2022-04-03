package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.CmsMsg;
import cn.source.system.service.ICmsMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 消息管理Controller
 *
 * @author 詹Sir
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/system/msg")
public class CmsMsgController extends BaseController
{
    @Autowired
    private ICmsMsgService cmsMsgService;

    /**
     * 查询消息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:msg:list')")
    @GetMapping("/list")
    public TableDataInfo list(CmsMsg cmsMsg)
    {
        startPage();
        List<CmsMsg> list = cmsMsgService.selectCmsMsgList(cmsMsg);
        return getDataTable(list);
    }

    /**
     * 导出消息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:msg:export')")
    @Log(title = "消息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CmsMsg cmsMsg)
    {
        List<CmsMsg> list = cmsMsgService.selectCmsMsgList(cmsMsg);
        ExcelUtil<CmsMsg> util = new ExcelUtil<CmsMsg>(CmsMsg.class);
        util.exportExcel(response, list, "消息管理数据");
    }

    /**
     * 获取消息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:msg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cmsMsgService.selectCmsMsgById(id));
    }

    /**
     * 新增消息管理
     */
    @PreAuthorize("@ss.hasPermi('system:msg:add')")
    @Log(title = "消息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CmsMsg cmsMsg)
    {
        return toAjax(cmsMsgService.insertCmsMsg(cmsMsg));
    }

    /**
     * 修改消息管理
     */
    @PreAuthorize("@ss.hasPermi('system:msg:edit')")
    @Log(title = "消息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CmsMsg cmsMsg)
    {
        return toAjax(cmsMsgService.updateCmsMsg(cmsMsg));
    }

    /**
     * 删除消息管理
     */
    @PreAuthorize("@ss.hasPermi('system:msg:remove')")
    @Log(title = "消息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cmsMsgService.deleteCmsMsgByIds(ids));
    }
}
