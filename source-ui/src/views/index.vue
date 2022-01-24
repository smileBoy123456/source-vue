<template>
  <div class="dashboard-editor-container">
    <panel-group @handleSetLineChartData="handleSetLineChartData" />

    <el-row style="background: #fff; padding: 16px 16px 0; margin-bottom: 32px">
      <line-chart :chart-data="lineChartData" />
    </el-row>
  </div>
</template>

<script>
import PanelGroup from "./dashboard/PanelGroup";
import LineChart from "./dashboard/LineChart";

const lineChartData = {
  newVisitis: {
    data1: [100, 120, 161, 134, 105, 160, 165],
    data2: [120, 82, 91, 154, 162, 140, 145],
    data3: [200, 192, 120, 144, 160, 130, 140],
    data4: [180, 160, 151, 106, 145, 150, 130],
  },
  messages: {
    data1: [200, 192, 120, 144, 160, 130, 140],
    data2: [180, 160, 151, 106, 145, 150, 130],
    data3: [200, 192, 120, 144, 160, 130, 140],
    data4: [180, 160, 151, 106, 145, 150, 130],
  },
  purchases: {
    data1: [80, 100, 121, 104, 105, 90, 100],
    data2: [120, 90, 100, 138, 142, 130, 130],
    data3: [200, 192, 120, 144, 160, 130, 140],
    data4: [180, 160, 151, 106, 145, 150, 130],
  },
  shoppings: {
    data1: [130, 140, 141, 142, 145, 150, 160],
    data2: [120, 82, 91, 154, 162, 140, 130],
    data3: [200, 192, 120, 144, 160, 130, 140],
    data4: [180, 160, 151, 106, 145, 150, 130],
  },
};

export default {
  name: "Index",
  components: {
    PanelGroup,
    LineChart,
  },
  data() {
    return {
      lineChartData: lineChartData.newVisitis,
    };
  },
  methods: {
    handleSetLineChartData(type) {
      this.lineChartData = lineChartData[type];
    },
  },
};
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: #fff;
  position: relative;

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width: 1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
</style>
