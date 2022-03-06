package cn.source.system.controller;

import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.system.domain.CmsArticle;
import cn.source.system.domain.CmsServiceItem;
import cn.source.system.service.ICmsArticleService;
import cn.source.system.service.ICmsServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: cms api控制类
 * @author: 詹Sir
 */
@RestController
@RequestMapping("/api/cmsApi")
public class CmsApiController extends BaseController {

    @Autowired
    private ICmsServiceItemService cmsServiceItemService;

    @Autowired
    private ICmsArticleService cmsArticleService;

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

    /**
     * @Description: 获取文章列表
     * @author: zy
     */
    @GetMapping("/findArticleList")
    public TableDataInfo findArticleList(CmsArticle cmsArticle)
    {
        startPage();
        List<CmsArticle> list = cmsArticleService.selectCmsArticleList(cmsArticle);
        return getDataTable(list);
    }

    /**
     * 获取文章详细信息
     */
    @GetMapping(value = "/getArticle/{id}")
    public AjaxResult getArticle(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cmsArticleService.selectCmsArticleById(id));
    }

    /**
    * @Description: 点赞
    * @author: zy
    */
    @PostMapping("/starArticle")
    public AjaxResult starArticle(CmsArticle cmsArticle)
    {
        return toAjax(cmsArticleService.starCmsArticle(cmsArticle));
    }

}
