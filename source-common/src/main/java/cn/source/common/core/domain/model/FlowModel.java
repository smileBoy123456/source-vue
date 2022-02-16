package cn.source.common.core.domain.model;

/**
 * @Description: 首页展示流量模型
 * @author: zy
 */
public class FlowModel {

    // ip日流量
    private Long ipFlowDay;

    // ip总流量
    private Long ipAllFlow;

    private Long uvFlowDay;

    private Long pvFlowDay;

    private String flowDate;

    public Long getIpFlowDay() {
        return ipFlowDay;
    }

    public void setIpFlowDay(Long ipFlowDay) {
        this.ipFlowDay = ipFlowDay;
    }

    public Long getIpAllFlow() {
        return ipAllFlow;
    }

    public void setIpAllFlow(Long ipAllFlow) {
        this.ipAllFlow = ipAllFlow;
    }

    public Long getUvFlowDay() {
        return uvFlowDay;
    }

    public void setUvFlowDay(Long uvFlowDay) {
        this.uvFlowDay = uvFlowDay;
    }

    public Long getPvFlowDay() {
        return pvFlowDay;
    }

    public void setPvFlowDay(Long pvFlowDay) {
        this.pvFlowDay = pvFlowDay;
    }

    public String getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(String flowDate) {
        this.flowDate = flowDate;
    }
}
