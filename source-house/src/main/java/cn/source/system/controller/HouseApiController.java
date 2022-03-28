package cn.source.system.controller;

import cn.source.common.constant.HttpStatus;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.system.domain.HouseRoom;
import cn.source.system.domain.HouseVillage;
import cn.source.system.service.IHouseRoomService;
import cn.source.system.service.IHouseVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: cms api控制类
 * @author: 詹Sir
 */
@RestController
@RequestMapping("/api/houseApi")
public class HouseApiController extends BaseController {

    @Autowired
    private IHouseVillageService houseVillageService;

    @Autowired
    private IHouseRoomService houseRoomService;

    /**
     * @Description: 获取文章列表
     */
    @GetMapping("/findVillageList")
    public TableDataInfo findVillageList(HouseVillage houseVillage)
    {
        startPage();
        List<HouseVillage> list = houseVillageService.selectHouseVillageList(houseVillage);
        return getDataTable(list);
    }

    /**
     * @Description: 获取文章列表
     */
    @GetMapping("/findHouseRoomList")
    public TableDataInfo findHouseRoomList(HouseRoom houseRoom)
    {
        startPage();
        List<HouseRoom> list = houseRoomService.selectHouseRoomList(houseRoom);
        return getDataTable(list);
    }


    /**
     * @Description: 添加房源信息
     */
    @PostMapping("/saveHouse")
    public AjaxResult saveHouse(@RequestBody HouseRoom houseRoom)
    {
        String msg = "房源添加成功";
        houseRoomService.apiInsertHouseRoom(houseRoom);
        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS,msg,houseRoom);
        return ajaxResult;
    }

    /**
     * @Description: 获取房源信息by id
     */
    @GetMapping("/findHouseById")
    @ResponseBody
    public AjaxResult findHouseById(@RequestParam Long id)
    {
        String msg = "房源查找成功";
        HouseRoom houseRoom = houseRoomService.selectHouseRoomById(id);
        houseRoom = houseRoomService.selectDetailHouseRoom(houseRoom);
        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS,msg,houseRoom);
        return ajaxResult;
    }


}
