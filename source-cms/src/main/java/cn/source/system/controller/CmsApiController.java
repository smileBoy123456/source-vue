package cn.source.system.controller;

import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.utils.ip.IpUtils;
import cn.source.system.domain.CmsArticle;
import cn.source.system.domain.CmsFeedback;
import cn.source.system.domain.CmsLink;
import cn.source.system.domain.CmsServiceItem;
import cn.source.system.service.ICmsArticleService;
import cn.source.system.service.ICmsFeedbackService;
import cn.source.system.service.ICmsLinkService;
import cn.source.system.service.ICmsServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private ICmsFeedbackService cmsFeedbackService;

    @Autowired
    private ICmsLinkService cmsLinkService;

    /**
     * 根据类型获取服务内容
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
    */
    @PostMapping("/starArticle")
    public AjaxResult starArticle(CmsArticle cmsArticle)
    {
        return toAjax(cmsArticleService.starCmsArticle(cmsArticle));
    }

    /**
     * @Description: 反馈
     */
    @PostMapping("/saveCmsFeedback")
    public AjaxResult saveCmsFeedback(HttpServletRequest request,CmsFeedback cmsFeedback)
    {
        cmsFeedback.setCreateBy(IpUtils.getIpAddr(request));
        return toAjax(cmsFeedbackService.insertCmsFeedback(cmsFeedback));
    }

    /**
     * @Description: 申请友链
     */
    @PostMapping("/submitLink")
    public AjaxResult submitLink(HttpServletRequest request,CmsLink cmsLink)
    {
        cmsLink.setCreateBy(IpUtils.getIpAddr(request));
        return toAjax(cmsLinkService.insertCmsLink(cmsLink));
    }

    /**
     * @Description: 获取友链列表
     */
    @GetMapping("/findLinkList")
    public TableDataInfo findLinkList(CmsLink cmsLink)
    {
        startPage();
        List<CmsLink> list = cmsLinkService.selectCmsLinkList(cmsLink);
        return getDataTable(list);
    }
}
