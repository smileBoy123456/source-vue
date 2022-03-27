package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.HouseRoom;
import cn.source.system.service.IHouseRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 房源详情Controller
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@RestController
@RequestMapping("/system/houseRoom")
public class HouseRoomController extends BaseController
{
    @Autowired
    private IHouseRoomService houseRoomService;

    /**
     * 查询房源详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:list')")
    @GetMapping("/list")
    public TableDataInfo list(HouseRoom houseRoom)
    {
        startPage();
        List<HouseRoom> list = houseRoomService.selectHouseRoomList(houseRoom);
        return getDataTable(list);
    }

    /**
     * 导出房源详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:export')")
    @Log(title = "房源详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HouseRoom houseRoom)
    {
        List<HouseRoom> list = houseRoomService.selectHouseRoomList(houseRoom);
        ExcelUtil<HouseRoom> util = new ExcelUtil<HouseRoom>(HouseRoom.class);
        util.exportExcel(response, list, "房源详情数据");
    }

    /**
     * 获取房源详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(houseRoomService.selectHouseRoomById(id));
    }

    /**
     * 新增房源详情
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:add')")
    @Log(title = "房源详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseRoom houseRoom)
    {
        return toAjax(houseRoomService.insertHouseRoom(houseRoom));
    }

    /**
     * 修改房源详情
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:edit')")
    @Log(title = "房源详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HouseRoom houseRoom)
    {
        return toAjax(houseRoomService.updateHouseRoom(houseRoom));
    }

    /**
     * 删除房源详情
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:remove')")
    @Log(title = "房源详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(houseRoomService.deleteHouseRoomByIds(ids));
    }
}
