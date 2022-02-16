package cn.source.web.controller.monitor;

import cn.source.common.constant.HttpStatus;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.domain.model.FlowModel;
import cn.source.common.core.redis.RedisCache;
import cn.source.common.utils.DateUtils;
import cn.source.common.utils.StringUtils;
import cn.source.common.utils.ip.IpUtils;
import cn.source.common.utils.uuid.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

/**
 * 系统访问流量
 *
 * @author zy
 */
@RestController
@RequestMapping("/api/flow")
public class SysFlowController extends BaseController {

    @Autowired
    private RedisCache redisCache;

    /**
     * @Description: 系统访问量
     * @author: zy
     */
    @GetMapping("/findFlow")
    @ResponseBody
    public FlowModel findFlow() {
        String today = DateUtils.getDate();
        // 定义pv.uv.ip标识，如果redis中存在，则加1，否则初始1
        String pvFlow = "pvFlow:" + today;
        String uvFlow = "uvFlow:" + today;
        String ipFlow = "ipFlow:" + today;
        String ipAllFlow = "ipFlowAll";
        // pvFlow进行累计操作
        Long pvFlowNum = 0L;
        if (StringUtils.isNotNull(redisCache.getCacheObject(pvFlow))) {
            pvFlowNum = Long.valueOf(redisCache.getCacheObject(pvFlow).toString());
        }
        // uvFlow进行cookie去重
        HashSet uvSet = new HashSet<>();
        if (StringUtils.isNotNull(redisCache.getCacheObject(uvFlow))) {
            uvSet = ((HashSet) redisCache.getCacheObject(uvFlow));
        }
        // ipFlow进行ip去重
        HashSet ipSet = new HashSet<>();
        // 判断IP键是否存在
        if (StringUtils.isNotNull(redisCache.getCacheObject(ipFlow))) {
            ipSet = ((HashSet) redisCache.getCacheObject(ipFlow));
        }

        HashSet ipAllSet = new HashSet<>();
        if (StringUtils.isNotNull(redisCache.getCacheObject(ipAllFlow))) {
            ipAllSet = ((HashSet) redisCache.getCacheObject(ipAllFlow));
        }

        FlowModel flowModel = new FlowModel();
        flowModel.setIpFlowDay((long) ipSet.size());
        // ip合计
        flowModel.setIpAllFlow((long) ipAllSet.size());
        flowModel.setUvFlowDay((long) uvSet.size());
        flowModel.setPvFlowDay(pvFlowNum);
        flowModel.setFlowDate(today);
        return flowModel;
    }

    /**
     * @Description: 保存流量信息
     * @author: zy
     * @Return: 返回uv标识
     */
    @PostMapping("/upFlow")
    @ResponseBody
    public AjaxResult upFlow(HttpServletRequest request) {
        String msg = "流量累积中";
        // 定义pv.uv.ip标识，如果redis中存在，则加1，否则初始1
        String pvFlow = "pvFlow:" + DateUtils.getDate();
        String uvFlow = "uvFlow:" + DateUtils.getDate();
        String ipFlow = "ipFlow:" + DateUtils.getDate();
        String type = request.getParameter("type");
        String ipTypeFlow = "ipFlow:" +type+":"+ DateUtils.getDate();
        String ipAllFlow = "ipFlowAll";
        // pvFlow进行累计操作
        Integer pvFlowNum = 1;
        if (StringUtils.isNull(redisCache.getCacheObject(pvFlow))) {
            redisCache.setCacheObject(pvFlow, pvFlowNum);
        } else {
            redisCache.setCacheObject(pvFlow, (Integer) redisCache.getCacheObject(pvFlow) + 1);
        }

        // uvFlow进行cookie去重
        HashSet uvSet = new HashSet<>();
        if (StringUtils.isNotNull(redisCache.getCacheObject(uvFlow))) {
            uvSet = ((HashSet) redisCache.getCacheObject(uvFlow));
        }

        String uvCode = request.getParameter("uvCode");
        if (StringUtils.isEmpty(uvCode)) {
            uvCode = CodeUtil.getCode();
        }
        uvSet.add(uvCode);
        redisCache.setCacheObject(uvFlow, uvSet);

        // ipFlow进行ip去重
        String ipAddr = IpUtils.getIpAddr(request);
        HashSet ipSet = new HashSet<>();
        // 判断IP键是否存在
        if (StringUtils.isNotNull(redisCache.getCacheObject(ipFlow))) {
            ipSet = ((HashSet) redisCache.getCacheObject(ipFlow));
        }
        ipSet.add(ipAddr);
        redisCache.setCacheObject(ipFlow, ipSet);

        // ip类型,来源
        HashSet ipTypeSet = new HashSet<>();
        // 判断IP键是否存在
        if (StringUtils.isNotNull(redisCache.getCacheObject(ipTypeFlow))) {
            ipTypeSet = ((HashSet) redisCache.getCacheObject(ipTypeFlow));
        }
        ipTypeSet.add(ipAddr);
        redisCache.setCacheObject(ipTypeFlow, ipTypeSet);

        // 判断合计IP键是否存在
        HashSet ipAllSet = new HashSet<>();
        if (StringUtils.isNotNull(redisCache.getCacheObject(ipAllFlow))) {
            ipAllSet = ((HashSet) redisCache.getCacheObject(ipAllFlow));
        }
        ipAllSet.add(ipAddr);
        redisCache.setCacheObject(ipAllFlow, ipAllSet);

        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS, msg, uvCode);
        return ajaxResult;
    }
}
