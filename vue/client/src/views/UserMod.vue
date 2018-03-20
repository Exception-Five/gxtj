<template>
  <section id="search">
    <VHeader 
    :isLogined="isLogined" 
    :userInfo="userInfo" 
    :isLoginShow="isLoginShow"
    :isRegisterShow="isRegisterShow"
    :isSearchShow="isSearchShow"
    @handleForm="handleForm"
    @closeForm="closeForm"
    @loginConfirm="loginConfirm"
    @registerConfirm="registerConfirm"
    @logout="logout"
    @handleSearch="handleSearch"
    ></VHeader>
<div class="placeholder-height"></div>
<div class="edit-warp" id="per_center" style="text-align:left">
    <div class="user-container" style="min-height: 700px;">
        <div class="go-back"><router-link :to="`/`"><i class="icon icon-go-back"></i>返回主站</router-link></div>

        <div class="nav-warp">
            <ul>
                <li class=""><a href="#"></a></li>
                <li class="active"><a href="#">兴趣统计</a></li>
                <li class=""><a href="#"></a></li>
            </ul>
        </div>
        <div class="section-box">
            <div class="user-face-box">
                <!-- <img src="https://img.huxiucdn.com/auth/data/avatar/2.jpg"> -->
                <img :src="`${userInfo.userImageUrl}`" :onerror="defaultAvatar">
            </div>
            <!-- <a class="edit-face" href="/user/setting/account.html#mdf_head">点击更换头像</a> -->
        </div>

<!-- 兴趣模型 -->
<div class="echarts-wrapper">
  <div style="display:table-cell;vertical-align:middle" :class="className" :id="id" :style="{height:height,width:width}" ref="myEchart">
  </div>
</div>

</div>
    <div style="height: 60px">
    </div>
</div>
<div style="clear:both;"></div>
<VFooter></VFooter>
  </section>
</template>
<script>
import {getUserInfoById,requestLogin, requestRegister,getUserMod} from '../api/api.js'
import echarts from 'echarts'
import VFooter from '@/components/Footer.vue'

import VHeader from '@/components/Header.vue'
import VueNotifications from 'vue-notifications'

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
            default: '600px'
        },
        height: {
            type: String,
            default: '600px'
        }
    },
    data(){
	  return{
		userInfo: {
			userId:1,
			username: "",
			password: "",
			nickname: "",
			userMail: "",
			userGroupId: 1
		},
		isLogined: false,
		isLoginShow: false,
        isRegisterShow: false,
        isSearchShow: false,
        defaultAvatar: 'this.src="https://img.huxiucdn.com/auth/data/avatar/2.jpg"',

        userMod: '',
        chart: null,
        echartsData: []
	  }
  },
  components: {VHeader,VFooter},
  mounted(){
    let token = window.localStorage.getItem("token")
    if(token!=null&&token!=""){
        // this.userInfo = JSON.parse(window.localStorage.getItem("user"))
        this.userInfo.userId = window.localStorage.getItem("user");
        getUserInfoById(this.userInfo.userId).then(res=>{
            if(res.status === 1){
                this.userInfo = res.result
            }
        })
        this.isLogined = true
    }else{
        this.handleForm(0)
    }
    
    getUserMod().then((res)=>{
        console.log(res)
        //娱乐  政治  运动  商业  技术  汽车 军事  旅行   生活  其他 
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
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose();
    this.chart = null;
  },
  methods: {
    /* header方法 */
    handleForm(...data) {
        console.log(data)
        console.log("dsadsadsa")
        if(data[0] === 0){//点击登录
            this.isLoginShow = true
            this.isRegisterShow = false
        }else if(data[0] === 1){//点击注册
            this.isLoginShow = false
            this.isRegisterShow = true
        }
    },
    closeForm() {
        this.isLoginShow = false
        this.isRegisterShow = false
    },
    loginConfirm () {
        requestLogin(this.userInfo).then(res => {
            console.log(res)
            if(res.data.status === 1){
                this.isLoginShow = false
                this.isLogined = true
                getUserInfoById(window.localStorage.getItem("user")).then(res=>{
                if(res.status === 1){
                    this.userInfo = res.result
                    this.showSuccessMsg({title:"成功",message:"登录成功"})
                }
            })
            // this.userInfo = JSON.parse(window.localStorage.getItem("user"))
            }else if(res.data.status === -1){
                this.showErrorMsg({title:"失败",message:"用户名不存在"})
            }
        })
    },
    registerConfirm () {
        let param = this.userInfo
        requestRegister(param).then(res => {
            console.log(res)
            if(res.status === 1){
                alert("已成功向您的邮箱发送帐号激活邮件,请确认")
            }else{
                alert("发送邮件失败")
            }
        })
    },
    logout () {
        window.localStorage.removeItem("token")
        window.localStorage.removeItem("user")
        this.isLogined = false
    },        
    handleSearch(...data){
        if(data[0] === 0){//关闭
            this.isSearchShow = false
        }else if(data[0] === 1){
            this.isSearchShow = true
        }    
    },
    initChart() {
      this.chart = echarts.init(this.$refs.myEchart);
      // 把配置和数据放这里
      let echartsData = this.echartsData
      this.chart.setOption({
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x : 'center',
            y : 'bottom',
            data:['娱乐','政治','运动','商业','技术','汽车','军事','旅行', '生活', '其他']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore : {show: false},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'面积模式',
                type:'pie',
                radius : [40, 200],
                center : ['50%', '50%'],
                roseType : 'area',
                // data:[
                //     {value:10, name:'rose1'},
                //     {value:5, name:'rose2'},
                //     {value:15, name:'rose3'},
                //     {value:25, name:'rose4'},
                //     {value:20, name:'rose5'},
                //     {value:35, name:'rose6'},
                //     {value:30, name:'rose7'},
                //     {value:40, name:'rose8'}
                // ]
                data: this.echartsData
            }
        ]
      })
    }
  }
}
</script>
<style>
@import '../assets/bootstrap/css/bootstrap.min.css';
@import '../assets/css/build.css';
@import '../assets/css/login.css';
@import '../assets/css/dlzc.css';
@import '../assets/css/zzsc.css';
@import '../assets/css/userinfo.css';

#index{
    font-size: 14px;
}
li.nav-news.js-show-menu ul{position: absolute; visibility: hidden; background:#fff; width:250px;  top:60px; left:-50px; z-index:9999; box-shadow:0 1px 15px rgba(18,21,21,.2);padding:10px 5px;}
#jsddm ul li{ float:left; width:105px; padding-left:20px; line-height:40px;}
.echarts-wrapper{
    display: table;
    width: 100%;
}
</style>

