package cn.source.web.controller.monitor;

import cn.source.common.core.domain.model.FlowModel;
import cn.source.common.core.redis.RedisCache;
import cn.source.common.enums.AccessType;
import cn.source.common.utils.DateUtils;
import cn.source.common.utils.StringUtils;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Series;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;

/**
 * @Description: echarts线图-Controller
 * @author: zy
 */
@Controller
@RequestMapping("/api/echarts")
public class EchartsController {

    @Autowired
    private RedisCache redisCache;

    /**
     * 折线图的 首页流量展示
     * @return
     */
    @GetMapping("/flowLine")
    @ResponseBody
    public String flowLine(){
        String title = "Last 7 day's IP";
        List<String> typeList = AccessType.getEumValueList();
        Option option = new GsonOption();
        List<Series> series = Lists.newArrayList();
        String[] weeks = new String[7];
        for (String val : typeList) {
            List<FlowModel> indexFlowModelList = Lists.newArrayList();
            for (int i = 6; i >= 0; i--) {
                // 定义pv.uv.ip标识
                String dataStr = DateUtils.getPreViewDateStrByNum(i);
                String ipFlow = "ipFlow:" + val + ":" + dataStr;
                // ipFlow进行ip去重
                HashSet ipSet = new HashSet<>();
                // 判断IP键是否存在
                if(StringUtils.isNotNull(redisCache.getCacheObject(ipFlow))){
                    ipSet = ((HashSet) redisCache.getCacheObject(ipFlow));
                }
                FlowModel indexFlowModel = new FlowModel();
                indexFlowModel.setIpFlowDay((long) ipSet.size());
                indexFlowModel.setFlowDate(dataStr);
                indexFlowModelList.add(indexFlowModel);
            }
            // 当天ip访问数
            Long[] datas = new Long[7];
            for (int i = 0; i < 7; i++) {
                weeks[i] = indexFlowModelList.get(i).getFlowDate();
                datas[i] = indexFlowModelList.get(i).getIpFlowDay();
            }
            //创建line对象
            Line line = new Line();
            line.name(val);
            for(int i = 0; i<datas.length;i++){
                line.data(datas[i]);
            }
            series.add(line);
        }
        option.series(series);
        option.title().text(title).x("left");
        option.legend().data(typeList).x("center");
        option.tooltip().show(true).trigger(Trigger.axis);
        option.toolbox().show(false).feature(Tool.magicType,Tool.dataZoom);
        CategoryAxis categoryAxis = new CategoryAxis();
        option.xAxis(categoryAxis);
        option.yAxis(new ValueAxis());
        categoryAxis.data(weeks);
        return option.toString();
    }
}
