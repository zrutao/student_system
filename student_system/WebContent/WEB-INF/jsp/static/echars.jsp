<%@ page pageEncoding="UTF-8"%><!-- 防止乱码 -->

<script type="text/javascript">
					var stu_class=${class_name};
					var dom = document.getElementById("container1");
					var myChart = echarts.init(dom);
					option = null;
					option = {
					    title: {
					        text: '一年级'
					    },
					    tooltip: {
					        trigger: 'axis'
					    },
					    legend: {
					        data:['语文','数学','总评']
					    },
					    grid: {
					        left: '3%',
					        right: '4%',
					        bottom: '3%',
					        containLabel: true
					    },
					    toolbox: {
					        feature: {
					            saveAsImage: {}
					        }
					    },
					    xAxis: {
					        type: 'category',
					        boundaryGap: false,
					        data: stu_class
					    },
					    yAxis: {
					        type: 'value'
					    },
					    series: [
					        {
					            name:'语文',
					            type:'line',
					            smooth: true,
					            data:[80.56, 81.21, 79.60, 82.01, 80.33, 81.02, 80.99, 82.01, 81.75, 79.96]
					        },
					        {
					            name:'数学',
					            type:'line',
					            smooth: true,
					            data:[90.56, 91.21, 89.60, 92.01, 90.33, 91.02, 90.99, 92.01, 91.75, 89.96]
					        },
					        {
					            name:'总评',
					            type:'line',
					            smooth: true,
					            data:[85.56, 86.21, 84.60, 87.01, 85.33, 86.02, 85.99, 87.01, 86.75, 84.96]
					        }
					    ]
					};
					;
					if (option && typeof option === "object") {
					    myChart.setOption(option, true);
					}
				</script>