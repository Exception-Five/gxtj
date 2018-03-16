<template>
  <div :class="className" :id="id" :style="{height:height,width:width}" ref="myEchart">
  </div>
</template>
<script>
import echarts from 'echarts'
import {getUserMod,requestLogin} from '../../api/api.js'
export default {
  props: {
    className: {
      type: String,
      default: 'yourClassName'
    },
    id: {
      type: String,
      default: 'yourID'
    },
    width: {
      type: String,
      default: '500px'
    },
    height: {
      type: String,
      default: '500px'
    }
  },
  data() {
    return {
        userMod: '',
        chart: null,
        echartsData: []
    }
  },
  mounted() {
    requestLogin({
        'username': 'yaojiayang',
        'password': '123456'
    }).then(res => {
        if(res.data.status === 1){
            getUserMod().then((res)=>{
                console.log(res)
                let userMod = res.result
                this.echartsData.push({
                    value:userMod.entertainment, name:'娱乐'
                })
                this.echartsData.push({
                    value:userMod.politics, name:'政治'
                })
                this.echartsData.push({
                    value:userMod.sports, name:'运动',
                })
                this.echartsData.push({
                    value:userMod.business, name:'商业',
                })
                this.echartsData.push({
                    value:userMod.technology, name:'技术',
                })
                this.echartsData.push({
                    value:userMod.car, name:'汽车',
                })
                this.echartsData.push({
                    value:userMod.military , name:'军事',
                })
                this.echartsData.push({
                    value:userMod.travel, name:'旅行',
                })
                this.echartsData.push({
                    value:userMod.life, name:'生活',
                })
                this.echartsData.push({
                    value:userMod.other, name:'其他',
                })
                this.initChart();

            })
        }else if(res.data.status === -1){
            
        }
    })

  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose();
    this.chart = null;
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$refs.myEchart);
      // 把配置和数据放这里
      let echartsData = this.echartsData
      this.chart.setOption({
        backgroundColor: '#2c343c',

        title: {
            text: 'Customized Pie',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        visualMap: {
            show: false,
            min: 0,
            max: 100,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'访问来源',
                type:'pie',
                radius : '55%',
                center: ['50%', '50%'],
                // data:[
                //     {value:1, name:'直接访问'},
                //     {value:0, name:'邮件营销'},
                //     {value:1, name:'联盟广告'},
                //     {value:1, name:'视频广告'},
                //     {value:2, name:'搜索引擎'}
                // ].sort(function (a, b) { return a.value - b.value; }),
                data:echartsData.sort(function (a, b) { return a.value - b.value; }),
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#c23531',
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
      })
    }
  }
}
</script>