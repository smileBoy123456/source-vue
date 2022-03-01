package cn.source.system.controller;

import cn.source.system.domain.CmsServiceItem;
import cn.source.system.service.ICmsServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: cms api控制类
 * @author: 詹Sir
 */
@RestController
@RequestMapping("/api/cmsApi")
public class CmsApiController {

    @Autowired
    private ICmsServiceItemService cmsServiceItemService;

    /**
     * 根据类型获取服务内容
     * @return
     */
    @GetMapping("/getServiceItem")
    public CmsServiceItem getServiceItmeByType(CmsServiceItem cmsServiceItem){
        List<CmsServiceItem> list = cmsServiceItemService.selectCmsServiceItemList(cmsServiceItem);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
