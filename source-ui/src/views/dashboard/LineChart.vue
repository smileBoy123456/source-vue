<template>
  <div :class="className" :style="{ height: height, width: width }" />
</template>

<script>
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
import resize from "./mixins/resize";

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: "chart",
    },
    width: {
      type: String,
      default: "100%",
    },
    height: {
      type: String,
      default: "350px",
    },
    autoResize: {
      type: Boolean,
      default: true,
    },
    chartData: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      chart: null,
    };
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.setOptions(val);
      },
    },
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart();
    });
  },
  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, "macarons");
      this.setOptions(this.chartData);
    },
    setOptions({ data1, data2, data3, data4 } = {}) {
      this.chart.setOption({
        xAxis: {
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
          boundaryGap: false,
          axisTick: {
            show: false,
          },
        },
        grid: {
          left: 10,
          right: 10,
          bottom: 20,
          top: 50,
          containLabel: true,
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
          },
          padding: [5, 10],
        },
        yAxis: {
          axisTick: {
            show: false,
          },
        },
        legend: {
          data: ["PC", "Mobile", "Mini", "APP"],
        },
        series: [
          {
            name: "PC",
            itemStyle: {
              normal: {
                color: "#a9d18f",
                lineStyle: {
                  color: "#a9d18f",
                  width: 2,
                },
              },
            },
            smooth: true,
            type: "line",
            data: data1,
            animationDuration: 2800,
            animationEasing: "cubicInOut",
          },
          {
            name: "Mobile",
            smooth: true,
            type: "line",
            itemStyle: {
              normal: {
                color: "#f9cbad",
                lineStyle: {
                  color: "#f9cbad",
                  width: 2,
                },
              },
            },
            data: data2,
            animationDuration: 2800,
            animationEasing: "quadraticOut",
          },
          {
            name: "Mini",
            itemStyle: {
              normal: {
                color: "#a97eb3",
                lineStyle: {
                  color: "#a97eb3",
                  width: 2,
                },
              },
            },
            smooth: true,
            type: "line",
            data: data3,
            animationDuration: 2800,
            animationEasing: "cubicInOut",
          },
          {
            name: "APP",
            smooth: true,
            type: "line",
            itemStyle: {
              normal: {
                color: "#5a9bd5",
                lineStyle: {
                  color: "#5a9bd5",
                  width: 2,
                },
              },
            },
            data: data4,
            animationDuration: 2800,
            animationEasing: "quadraticOut",
          },
        ],
      });
    },
  },
};
</script>
