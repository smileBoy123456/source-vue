package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.HouseImage;
import cn.source.system.service.IHouseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 房源图片Controller
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@RestController
@RequestMapping("/system/houseImage")
public class HouseImageController extends BaseController
{
    @Autowired
    private IHouseImageService houseImageService;

    /**
     * 查询房源图片列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseImage:list')")
    @GetMapping("/list")
    public TableDataInfo list(HouseImage houseImage)
    {
        startPage();
        List<HouseImage> list = houseImageService.selectHouseImageList(houseImage);
        return getDataTable(list);
    }

    /**
     * 导出房源图片列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseImage:export')")
    @Log(title = "房源图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HouseImage houseImage)
    {
        List<HouseImage> list = houseImageService.selectHouseImageList(houseImage);
        ExcelUtil<HouseImage> util = new ExcelUtil<HouseImage>(HouseImage.class);
        util.exportExcel(response, list, "房源图片数据");
    }

    /**
     * 获取房源图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseImage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(houseImageService.selectHouseImageById(id));
    }

    /**
     * 新增房源图片
     */
    @PreAuthorize("@ss.hasPermi('system:houseImage:add')")
    @Log(title = "房源图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseImage houseImage)
    {
        return toAjax(houseImageService.insertHouseImage(houseImage));
    }

    /**
     * 修改房源图片
     */
    @PreAuthorize("@ss.hasPermi('system:houseImage:edit')")
    @Log(title = "房源图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HouseImage houseImage)
    {
        return toAjax(houseImageService.updateHouseImage(houseImage));
    }

    /**
     * 删除房源图片
     */
    @PreAuthorize("@ss.hasPermi('system:houseImage:remove')")
    @Log(title = "房源图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(houseImageService.deleteHouseImageByIds(ids));
    }
}
